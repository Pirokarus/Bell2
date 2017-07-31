package model.dao.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.dao.ContactDAO;
import model.dao.MyValidator;
import model.data.Contact;
import model.data.Jackson.JacksonContactSet;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JacksonContactDao implements ContactDAO {
    @Override
    public void save(Contact contact) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();

        XmlMapper mapper = new XmlMapper();

        Set<Contact> contactSet;
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)){
            JacksonContactSet jacksonContactSet = mapper.readValue(new File(xmlPath),
                    JacksonContactSet.class);
            contactSet = jacksonContactSet.toContactSet();
        }
        else{
            contactSet = new HashSet<Contact>();
        }

        contactSet.add(contact);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(xmlPath),
                new JacksonContactSet(contactSet));
    }

    @Override
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
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)) {
            XmlMapper mapper = new XmlMapper();
            JacksonContactSet jacksonContactSet = mapper.readValue(new File(xmlPath),
                    JacksonContactSet.class);
            return jacksonContactSet.toContactSet();
        }
        else return new HashSet<>();
    }

    @Override
    public Contact getById(int id) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)) {
            XmlMapper mapper = new XmlMapper();
            JacksonContactSet jacksonContactSet = mapper.readValue(new File(xmlPath),
                    JacksonContactSet.class);
            Set<Contact> contactSet = jacksonContactSet.toContactSet();
            Contact outContact = null;
            for (Contact contact : contactSet) {
                if (contact.getId() == id) {
                    outContact = contact;
                }
            }
            return outContact;
        }
        else return null;

    }
}
