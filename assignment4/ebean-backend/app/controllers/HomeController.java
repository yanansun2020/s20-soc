package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import models.PubCategory;
import models.Publication;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import play.libs.Json;
import play.mvc.*;
import service.ALtLot;
import service.PubAuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    public Result index() {
        return ok(Json.toJson("Welcome to backend!"));
    }
    /**
     * 1.1 Given author name A, list all of her co-authors.
     * @param author
     * @return
     */
    PubAuthorService pubAuthorService = new PubAuthorService();

    public Result coAuthors(String author) {
        System.out.print("====req " + author);
        Set<String> result = pubAuthorService.getCoAuthors(author);
        return ok(Json.toJson(result));
    }
    /**
     * 1.2 Given a paper name (i.e., title), list its publication metadata.
     * @return
     */
    public Result publicationsByTitle(String title) {
        System.out.print("====req " + title);
        Publication publications= pubAuthorService.getPublications(title);
        if(publications == null){
            return ok(Json.toJson(new Publication()));
        }
        return ok(Json.toJson(publications));
    }

    /**
     * 1.3 Given a journal name and a year (volume) and an issue (number),
     * find out the metadata of all the papers published in the book (means the volume+number of the journal).
     * @param journal
     * @param volume
     * @param number
     * @return
     */
    public Result getByVolumeAndNumber(String journal, String volume, String number) {
        List<Publication> publications= pubAuthorService.getByVolumeAndNumber(journal, volume, number);
        if(CollectionUtils.isEmpty(publications)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        return ok(Json.toJson(publications));
    }
    /**
     * 1.4 Display all the article titles published in the area of SOC;
     * @return
     */
    public Result getAllSOCArticleTitles() {
        List<String> publications= pubAuthorService.getAllSOCArticleTitles();
        if(CollectionUtils.isEmpty(publications)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        return ok(Json.toJson(publications));
    }
    /**
     * 1.5 Display the titles of the articles published by a researcher in a specific year;
     * TODO xquery
     * @param researcher
     * @param year
     * @return
     */
    public Result getByResearcherAndYear(String researcher, String year) {
        List<String> publications= pubAuthorService.getByResearcherAndYear(researcher, year);
        if(CollectionUtils.isEmpty(publications)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        return ok(Json.toJson(publications));
    }
    /**
     * 1.6 Display all the authors who have published more than 10 papers in the area of SOC to date
     * TODO xquery
     * @return
     */
    public Result getAuthors() {
        List<String> publications= pubAuthorService.getAuthors();
        if(CollectionUtils.isEmpty(publications)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        return ok(Json.toJson(publications));
    }
    /**
     *  2.1 Given a researcher's name and a year, list all published papers' metadata;
     * @param researcher
     * @param year
     * @return
     */
    public Result getPubByResearcherAndYear(String researcher, String year) {
        if(StringUtils.isEmpty(researcher) || StringUtils.isEmpty(year)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        List<Publication> publications= pubAuthorService.getPubByResearcherAndYear(researcher, year);
        if(CollectionUtils.isEmpty(publications)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        return ok(Json.toJson(publications));
    }

    /**
     * 2.2 For the productive authors (e.g., published more than 10 papers)
     * in the area of SOC, list all of their co-authors;
     * @return
     */
    public Result getCoAuthorsOfProductiveAuthors() {
        List<String> publications= pubAuthorService.getCoAuthorsOfProductiveAuthors();
        if(CollectionUtils.isEmpty(publications)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        return ok(Json.toJson(publications));
    }
    /**
     * 2.3 Given a conference name, and a range of years (between 2003-2019), mark the locations of where the conference was held in a map.
     * @param conferenceName
     * @param startYear
     * @param endYear
     * @return
     */
    public Result getAltLot(String conferenceName, String startYear, String endYear) {
        List<ALtLot> publications= pubAuthorService.getAltLot(conferenceName, startYear, endYear);
        if(CollectionUtils.isEmpty(publications)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        return ok(Json.toJson(publications));
    }

    /**
     * find categories
     * @return
     */
    public Result getCategory() {
        List<PubCategory> categories = pubAuthorService.getCategories();
        if(CollectionUtils.isEmpty(categories)){
            return ok(Json.toJson(new ArrayList<>()));
        }
        return ok(Json.toJson(categories));
    }

}
