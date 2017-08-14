package model.services;

import model.dao.GroupDAO;
import factory.DAOFactory;
import model.dao.DAOTypes;
import model.dao.jdbc.JdbcGroupDAO;
import model.dao.xml.jackson.JacksonGroupDAO;
import model.data.Group;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class GroupService extends Observable implements GroupDAO {

    private static GroupService service = new GroupService();
    private Vector<Observer> observers = new Vector<>();

    private GroupService(){}

    public static GroupService getInstance(){return service;}

    private GroupDAO groupDAO = new JdbcGroupDAO();

    {/*
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("daotype.properties").getFile();
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fis);
            DAOTypes daoTypes = DAOTypes.valueOf(properties.getProperty("dao"));
            groupDAO = DAOFactory.getGroupDAO(daoTypes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void save(Group group) throws Exception {
        groupDAO.save(group);
        updateEvent();
    }
/*
    @Override
    public void remove(Group group) throws Exception {
        groupDAO.remove(group);
        updateEvent();
    }*/

    @Override
    public void removeById(int id) throws Exception {
        groupDAO.removeById(id);
        updateEvent();
    }

    @Override
    public void update(Group group, int id) throws Exception {
        groupDAO.update(group,id);
        updateEvent();
    }

    @Override
    public Set<Group> getAll() throws Exception {
        return groupDAO.getAll();
    }

    @Override
    public Group getById(int id) throws Exception {
        return groupDAO.getById(id);
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
