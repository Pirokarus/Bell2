package model.dao;

import factory.EntityFactory;
import model.data.Group;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DOMGroupDAO implements AbstractGroupDAO {

    @Override
    public void save(Group group) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlPath));

        Node root = document.getFirstChild();

        Element groupEl = document.createElement("Group");
        root.appendChild(groupEl);

        Element id = document.createElement("id");
        id.appendChild(document.createTextNode(group.getId().toString()));
        groupEl.appendChild(id);

        Element firstName = document.createElement("name");
        firstName.appendChild(document.createTextNode(group.getName()));
        groupEl.appendChild(firstName);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File(xmlPath));

        transformer.transform(domSource, streamResult);

    }

    @Override
    public void remove(Group group) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {

        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlPath));

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/groupSet/Group[id=" + group.getId() + "]";
        Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

        Node root = document.getFirstChild();

        root.removeChild(node);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File(xmlPath));

        transformer.transform(domSource, streamResult);


        ClassLoader classLoader1 = getClass().getClassLoader();
        String xmlPath1 = classLoader1.getResource("Contacts.xml").getFile();

        DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder1 = factory1.newDocumentBuilder();

        Document document1 = builder1.parse(new File(xmlPath1));

        XPath xPath1 = XPathFactory.newInstance().newXPath();

        String expression1 = "/contactSet/Contact[groupId=" + group.getId() + "]";

        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        Node root1 = document1.getFirstChild();

        for (int i = 0; i<nodeList.getLength(); ++i){
            Node node1 = nodeList.item(i);
            root1.removeChild(node1);

            NodeList paramList = node1.getChildNodes();

            Element e = document1.createElement("Contact");
            root1.appendChild(e);

            Element id1 = document.createElement("id");
            id1.appendChild(document.createTextNode(paramList.item(0).getTextContent()));
            e.appendChild(id1);

            Element firstName = document.createElement("firstName");
            firstName.appendChild(document.createTextNode(paramList.item(1).getTextContent()));
            e.appendChild(firstName);

            Element lastName = document.createElement("lastName");
            lastName.appendChild(document.createTextNode(paramList.item(2).getTextContent()));
            e.appendChild(lastName);

            Element number = document.createElement("number");
            number.appendChild(document.createTextNode(paramList.item(3).getTextContent()));
            e.appendChild(number);

            Element groupId = document.createElement("groupId");
            groupId.appendChild(document.createTextNode("-1"));
            e.appendChild(groupId);
        }

        TransformerFactory transformerFactory1 = TransformerFactory.newInstance();
        Transformer transformer1 = transformerFactory1.newTransformer();
        DOMSource domSource1 = new DOMSource(document1);

        StreamResult streamResult1 = new StreamResult(new File(xmlPath1));

        transformer1.transform(domSource1, streamResult1);

    }

    @Override
    public void removeById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlPath));

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/groupSet/Group[id=" + id + "]";
        Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

        Node root = document.getFirstChild();

        root.removeChild(node);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File(xmlPath));

        transformer.transform(domSource, streamResult);


        ClassLoader classLoader1 = getClass().getClassLoader();
        String xmlPath1 = classLoader1.getResource("Contacts.xml").getFile();

        DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder1 = factory1.newDocumentBuilder();

        Document document1 = builder1.parse(new File(xmlPath1));

        XPath xPath1 = XPathFactory.newInstance().newXPath();

        String expression1 = "/contactSet/Contact[groupId=" + id + "]";

        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        Node root1 = document1.getFirstChild();

        for (int i = 0; i<nodeList.getLength(); ++i){
            Node node1 = nodeList.item(i);
            root1.removeChild(node1);

            NodeList paramList = node1.getChildNodes();

            Element e = document1.createElement("Contact");
            root1.appendChild(e);

            Element id1 = document.createElement("id");
            id1.appendChild(document.createTextNode(paramList.item(0).getTextContent()));
            e.appendChild(id1);

            Element firstName = document.createElement("firstName");
            firstName.appendChild(document.createTextNode(paramList.item(1).getTextContent()));
            e.appendChild(firstName);

            Element lastName = document.createElement("lastName");
            lastName.appendChild(document.createTextNode(paramList.item(2).getTextContent()));
            e.appendChild(lastName);

            Element number = document.createElement("number");
            number.appendChild(document.createTextNode(paramList.item(3).getTextContent()));
            e.appendChild(number);

            Element groupId = document.createElement("groupId");
            groupId.appendChild(document.createTextNode("-1"));
            e.appendChild(groupId);
        }

        TransformerFactory transformerFactory1 = TransformerFactory.newInstance();
        Transformer transformer1 = transformerFactory1.newTransformer();
        DOMSource domSource1 = new DOMSource(document1);

        StreamResult streamResult1 = new StreamResult(new File(xmlPath1));

        transformer1.transform(domSource1, streamResult1);
    }

    @Override
    public void update(Group group, int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlPath));

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/groupSet/Group[id=" + id + "]";
        Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

        Node root = document.getFirstChild();

        root.removeChild(node);

        Element contactEl = document.createElement("Contact");
        root.appendChild(contactEl);

        Element id1 = document.createElement("id");
        id1.appendChild(document.createTextNode(group.getId().toString()));
        contactEl.appendChild(id1);

        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(group.getName()));
        contactEl.appendChild(name);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File(xmlPath));

        transformer.transform(domSource, streamResult);
    }

    @Override
    public Set<Group> getAll() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlPath));

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/groupSet/Group";
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        EntityFactory entityFactory = new EntityFactory();
        int maxId = 0;
        Set<Group> out = new HashSet<>();

        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);

            NodeList paramList = node.getChildNodes();

            if (paramList.item(0).getTextContent() != null) {

                int id = Integer.valueOf(paramList.item(0).getTextContent());
                String name = paramList.item(1).getTextContent();


                if(id>maxId){
                    maxId = id;
                }

                out.add((Group) entityFactory.getEntity(id, name));
            }
        }

        Group.setId_count(maxId);

        return out;
    }

    @Override
    public Group getById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlPath));

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/groupSet/Group[id=" + id + "]";
        Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

        EntityFactory entityFactory = new EntityFactory();

        NodeList paramList = node.getChildNodes();

        int idN = Integer.valueOf(paramList.item(0).getTextContent());
        String name = paramList.item(1).getTextContent();

        return (Group) entityFactory.getEntity(idN, name);
    }
}
