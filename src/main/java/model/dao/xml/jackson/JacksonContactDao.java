package model.dao.xml.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.dao.ContactDAO;
import model.dao.MyValidator;
import model.data.Contact;
import model.data.Jackson.JacksonContactSet;

import java.io.File;
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

    //@Override
    public void remove(Contact contact) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();

        XmlMapper mapper = new XmlMapper();

        Set<Contact> contactSet;
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)){
            JacksonContactSet jacksonContactSet = mapper.readValue(new File(xmlPath),
                    JacksonContactSet.class);
            contactSet = jacksonContactSet.toContactSet();
            contactSet.remove(contact);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(xmlPath),
                    new JacksonContactSet(contactSet));
        }
    }

    @Override
    public void removeById(int id) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();

        XmlMapper mapper = new XmlMapper();

        Set<Contact> contactSet;
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)){

            JacksonContactSet jacksonContactSet = mapper.readValue(new File(xmlPath),
                    JacksonContactSet.class);

            contactSet = jacksonContactSet.toContactSet();
            Contact contact = null;

            for(Contact contact1:contactSet){
                if(contact1.getId()==id){
                    contact = contact1;
                }
            }

            if (contact!=null) {
                contactSet.remove(contact);
            }

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(xmlPath),
                    new JacksonContactSet(contactSet));
        }
    }

    @Override
    public void update(Contact contact, int id) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();

        XmlMapper mapper = new XmlMapper();

        Set<Contact> contactSet;
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)){

            JacksonContactSet jacksonContactSet = mapper.readValue(new File(xmlPath),
                    JacksonContactSet.class);

            contactSet = jacksonContactSet.toContactSet();
            Contact contact2 = null;

            for(Contact contact1:contactSet){
                if(contact1.getId()==id){
                    contact2 = contact1;
                }
            }

            if (contact2!=null) {
                contactSet.remove(contact2);
                contactSet.add(contact);
            }

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(xmlPath),
                    new JacksonContactSet(contactSet));
        }
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
            Set<Contact> contactSet = jacksonContactSet.toContactSet();
            int maxId = 0;
            for(Contact contact:contactSet){
                if(contact.getId()>maxId){
                    maxId = contact.getId();
                }
            }

            Contact.setId_count(maxId);

            return contactSet;
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
}
