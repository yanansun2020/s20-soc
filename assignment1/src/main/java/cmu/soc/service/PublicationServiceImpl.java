package cmu.soc.service;

import cmu.soc.dao.PublicationMapper;
import cmu.soc.dao.entity.Author;
import cmu.soc.dao.entity.PubAuthor;
import cmu.soc.dao.entity.Publication;
import cmu.soc.lucene.LucenceService;
import cmu.soc.lucene.SearchRegion;
import cmu.soc.model.SearchPublicationYear;
import cmu.soc.parser.PaperDtd;
import cmu.soc.parser.PaperDtdAttribute;
import cmu.soc.parser.XmlParser;
import cmu.soc.util.ReflectionUtil;
import cmu.soc.util.SqlSessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PublicationServiceImpl implements PublicationService {
    private static final String SEP = "\\$";
    private XmlParser xmlParser = new XmlParser();
    private static SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    private static PublicationMapper publicationMapper = sqlSession.getMapper(PublicationMapper.class);
    private LucenceService lucenceService = new LucenceService();

    public void addPublicationAndAuthor(String filePath) {
        try {
            List<PaperDtd> paperDtdList = xmlParser.parse(filePath);
            for (PaperDtd paperDtd : paperDtdList) {
                Long pubId = addPublication(paperDtd);
                List<Long> authorIds = addAuthor(paperDtd);
                addPubAuthors(pubId, authorIds);
                sqlSession.commit();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }

    public List<String> getCoAuthors(String author) {
        if (StringUtils.isEmpty(author)) {
            return Collections.emptyList();
        }
        List<Author> authorExist = publicationMapper.getCoAuthors(author);
        return authorExist.stream().map(Author::getName).collect(Collectors.toList());
    }

    @Override
    public List<Publication> getPublications(String title) {
        if (StringUtils.isEmpty(title)) {
            return Collections.emptyList();
        }
        Publication searchVo = new Publication();
        searchVo.setTitle(title);
        List<Publication> publications = publicationMapper.getPubsByTitle(searchVo);
        if (publications == null || publications.size() == 0) {
            return Collections.emptyList();
        }
        buildAuthorsAndType(publications);
        return publications;
    }

    @Override
    public List<Publication> getPublications(String jounal, String volume, String number) {
        if (StringUtils.isEmpty(jounal) || StringUtils.isEmpty(volume) || StringUtils.isEmpty(volume)) {
            return Collections.emptyList();
        }
        Publication searchVo = new Publication();
        searchVo.setJournal(jounal);
        searchVo.setVolume(volume);
        searchVo.setNumber(number);
        List<Publication> publications = publicationMapper.getPubsByTitle(searchVo);
        if (publications == null || publications.size() == 0) {
            return Collections.emptyList();
        }
        buildAuthorsAndType(publications);
        return publications;
    }

    @Override
    public List<Publication> getPublications(String conferenceName, String year) {
        if (StringUtils.isEmpty(conferenceName) || StringUtils.isEmpty(year)) {
            return Collections.emptyList();
        }
        Publication searchVo = new Publication();
        searchVo.setBooktitle(conferenceName);
        searchVo.setYear(year);
        PaperDtdAttribute paperDtdAttribute = new PaperDtdAttribute();
        //paperDtdAttribute.setPaperType(PaperType.INPROCEEDINGS);
        searchVo.setPaperDtdAttribute(paperDtdAttribute);
        List<Publication> publications = publicationMapper.getPubsByTitle(searchVo);
        if (publications == null || publications.size() == 0) {
            return Collections.emptyList();
        }
        buildAuthorsAndType(publications);
        return publications;
    }

    /**
     * add author name
     *
     * @param publications
     */
    private void buildAuthorsAndType(List<Publication> publications) {
        List<Long> paperIds = publications.stream().map(Publication::getId).collect(Collectors.toList());
        List<Publication> publicationAuthors = publicationMapper.getAuthorsByPbIds(paperIds);
        if (publicationAuthors == null || publicationAuthors.size() == 0) {
            return;
        }
        Map<Long, List<Publication>> pubIdAuthorMap = publicationAuthors.stream().collect(Collectors.groupingBy(Publication::getId));
        publications.forEach(publication ->
        {
            publication.setAuthors(pubIdAuthorMap.get(publication.getId()).stream().map(Publication::getAuthor).collect(Collectors.toList()));
        });
    }

    /**
     * add publication
     *
     * @param paperDtd
     * @return
     */
    private Long addPublication(PaperDtd paperDtd) {
        ReflectionUtil.trimObj(paperDtd);
        publicationMapper.addPublication(paperDtd);
        return paperDtd.getId();
    }


    /**
     * add all authors
     *
     * @param paperDtd
     * @return
     */
    private List<Long> addAuthor(PaperDtd paperDtd) {
        String authors = paperDtd.getAuthor();
        String[] authorArray = authors.split(SEP);
        List<Long> authorIdList = new ArrayList<Long>();
        for (String s : authorArray) {
            //check if author exist
            Author authorExist = publicationMapper.getOneAuthorByName(s);
            if (authorExist != null) {
                authorIdList.add(authorExist.getId());
                continue;
            }
            //if not exist do insert
            Author author = new Author(s);
            publicationMapper.addAuthor(author);
            authorIdList.add(author.getId());
        }
        return authorIdList;
    }

    /**
     * add the relationship between publication and authors
     *
     * @return
     */
    private void addPubAuthors(Long pubId, List<Long> authorIds) {
        for (Long authorId : authorIds) {
            PubAuthor pubAuthor = new PubAuthor(pubId, authorId);
            publicationMapper.addPubAuthor(pubAuthor);
        }
    }

    public List<Publication> getAllPublications() {
        return publicationMapper.getAll();
    }

    private List<Publication> getByYearAndTitle(String keyword, SearchRegion region, int numResultsToSkip, int numResultsToRetur) {
        //get polygon
        SearchPublicationYear from = new SearchPublicationYear(region.getYearLow(), 1);
        SearchPublicationYear to = new SearchPublicationYear(region.getYearHigh(), 12);
        StringBuilder sb = new StringBuilder();
        sb.append(from.getYear()).append(" ").append(from.getMonth()).append(",");
        sb.append(from.getYear()).append(" ").append(to.getMonth()).append(",");
        sb.append(to.getYear()).append(" ").append(to.getMonth()).append(",");
        sb.append(to.getYear()).append(" ").append(from.getMonth()).append(",");
        sb.append(from.getYear()).append(" ").append(from.getMonth());
        String polygon = "POLYGON((" + sb.toString() + "))";
        List<Publication> pubs = publicationMapper.getByTitleAndYearPolygon(from, to, keyword, polygon, numResultsToSkip, numResultsToRetur);
        return pubs;
    }

    @Override
    public Integer buildLucenceIndex() {
        List<Publication> allPublications = getAllPublications();
        return lucenceService.buildIndex(allPublications);
    }

    @Override
    public List<Publication> basicSearch(String keyword, int numResultsToSkip, int numResultsToReturn) {
        if (StringUtils.isEmpty(keyword)) {
            return Collections.emptyList();
        }
        if (numResultsToReturn <= 0) {
            numResultsToReturn = 10;
        }
        return lucenceService.basicSearch(keyword, numResultsToSkip, numResultsToReturn);
    }

    @Override
    public List<Publication> spacialSearch(String keyword, String yearFrom, String yearTo, int numResultsToSkip, int numResultsToReturn) {
        if (StringUtils.isEmpty(keyword)) {
            return Collections.emptyList();
        }
        //to build the polygon
        SearchRegion region = new SearchRegion((Integer.parseInt(yearFrom) - 1), 1, (Integer.parseInt(yearTo) + 1), 12);
        return getByYearAndTitle(keyword, region, numResultsToSkip, numResultsToReturn);
    }
}
