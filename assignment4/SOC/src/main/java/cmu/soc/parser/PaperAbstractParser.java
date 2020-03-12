package cmu.soc.parser;

import cmu.soc.service.PublicationService;
import cmu.soc.service.PublicationServiceImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperAbstractParser {
    public static PublicationService publicationService = new PublicationServiceImpl();

    public static void main(String[] args){
        try {
            List<PaperAbstracts> abstracts = getAbtracts();
            publicationService.addAbstract(abstracts);
            System.out.println("haha");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static List<PaperAbstracts> getAbtracts() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("dblp_abstract_dataset.xml"));
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
