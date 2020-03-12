package cmu.soc.category;

import cmu.soc.dao.entity.Publication;
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
import java.io.*;
import java.util.List;

public class HandleMetadata {
    static PublicationService publicationService = new PublicationServiceImpl();
    public static void parseMetadata() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("F:\\Documents\\a-cmu\\18655SOC\\code\\source\\assignment4\\SOC\\src\\main\\resources\\dblp_abstract_dataset.xml"));
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                NodeList childNodes = node.getChildNodes();
                String title = "";
                String paper_abstract = "";
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);
                    if (childNode instanceof Element) {
                        String attribute = childNode.getNodeName();
                        String content = childNode.getLastChild().getTextContent().trim();
                        if (attribute.equals("title")) {
                            title = content.replace(":", "-+-").replace("/", "\\");
                        } else if (attribute.equals("abstract")) {
                            paper_abstract = content;
                        }
                    }
                }
                try {
                    Publication publication = publicationService.getPubByTitle(title);
                    BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\Documents\\a-cmu\\18655SOC\\code\\mallet\\" + publication.getId() +".txt"));
                    writer.write(paper_abstract);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            parseMetadata();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

}
