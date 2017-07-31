package model.services;

import model.dao.ContactDAO;
import factory.DAOFactory;
import model.dao.DAOTypes;
import model.data.Contact;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ContactService extends Observable implements AbstractContactService {

    private static ContactService service = new ContactService();
    private List<Observer> observers = new ArrayList<Observer>();

    private ContactService(){}

    public static ContactService getInstance(){return service;}

    private ContactDAO contactDAO;

    {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("daotype.properties").getFile();
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fis);
            DAOTypes daoTypes = DAOTypes.valueOf(properties.getProperty("dao"));
            contactDAO = DAOFactory.getContactDAO(daoTypes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(Contact contact) throws Exception {
        contactDAO.save(contact);
        updateEvent();
    }

    public void remove(Contact contact) throws TransformerException, XPathExpressionException,
            ParserConfigurationException, IOException, SAXException {
        contactDAO.remove(contact);
        updateEvent();
    }

    public void removeById(int id) throws ParserConfigurationException, IOException, SAXException,
            XPathExpressionException, TransformerException {
        contactDAO.removeById(id);
        updateEvent();
    }

    public void update(Contact contact, int id) throws ParserConfigurationException, IOException,
            SAXException, XPathExpressionException, TransformerException {

        contactDAO.update(contact,id);
        updateEvent();
    }

    public Set<Contact> getAll() throws Exception {
        return contactDAO.getAll();
    }

    public Contact getById(int id) throws Exception {
        return contactDAO.getById(id);
    }

    public void updateEvent(){
        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }

    public void register(Observer outlet) {

        observers.add(outlet);

    }
}
