package model.services;

import model.dao.ContactDAO;
import factory.DAOFactory;
import model.dao.DAOTypes;
import model.data.Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ContactService extends Observable implements AbstractContactService {

    private static ContactService service = new ContactService();
    private ArrayList<Observer> observers = new ArrayList<>();

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

    public void save(Contact contact, int user_id) throws Exception {
        contactDAO.save(contact, user_id);
        updateEvent();
    }


    public void removeById(int id) throws Exception {
        contactDAO.removeById(id);
        updateEvent();
    }

    public void update(Contact contact, int id, int user_id) throws Exception {

        contactDAO.update(contact, id, user_id);
        updateEvent();
    }

    public Set<Contact> getAll(int user_id) throws Exception {
        return contactDAO.getAll(user_id);
    }

    public Contact getById(int id) throws Exception {
        return contactDAO.getById(id);
    }

    public void updateEvent(){
        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }

    public synchronized void register(Observer outlet) {

        observers.add(outlet);

    }

    public void addContactGroup(int idC, int idG) {
        contactDAO.addContactGroup(idC,idG);
        updateEvent();
    }

    public void removeContactGroup(int idC, int idG) {
        contactDAO.removeContactGroup(idC,idG);
        updateEvent();
    }

    public int login(String login, String password) {
        return contactDAO.login(login,password);
    }
}
