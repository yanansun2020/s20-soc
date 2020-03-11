package cmu.soc.xquery;

/*import com.saxonica.xqj.SaxonXQDataSource;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;*/
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class XQuery {

    private static final int MIN_PAPER = 10;
   /* public static List<String> getByFileName(String fileName){
        List<String> retriveResult = new ArrayList<>();
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp = conn.prepareExpression(inputStream);
            exp.getAllExternalVariables();
            XQResultSequence result = exp.executeQuery();
            while (result.next()) {
                retriveResult.add(result.getItemAsString(null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retriveResult;
    }

    *//**
     * get authors who published more than 10 papers
     * @param fileName
     * @return
     *//*
    public static List<String> getAuthors(String fileName){
        List<String> authors = getByFileName(fileName);
        Map<String, Long> map = authors.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        Set<String> authorsMoreThanTen = new HashSet<>();
        map.forEach((k, v) -> {
            if(v > MIN_PAPER){
                authorsMoreThanTen.add(k);
            }
        });
        return new ArrayList<>(authorsMoreThanTen);
    }

    public static List<String> getByString(String input){
        String queryStr = "let $papers :=(doc(\"dblp-soc-papers-V2.xml\")/dblp/*)\n" +
                "return <results>\n" +
                "{\n" +
                "   for $x in $papers\n" +
                "    where $x/title='" + input +"'\n"+
                "   return $x/*\n" +
                "}\n" +
                "</results>";
        List<String> retriveResult = new ArrayList<>();
        try {
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp = conn.prepareExpression(queryStr);
            exp.getAllExternalVariables();
            XQResultSequence result = exp.executeQuery();
            while (result.next()) {
                retriveResult.add(result.getItemAsString(null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retriveResult;
    }*/
}
