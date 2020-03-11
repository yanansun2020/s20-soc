package cmu.soc.parser;

import cmu.soc.util.ReflectionUtil;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    private static final String SEP = "$";
    public List<PaperDtd> parse(String filePath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filePath));
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        List<PaperDtd> paperDtdList = new ArrayList<PaperDtd>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                PaperDtdAttribute paperDtdAttribute = new PaperDtdAttribute();
                if(!isToPass(node) || PaperType.getByDesc(node.getNodeName()) == null){
                    continue;
                }
                //to set the type of paper, either article or inproceedings
                paperDtdAttribute.setPaperType(node.getNodeName());
                //parse the attributes
                resetAttribute(paperDtdAttribute, node);
                PaperDtd paperDtd = new PaperDtd();
                paperDtd.setPaperDtdAttribute(paperDtdAttribute);
                NodeList childNodes = node.getChildNodes();
                //parse elements
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);
                    if (cNode instanceof Element) {
                        resetContent(paperDtd, cNode);
                    }
                }
                paperDtdList.add(paperDtd);
            }
        }
        return paperDtdList;
    }

    private void resetAttribute(Object obj, Node node){
        NamedNodeMap namedNodeMap = node.getAttributes();
        for(int i = 0; i < namedNodeMap.getLength(); i++){
            Node attributeNode = namedNodeMap.item(i);
            String value = ReflectionUtil.getAttribute(obj, attributeNode.getNodeName());
            String upToDateValue = value + SEP + attributeNode.getNodeValue();
            //add value to the obj properties
            ReflectionUtil.putAttribute(obj, attributeNode.getNodeName(), upToDateValue);
        }
    }

    private static void resetContent(Object obj, Node node){
        String nodeName = node.getNodeName();
        //first check if there is a get method in the obj
        String value = ReflectionUtil.getAttribute(obj, nodeName);
        //add value to the obj properties
        String upToDateValue = value + SEP + node.getLastChild().getTextContent().trim();
        ReflectionUtil.putAttribute(obj, nodeName, upToDateValue);
    }

    private static boolean isToPass(Node node){
        return node.getNodeName().equals(PaperType.ARTICLE.getDesc()) ||
                node.getNodeName().equals(PaperType.INPROCEEDINGS.getDesc());
    }
}
