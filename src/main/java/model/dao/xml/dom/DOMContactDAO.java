package model.dao.xml.dom;

import factory.EntityFactory;
import model.dao.ContactDAO;
import model.dao.MyValidator;
import model.data.Contact;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DOMContactDAO implements ContactDAO {

    public void save(Contact contact) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        String xmlPath = getXmlPath();

        Document document = getContactDocument(xmlPath);

        Node root = document.getFirstChild();

        Element contactEl = document.createElement("Contact");
        root.appendChild(contactEl);

        Element id = document.createElement("id");
        id.appendChild(document.createTextNode(contact.getId().toString()));
        contactEl.appendChild(id);

        Element firstName = document.createElement("firstName");
        firstName.appendChild(document.createTextNode(contact.getFirstName()));
        contactEl.appendChild(firstName);

        Element lastName = document.createElement("lastName");
        lastName.appendChild(document.createTextNode(contact.getLastName()));
        contactEl.appendChild(lastName);

        Element number = document.createElement("number");
        number.appendChild(document.createTextNode(contact.getNumber()));
        contactEl.appendChild(number);

        Element groupId = document.createElement("groupId");
        groupId.appendChild(document.createTextNode(contact.getGroupId().toString()));
        contactEl.appendChild(groupId);

        saveDocumet(document,xmlPath);
    }

    public void remove(Contact contact) throws XPathExpressionException, ParserConfigurationException, TransformerException, IOException, SAXException {

        String xmlPath = getXmlPath();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlPath));

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/contactSet/Contact[id=" + contact.getId() + "]";
        Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

        Node root = document.getFirstChild();

        root.removeChild(node);

        saveDocumet(document,xmlPath);

    }

    public void removeById(int id) throws ParserConfigurationException, XPathExpressionException, TransformerException, IOException, SAXException {

        String xmlPath = getXmlPath();
        Document document = getContactDocument(xmlPath);

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/contactSet/Contact[id=" + id + "]";
        Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

        Node root = document.getFirstChild();

        root.removeChild(node);

        saveDocumet(document,xmlPath);

    }

    public void update(Contact contact, int id) throws XPathExpressionException, TransformerException, ParserConfigurationException, IOException, SAXException {

        String xmlPath = getXmlPath();

        Document document = getContactDocument(xmlPath);

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "/contactSet/Contact[id=" + id + "]";
        Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

        Node root = document.getFirstChild();

        root.removeChild(node);

        Element contactEl = document.createElement("Contact");
        root.appendChild(contactEl);

        Element id1 = document.createElement("id");
        id1.appendChild(document.createTextNode(contact.getId().toString()));
        contactEl.appendChild(id1);

        Element firstName = document.createElement("firstName");
        firstName.appendChild(document.createTextNode(contact.getFirstName()));
        contactEl.appendChild(firstName);

        Element lastName = document.createElement("lastName");
        lastName.appendChild(document.createTextNode(contact.getLastName()));
        contactEl.appendChild(lastName);

        Element number = document.createElement("number");
        number.appendChild(document.createTextNode(contact.getNumber()));
        contactEl.appendChild(number);

        Element groupId = document.createElement("groupId");
        groupId.appendChild(document.createTextNode(contact.getGroupId().toString()));
        contactEl.appendChild(groupId);
        saveDocumet(document,xmlPath);
    }

    public Set<Contact> getAll() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();

        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(xmlPath));

            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "/contactSet/Contact";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

            EntityFactory entityFactory = new EntityFactory();
            int maxId = 0;
            Set<Contact> out = new HashSet<>();

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);

                NodeList paramList = node.getChildNodes();

                if (paramList.item(0).getTextContent() != null) {

                    int id = Integer.valueOf(paramList.item(0).getTextContent());
                    String firstName = paramList.item(1).getTextContent();
                    String lastName = paramList.item(2).getTextContent();
                    String number = paramList.item(3).getTextContent();
                    int groupId = Integer.valueOf(paramList.item(4).getTextContent());

                    if (id > maxId) {
                        maxId = id;
                    }

                    //out.add((Contact) entityFactory.getEntity(id, firstName, lastName, number, groupId));
                }
            }

            Contact.setId_count(maxId);

            return out;
        }
        else return new HashSet<Contact>();
    }

    public Contact getById(int id) throws Exception {
/*
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();

        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(xmlPath));

            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "/contactSet/Contact[id=" + id + "]";
            Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

            EntityFactory entityFactory = new EntityFactory();

            NodeList paramList = node.getChildNodes();

            int idN = Integer.valueOf(paramList.item(0).getTextContent());
            String firstName = paramList.item(1).getTextContent();
            String lastName = paramList.item(2).getTextContent();
            String number = paramList.item(3).getTextContent();
            int groupId = Integer.valueOf(paramList.item(4).getTextContent());

            return (Contact) entityFactory.getEntity(idN, firstName, lastName, number, groupId);
        }
        else*/ return null;
    }

    @Override
    public void addContactGroup(int idC, int idG) {

    }

    @Override
    public void removeContactGroup(int idC, int idG) {

    }

    @Override
    public boolean login(String login, String password) {
        return false;
    }

    private Document getContactDocument(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(xmlPath));
        return document;
    }

    private String getXmlPath(){
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();
        return xmlPath;
    }

    private void saveDocumet(Document document, String xmlPath) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File(xmlPath));

        transformer.transform(domSource, streamResult);
    }
}
