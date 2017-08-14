package factory;

import model.dao.ContactDAO;
import model.dao.DAOTypes;

import model.dao.GroupDAO;

import model.dao.jdbc.JdbcContactDAO;
import model.dao.xml.dom.DOMContactDAO;
import model.dao.xml.dom.DOMGroupDAO;
import model.dao.xml.jackson.JacksonContactDao;
import model.dao.xml.jackson.JacksonGroupDAO;
import model.dao.xml.sax.SAXContactDAO;
import model.dao.xml.sax.SAXGroupDAO;

public class DAOFactory {
    public static ContactDAO getContactDAO(DAOTypes type){
        switch (type){
            case DOM:
                return new DOMContactDAO();
            case JACKSON:
                return new JacksonContactDao();
            case SAX:
                return new SAXContactDAO();
            case JDBC:
                return new JdbcContactDAO();
        }
        return null;
    }

    public static GroupDAO getGroupDAO(DAOTypes type){
        switch (type){
            case DOM:
                return new DOMGroupDAO();
            case JACKSON:
                return new JacksonGroupDAO();
            case SAX:
                return new SAXGroupDAO();
            case JDBC:
                return new JacksonGroupDAO();
        }
        return null;
    }

}
