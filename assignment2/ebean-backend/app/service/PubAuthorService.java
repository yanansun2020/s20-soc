package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.Author;
import models.PubAuthor;
import models.Publication;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import play.libs.Json;
import service.xquery.XQuery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class PubAuthorService {
    private static String MAP_API = "https://maps.googleapis.com/maps/api/geocode/json?key=";
    private static CloseableHttpClient httpclient = HttpClients.createDefault();
    /**
     * 1.1 Given author name A, list all of her co-authors.
     * @param author
     * @return
     */
    public static Set<String> getCoAuthors(String author) {
        if(StringUtils.isEmpty(author)){
            return new HashSet<>();
        }
        List<Author> authorExist = Author.findByName(author);
        //get Co publications
        List<Long> authorIds = authorExist.stream().map(Author::getId).collect(Collectors.toList());
        List<PubAuthor> pubAuthors = PubAuthor.getPubAuthors(authorIds);
        List<Long> pubIds = pubAuthors.stream().map(PubAuthor::getPubId).collect(Collectors.toList());
        List<PubAuthor> getPubAuthors = PubAuthor.getPubAuthors(pubIds);
        List<Author> authors = Author.findByIds(getPubAuthors.stream().map(PubAuthor::getAuthorId).collect(Collectors.toList()));
        return authors.stream().map(Author::getName).collect(Collectors.toSet());
    }

    /**
     * 1.2 Given a paper name (i.e., title), list its publication metadata.
     * @param title
     * @return
     */
    public static Publication getPublications(String title){
        if(StringUtils.isEmpty(title)){
            return null;
        }
        Publication publication = Publication.getPublicationByTitle(title);
        if(publication == null){
            return null;
        }
        return publication;
    }

    /**
     * 1.3 Given a journal name and a year (volume) and an issue (number),
     * find out the metadata of all the papers published in the book (means the volume+number of the journal).
     * @param journal
     * @param volume
     * @param number
     * @return
     */
    public static List<Publication> getByVolumeAndNumber(String journal, String volume, String number){
        if(StringUtils.isEmpty(journal) || StringUtils.isEmpty(volume) || StringUtils.isEmpty(volume)){
            return Collections.emptyList();
        }
        List<Publication> publications = Publication.getByNameVolumeNumber(journal, volume, number);
        if(publications == null || publications.size() == 0){
            return Collections.emptyList();
        }
        return publications;
    }

    /**
     * 1.4 Display all the article titles published in the area of SOC;
     * @return
     */
    public static List<String> getAllSOCArticleTitles(){
        String file = "q1.xqy";
        List<String> result = XQuery.getByFileName(file, null, null);
        System.out.println(result);
        return result;
    }

    /**
     * 1.5 Display the titles of the articles published by a researcher in a specific year;
     * @param researcher
     * @param year
     * @return
     */
    public static List<String> getByResearcherAndYear(String researcher, String year){
        String file = "q2.xqy";
        List<String> result = XQuery.getByFileName(file, researcher, year);
        System.out.println(result);
        return result;
    }

    /**
     * 1.6 Display all the authors who have published more than 10 papers in the area of SOC to date
     * @return
     */
    public static List<String> getAuthors(){
        String file = "q3.xqy";
        List<String> authors = XQuery.getByFileName(file, null, null);
        Set<String> authorSet = new HashSet<>(authors);
        System.out.println(authorSet);
        return new ArrayList<>(authorSet);
    }

    /**
     *  2.1 Given a researcher's name and a year, list all published papers' metadata;
     * @param researcher
     * @param year
     * @return
     */
    public static List<Publication> getPubByResearcherAndYear(String researcher, String year){
        List<String> titles = getByResearcherAndYear(researcher, year);
        List<Publication> result = new ArrayList<>();
        for(String title : titles){
            result.add(getPublications(title));
        }
        return result;
    }

    /**
     * 2.2 For the productive authors (e.g., published more than 10 papers)
     * in the area of SOC, list all of their co-authors;
     * @return
     */
    public static List<String> getCoAuthorsOfProductiveAuthors(){
        List<String> productiveAuthors = getAuthors();
        Set<String> productiveCoAuthors = new HashSet<>();
        for(String s : productiveAuthors){
            Set<String> coAuthors = getCoAuthors(s);
            productiveCoAuthors.addAll(coAuthors);
        }
        return new ArrayList<>(productiveCoAuthors);
    }

    /**
     * 2.3 Given a conference name, and a range of years (between 2003-2019), mark the locations of where the conference was held in a map.
     * @param conferenceName
     * @param startYear
     * @param endYear
     * @return
     */
    public static List<ALtLot> getAltLot(String conferenceName, String startYear, String endYear){
        List<ProceedingsVo> matchResult = new ArrayList<>();
        Integer start = Integer.parseInt(startYear);
        Integer end = Integer.parseInt(endYear);
        for(ProceedingsVo p :  Proceeedings.proceedingsVoList){
            if(p.getBooktitle().equals(conferenceName)){
                Integer conferenceYear = Integer.parseInt(p.getYear());
                if(conferenceYear > start && conferenceYear < end){
                    matchResult.add(p);
                }
            }
        }
        List<ALtLot> altLots = null;
        try {
            altLots = getAltLotByAddres(matchResult.stream().map(ProceedingsVo::getAddress).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return altLots;
    }

    private static List<ALtLot> getAltLotByAddres(List<String> collect) throws IOException {
        //&address=1600+Amphitheatre+Parkway,+Mountain+View,+CA
        List<ALtLot> result = new ArrayList<>();
        for(String s : collect){
            String address = getAddress(s);
            HttpGet httpget = new HttpGet(MAP_API + "&address=" + address);
            CloseableHttpResponse response = httpclient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                ALtLot aLtLot = getGeoCode(content, s);
                result.add(aLtLot);
            }
        }
        return result;
    }

    private static String getAddress(String s) {
        String[] tmp = s.split(" ");
        StringJoiner stringJoiner = new StringJoiner("+");
        for(String t : tmp){
            t = t.replaceAll("," , "");
            stringJoiner.add(t);
        }
        return stringJoiner.toString();
    }

    public static ALtLot getGeoCode(String response, String address){
        JsonObject returnData = new JsonParser().parse(response).getAsJsonObject();
        ALtLot aLtLot = new ALtLot();
        if ("OK".equals(returnData.get("status").getAsString())) {
            JsonArray results = returnData.get("results").getAsJsonArray();
            if (results == null || results.size() == 0) {
                return aLtLot;
            }
            JsonObject element = results.get(0).getAsJsonObject();
            JsonObject geometry = element.get("geometry").getAsJsonObject();
            if(geometry == null){
                return aLtLot;
            }
            JsonObject location = geometry.get("location").getAsJsonObject();
            if(location == null){
                return aLtLot;
            }

            aLtLot.setAddress(address);
            aLtLot.setLatitude(location.get("lat").getAsDouble());
            aLtLot.setLongitude(location.get("lng").getAsDouble());
            return aLtLot;
        }
        return aLtLot;
    }


    public static void main(String[] args){
        List<ProceedingsVo>  ps = Proceeedings.getProceedingsVoList();
        List<String> cities = new ArrayList<>();
        cities = ps.stream().map(ProceedingsVo::getAddress).collect(Collectors.toList());
        try {
            List<ALtLot> result = getAltLotByAddres(cities);
            System.out.println(Json.toJson(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
