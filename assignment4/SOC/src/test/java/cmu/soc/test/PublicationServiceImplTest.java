package cmu.soc.test;

import cmu.soc.dao.entity.Publication;
import cmu.soc.service.PublicationService;
import cmu.soc.service.PublicationServiceImpl;
import cmu.soc.xquery.XQuery;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PublicationServiceImplTest {
    PublicationService publicationService = new PublicationServiceImpl();

    /**
     * (1) invoke the parser method,
     * (2) extract xms file
     * (3) import data into database, and generate three tables
     */
    @Test
    public void addPublication(){
        publicationService.addPublicationAndAuthor("dblp-soc-papers-V2.xml");
    }

    /**
     * 1.3.1 Given author name A, list all of her co-authors.
     */
    @Test
    public void getCoAuthors(){
        System.out.println(new Gson().toJson(publicationService.getCoAuthors("Chen Zhou")));
    }

    /**
     * 1.3.2 Given a paper name, list its publication metadata, including paper title,
     * all co-authors, publication channel (e.g., conference, journal, etc), time, page etc.
     */
    @Test
    public void testPaperDetail(){
        List<Publication> publication = publicationService.getPublications("A Bloom Filter-Powered Technique Supporting" +
                " Scalable Semantic Service Discovery in Service");
        System.out.println(new Gson().toJson(publication));

    }

    /**
     * 1.3.3 Given a journal name and a year (volume) and an issue (number),
     * find out the metadata of all the papers published in the book (means the volume+number of the journal).
     */
    @Test
    public void testPublicationsSearchByVolume(){
        List<Publication> publication = publicationService.getPublications("IEEE Trans. Services Computing", "9", "3");
        System.out.println(new Gson().toJson(publication));

    }

    /**
     * 1.3.4 Given a conference name and a year, find out the metadata of all the papers published in the book (means the proceedings).
     */
    @Test
    public void testPublicationsSearchByNameAndYear(){
        List<Publication> publication = publicationService.getPublications("EFIS", "2016");
        System.out.println(new Gson().toJson(publication));

    }

    /**
     * 2.1 Display all the article titles published in the area of SOC;
     */
    @Test
    public void testXquery1(){
        String file = "q1.xqy";
        //System.out.println(XQuery.getByFileName(file));
    }

    /**
     * 2.2 Display the titles of the articles published by a researcher ("Jia Zhang") in a specific year ("2018");
     */
    @Test
    public void testXquery2(){
        String file = "q2.xqy";
        //System.out.println(XQuery.getByFileName(file));
    }

    /**
     * 2.3 Display all the authors who have published more than 10 papers in the area of SOC to date;
     */
    @Test
    public void testXquery3(){
        String  file= "q3.xqy";
        //System.out.println(XQuery.getAuthors(file));
    }

    /**
     * 2.4 Given a paper name, list its publication metadata,
     * including paper title, all co-authors, publication channel (e.g., conference, journal, etc), time, page etc.
     */
    @Test
    public void testXquery4(){
        String  file= "q4.xqy";
        //System.out.println(XQuery.getByString("Performance Impact of Web Service Migration in Embedded Environments."));
    }
}
