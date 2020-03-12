package cmu.soc.service;

import cmu.soc.dao.entity.Author;
import cmu.soc.dao.entity.PubAbs;
import cmu.soc.dao.entity.Publication;
import cmu.soc.parser.PaperAbstracts;

import java.sql.SQLException;
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

    void addAbstract(List<PaperAbstracts> paperAbstracts) throws SQLException, ClassNotFoundException;

    void addAbstractToDB(PubAbs paperAbstracts);

    void addAuthor(Author author);

    PubAbs getAbsByTitile(String title);

    Publication getPubByTitle(String title);

}
