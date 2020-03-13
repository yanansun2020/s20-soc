package parser;

import models.PaperAbstracts;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import service.PublicationService;
import service.PublicationServiceImpl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperAbstractParser {
    public static PublicationService publicationService = new PublicationServiceImpl();
    private static String fileName = "F:\\Documents\\a-cmu\\18655SOC\\code\\source\\assignment4\\ebean-backend\\dblp_abstract_dataset.xml";
    public static void main(String[] args){
        try {
            List<PaperAbstracts> abstracts = getAbtracts();
            publicationService.addAbstract(abstracts);
            System.out.println("haha");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException|SAXException|SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static List<PaperAbstracts> getAbtracts() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream inputStream = new FileInputStream(new File(fileName));
        Document document = builder.parse(inputStream);
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        List<PaperAbstracts> proceedings = new ArrayList<PaperAbstracts>();
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                PaperAbstracts emp = new PaperAbstracts();
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild(). getTextContent().trim();
                        if("title".equals(cNode.getNodeName())){
                            emp.setTitle(content);
                        }
                        if("ee".equals(cNode.getNodeName())){
                            emp.setEe(content);
                        }
                        if("abstract".equals(cNode.getNodeName())){
                            emp.setAbstracts(content);
                        }
                    }
                }
                proceedings.add(emp);
            }
        }
        return proceedings;
    }
}
