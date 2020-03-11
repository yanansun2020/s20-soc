package cmu.soc.parser;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbstractParser {
    public static List<Abstracts> getAbtracts() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("dblp_abstract_dataset.xml.xml"));
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        List<Proceedings> proceedings = new ArrayList<Proceedings>();
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Proceedings emp = new Proceedings();
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild(). getTextContent().trim();
                        if("title".equals(cNode.getNodeName())){
                            if(content.contains(",")){
                                emp.setTitle(content);
                            }
                            continue;
                        }
                        if("booktitle".equals(cNode.getNodeName())){
                            emp.setBooktitle(content);
                            continue;
                        }
                        if("publisher".equals(cNode.getNodeName())){
                            emp.setPublisher(content);
                            continue;
                        }
                        if("year".equals(cNode.getNodeName())){
                            emp.setYear(content);
                            continue;
                        }
                        if("isbn".equals(cNode.getNodeName())){
                            emp.setIsbn(content);
                        }
                    }
                }
                if(!StringUtils.isEmpty(emp.getTitle())){
                    proceedings.add(emp);
                }
            }
        }
        return proceedings;
    }
}
