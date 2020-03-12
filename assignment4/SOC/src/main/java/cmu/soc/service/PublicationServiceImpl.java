package cmu.soc.service;

import cmu.soc.dao.PublicationMapper;
import cmu.soc.dao.entity.Author;
import cmu.soc.dao.entity.PubAbs;
import cmu.soc.dao.entity.PubAuthor;
import cmu.soc.dao.entity.Publication;
import cmu.soc.parser.PaperAbstracts;
import cmu.soc.parser.PaperDtd;
import cmu.soc.parser.PaperDtdAttribute;
import cmu.soc.parser.XmlParser;
import cmu.soc.util.ReflectionUtil;
import cmu.soc.util.SqlSessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.platform.commons.util.CollectionUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PublicationServiceImpl implements PublicationService{
    private static final String SEP = "\\$";
    private XmlParser xmlParser = new XmlParser();
    private static SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    private static PublicationMapper  publicationMapper = sqlSession.getMapper(PublicationMapper.class);

    public void addPublicationAndAuthor(String filePath){
        try {
            List<PaperDtd> paperDtdList = xmlParser.parse(filePath);
            for(PaperDtd paperDtd : paperDtdList){
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
        if(StringUtils.isEmpty(author)){
            return Collections.emptyList();
        }
        List<Author> authorExist = publicationMapper.getCoAuthors(author);
        return authorExist.stream().map(Author::getName).collect(Collectors.toList());
    }

    @Override
    public List<Publication> getPublications(String title) {
        if(StringUtils.isEmpty(title)){
            return Collections.emptyList();
        }
        Publication searchVo = new Publication();
        searchVo.setTitle(title);
        List<Publication> publications = publicationMapper.getPubsByTitle(searchVo);
        if(publications == null || publications.size() == 0){
            return Collections.emptyList();
        }
        buildAuthorsAndType(publications);
        return publications;
    }

    @Override
    public List<Publication> getPublications(String jounal, String volume, String number) {
        if(StringUtils.isEmpty(jounal) || StringUtils.isEmpty(volume) || StringUtils.isEmpty(volume)){
            return Collections.emptyList();
        }
        Publication searchVo = new Publication();
        searchVo.setJournal(jounal);
        searchVo.setVolume(volume);
        searchVo.setNumber(number);
        List<Publication> publications = publicationMapper.getPubsByTitle(searchVo);
        if(publications == null || publications.size() == 0){
            return Collections.emptyList();
        }
        buildAuthorsAndType(publications);
        return publications;
    }

    @Override
    public List<Publication> getPublications(String conferenceName, String year) {
        if(StringUtils.isEmpty(conferenceName) || StringUtils.isEmpty(year)){
            return Collections.emptyList();
        }
        Publication searchVo = new Publication();
        searchVo.setBooktitle(conferenceName);
        searchVo.setYear(year);
        PaperDtdAttribute paperDtdAttribute = new PaperDtdAttribute();
        //paperDtdAttribute.setPaperType(PaperType.INPROCEEDINGS);
        searchVo.setPaperDtdAttribute(paperDtdAttribute);
        List<Publication> publications = publicationMapper.getPubsByTitle(searchVo);
        if(publications == null || publications.size() == 0){
            return Collections.emptyList();
        }
        buildAuthorsAndType(publications);
        return publications;
    }

    public void addAbstract(List<PaperAbstracts> paperAbstracts) {
        for(PaperAbstracts paperAbstracts1: paperAbstracts){
            String title = paperAbstracts1.getTitle();
            List<Publication> publications = getPublications(title);
            if(publications == null || publications.size() == 0){
                continue;
            }
            Publication publication = publications.get(0);
            PubAbs pubAbs = new PubAbs();
            pubAbs.setPubId(publication.getId());
            pubAbs.setAbstracts(paperAbstracts1.getAbstracts());
            addAbstractToDB(pubAbs);
        }
    }

    public void addAbstractToDB(PubAbs pubAbs) {
        Long resut = publicationMapper.addAbstract(pubAbs);
        System.out.println(resut);
    }

    @Override
    public void addAuthor(Author author) {
        publicationMapper.addAuthor(author);
    }

    public PubAbs getAbsByTitile(String title){
        return publicationMapper.getAbstract(title);
    }

    /**
     * add author name
     * @param publications
     */
    private void buildAuthorsAndType(List<Publication> publications){
        List<Long> paperIds = publications.stream().map(Publication::getId).collect(Collectors.toList());
        List<Publication> publicationAuthors = publicationMapper.getAuthorsByPbIds(paperIds);
        if(publicationAuthors == null || publicationAuthors.size() == 0){
            return ;
        }
        Map<Long, List<Publication>> pubIdAuthorMap = publicationAuthors.stream().collect(Collectors.groupingBy(Publication::getId));
        publications.forEach(publication ->
                {
                    publication.setAuthors(pubIdAuthorMap.get(publication.getId()).stream().map(Publication::getAuthor).collect(Collectors.toList()));
                } );
    }

    /**
     * add publication
     * @param paperDtd
     * @return
     */
    private Long addPublication(PaperDtd paperDtd){
        ReflectionUtil.trimObj(paperDtd);
        publicationMapper.addPublication(paperDtd);
        return paperDtd.getId();
    }



    /**
     * add all authors
     * @param paperDtd
     * @return
     */
    private List<Long> addAuthor(PaperDtd paperDtd){
        String authors = paperDtd.getAuthor();
        String[] authorArray = authors.split(SEP);
        List<Long> authorIdList = new ArrayList<Long>();
        for(String s :  authorArray){
            //check if author exist
            Author authorExist = publicationMapper.getOneAuthorByName(s);
            if(authorExist != null){
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
     * @return
     */
    private void addPubAuthors(Long pubId, List<Long> authorIds){
        for(Long authorId : authorIds){
            PubAuthor pubAuthor = new PubAuthor(pubId, authorId);
            publicationMapper.addPubAuthor(pubAuthor);
        }
    }
}
