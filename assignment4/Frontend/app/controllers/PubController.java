package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import model.ALtLot;
import model.PubCategory;
import model.Publication;
import model.PublicationWrapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class PubController  extends Controller {

    private static final String URL = "http://localhost:9000/";
    private static FormFactory formFactory;
    private static CloseableHttpClient httpclient = HttpClients.createDefault();
    @Inject
    HttpExecutionContext ec;
    @Inject
    public PubController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    /**
     * 1.1 Given author name A, list all of her co-authors.
     * @return
     */
    public Result coAuthor() {
        String author = request().getQueryString("author");
        String urlSuffix = "coauthor?author=" + URLEncoder.encode(author);
        String response = bulidReqResult(urlSuffix);
        List<String> authors = new Gson().fromJson(response, new TypeToken<List<String>>() {}.getType());
        return ok(views.html.author.render(authors));
        //return ok(response);
    }

    /**
     * 1.2 Given a paper name (i.e., title), list its publication metadata.
     * @return
     */
    public Result pubbytitle() {
        String title = request().getQueryString("title");
        String urlSuffix = "pubbytitle?title=" + URLEncoder.encode(title);
        String response = bulidReqResult(urlSuffix);
        List<Publication> pubs = responseToPubList(response);
        return ok(views.html.pub.render(pubs));
        //return ok(response);
    }

    /**
     * 1.3 Given a journal name and a year (volume) and an issue (number),
     * @return
     */
    public Result pubbyyear() {
        String journal = request().getQueryString("journal");
        String volume = request().getQueryString("volume");
        String number = request().getQueryString("number");
        String urlSuffix = "pubbyyear?journal="
                + URLEncoder.encode(journal) +"&volume=" + volume + "&number=" + number;
        String response = bulidReqResult(urlSuffix);
        List<Publication> result = new Gson().fromJson(response, new TypeToken<List<Publication>>() {}.getType());
        return ok(views.html.pub.render(result));
        //return ok(response);
    }



    /**
     * #1.4 Display all the article titles published in the area of SOC;
     * @return
     */
    public Result alltitle(){
        String response = bulidReqResult("alltitle");
        List<String> pubTitles = new Gson().fromJson(response, new TypeToken<List<String>>() {}.getType());
        return ok(views.html.author.render(pubTitles));
    }

    /**
     *#1.5 Display the titles of the articles published by a researcher in a specific year;
     * @return
     */
    public Result pubbyresearchyear(){
        String researcher = request().getQueryString("researcher");
        String year = request().getQueryString("year");
        String urlSuffix = "pubbyresearcher?researcher=" + URLEncoder.encode(researcher) +"&year=" + year;
        String response = bulidReqResult(urlSuffix);
        List<String> result = new Gson().fromJson(response, new TypeToken<List<String>>() {}.getType());
        return ok(views.html.author.render(result));
//        /return ok(response);
    }

    /**
     * #1.6 Display all the authors who have published more than 10 papers in the area of SOC to date
     * @return
     */
    public Result greatAuthors(){
        String urlSuffix = "authorsgreat";
        String response =  bulidReqResult(urlSuffix);
        List<String> result = new Gson().fromJson(response, new TypeToken<List<String>>() {}.getType());
        return ok(views.html.author.render(result));
    }
    /**
     * 2.1 Given a researcher's name and a year, list all published papers' metadata;
     */
    public Result pubByResearcherAndYear(){
        String researcher = request().getQueryString("researcher");
        String year = request().getQueryString("year");
        String urlSuffix =  "pubbyry?researcher=" + URLEncoder.encode(researcher)
                +"&year=" + URLEncoder.encode(year);
        String response =  bulidReqResult(urlSuffix);
        List<Publication> result = new Gson().fromJson(response, new TypeToken<List<Publication>>() {}.getType());
        return ok(views.html.pub.render(result));
    }

    /**
     * #2.2 For the productive authors (e.g., published more than 10 papers)
     * list all of their co-authors;
     * @return
     */
    public Result greatCoAuthors(){
        String urlSuffix = "greatcoauthor";
        String response =  bulidReqResult(urlSuffix);
        List<String> result = new Gson().fromJson(response, new TypeToken<List<String>>() {}.getType());
        return ok(views.html.author.render(result));
    }

    /**
     * #2.3 Given a conference name, and a range of years (between 2003-2019),
     * mark the locations of where the conference was held in a map.
     * @return
     */

    public Result altLot(){
        String conferenceName = request().getQueryString("conferencename");
        String startYear = request().getQueryString("startyear");
        String endYear = request().getQueryString("endyear");
        String urlSuffix = "getAltLot?conferenceName=" + URLEncoder.encode(conferenceName)
                +"&startYear=" + URLEncoder.encode(startYear)
                +"&endYear=" + URLEncoder.encode(endYear);
        String response =  bulidReqResult(urlSuffix);
        List<ALtLot> aLtLots = new Gson().fromJson(response, new TypeToken<List<ALtLot>>() {}.getType());
        List<JsonNode> result = new ArrayList<>();
        for(ALtLot aLtLot : aLtLots){
            List<Double> lst = new ArrayList<>();
            lst.add(aLtLot.getLatitude());
            lst.add(aLtLot.getLongitude());
            result.add(Json.toJson(lst));
        }
        //String rst = ;
        return ok(views.html.map.render(result));
    }

    /**
     * assignment4
     * @return
     */
    public Result getCategory(){
        String urlSuffix = "getCategory";
        String response =  bulidReqResult(urlSuffix);
        List<PubCategory> result = new Gson().fromJson(response, new TypeToken<List<PubCategory>>() {}.getType());
        return ok(views.html.category.render(result));
    }

    /**
     * assignment4
     * @return
     */
    public Result getByCategory(){
        String categoryId = request().getQueryString("categoryId");
        String urlSuffix = "getPubByCategory?category=" + categoryId;
        String response =  bulidReqResult(urlSuffix);
        List<Publication> result = new Gson().fromJson(response, new TypeToken<List<Publication>>() {}.getType());
        return ok(views.html.titles.render(result));
    }
    public Result getDetail(){
        String pubId = request().getQueryString("pubId");
        String urlSuffix = "getPubDetail?pubId=" + pubId;
        String response =  bulidReqResult(urlSuffix);
        PublicationWrapper result = new Gson().fromJson(response, new TypeToken<PublicationWrapper>() {}.getType());
        return ok(views.html.detail.render(result));
    }

    private String bulidReqResult(String urlSuffix) {
        HttpGet httpget = new HttpGet(URL + urlSuffix);
        try {
            CloseableHttpResponse response = httpclient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error occur, please try again.";
    }

    private List<Publication> responseToPubList(String response) {
        JsonObject returnData = new JsonParser().parse(response).getAsJsonObject();
        Publication publication = new Gson().fromJson(returnData, Publication.class);
        List<Publication> pubs = new ArrayList<>();
        pubs.add(publication);
        return pubs;
    }

}
