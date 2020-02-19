package service.xquery;

import com.saxonica.xqj.SaxonXQDataSource;
import org.springframework.util.StringUtils;
import play.Play;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XQuery {

    public static List<String> getByFileName(String fileName, String parameter1, String parameter2){
        List<String> retriveResult = new ArrayList<>();
        try {
            File file = Play.application().getFile("/conf/" + fileName);
            InputStream inputStream = new FileInputStream(file);

            //InputStream inputStream = ClassLoader.getSystemResourceAsStream("/config/" + fileName);
            XQDataSource ds = new SaxonXQDataSource();
            XQConnection conn = ds.getConnection();
            XQPreparedExpression exp = conn.prepareExpression(inputStream);
            if(!StringUtils.isEmpty(parameter1)) {
                exp.bindString(new QName("authorName"), parameter1, null);
            }
            if(!StringUtils.isEmpty(parameter2)) {
                exp.bindString(new QName("authorYear"), parameter2, null);
            }
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
    public static void main(String[] args){
        //List<String> result = getByFileName("q1.xqy", null, null);
        List<String> result = getByFileName("q1.xqy", null, null);
        System.out.println(result);
    }
}
