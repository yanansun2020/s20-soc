package cmu.soc.service;

import cmu.soc.dao.entity.Publication;

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


}
