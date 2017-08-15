package model.dao.xml.sax;

import exceptions.MyNotPhoneNumberException;
import factory.EntityFactory;
import model.dao.ContactDAO;
import model.dao.MyValidator;
import model.data.Contact;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SAXContactDAO {/*implements ContactDAO {
    @Override
    public void save(Contact contact) throws Exception {

    }

    //@Override
    public void remove(Contact contact) throws XPathExpressionException, ParserConfigurationException, TransformerException, IOException, SAXException {

    }

    @Override
    public void removeById(int id) throws ParserConfigurationException, XPathExpressionException, TransformerException, IOException, SAXException {

    }

    @Override
    public void update(Contact contact, int id) throws XPathExpressionException, TransformerException, ParserConfigurationException, IOException, SAXException {

    }

    @Override
    public Set<Contact> getAll() throws Exception {

        final Set<Contact> contactSet = new HashSet<Contact>();
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)) {

            try {


                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();

                DefaultHandler handler = new DefaultHandler() {

                    int id;
                    String firstName;
                    String lastName;
                    String number;
                    int groupId;
                    String symbol;

                    @Override
                    public void startElement(String uri, String localName, String qName,
                                             Attributes attributes) throws SAXException {
                        symbol = qName;
                    }

                    @Override
                    public void characters(char[] ch, int start, int length) throws SAXException {
                        if (symbol.equals("id")) {
                            id = Integer.valueOf(new String(ch, start, length));
                        }
                        if (symbol.equals("firstName")) {
                            firstName = new String(ch, start, length);
                        }
                        if (symbol.equals("lastName")) {
                            lastName = new String(ch, start, length);
                        }
                        if (symbol.equals("number")) {
                            number = new String(ch, start, length);
                        }
                        if (symbol.equals("groupId")) {
                            groupId = Integer.valueOf(new String(ch, start, length));
                        }
                    }

                    @Override
                    public void endElement(String uri, String localName,
                                           String qName) throws SAXException {

                        if (qName.equals("Contact")) {
                            Contact contact = null;
                            try {
                                contact = (Contact) EntityFactory.getEntity(id, firstName, lastName, number, groupId);
                            } catch (MyNotPhoneNumberException e) {
                                e.printStackTrace();
                            }
                            contactSet.add(contact);
                        }
                    }
                };

                saxParser.parse(xmlPath, handler);

            } catch (Exception e) {

            }
            return contactSet;
        }
        else {
            return new HashSet<Contact>();
        }
    }

    @Override
    public Contact getById(int id) throws Exception {
        Set<Contact> contactSet = getAll();

        Contact contact = null;

        for(Contact contact1:contactSet){
            if (contact1.getId()==id){
                contact=contact1;
            }
        }

        return contact;
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
    }*/
}
