package cmu.soc.service;

import cmu.soc.dao.entity.Publication;
import cmu.soc.lucene.SearchRegion;
import cmu.soc.model.SearchPublicationYear;

import java.util.List;

public interface PublicationService {
    /**
     * add publicarions, authors to database
     * @param filePath
     */
    void addPublicationAndAuthor(String filePath);

    /**
     * list all coauthors of one author
     * @param author
     * @return
     */
    List<String> getCoAuthors(String author);

    /**
     * get meta data of publications by title
     * @param title
     * @return
     */
    List<Publication> getPublications(String title);

    /**
     *
     * @param jounal
     * @param volume
     * @param volume
     * @return
     */
    List<Publication> getPublications(String jounal, String volume, String number);


    /**
     *
     * @param conferenceName
     * @param year
     * @return
     */
    List<Publication> getPublications(String conferenceName, String year);


    List<Publication> getAllPublications();

    //List<Publication> getByYearAndTitle(String yearFrom, String yearTo, String title);

    Integer buildLucenceIndex();

    Publication[] basicSearch(String keyword, int numResultsToSkip, int numResultsToReturn);

    Publication[] spacialSearch(String keyword, String yearFrom, String yearTo, int numResultsToSkip, int numResultsToRetur);


}
