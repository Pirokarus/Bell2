package factory;

import model.dao.*;
import model.dao.dom.DOMContactDAO;
import model.dao.dom.DOMGroupDAO;
import model.dao.jackson.JacksonContactDao;
import model.dao.jackson.JacksonGroupDAO;
import model.dao.sax.SAXContactDAO;
import model.dao.sax.SAXGroupDAO;

public class DAOFactory {
    public static ContactDAO getContactDAO(DAOTypes type){
        switch (type){
            case DOM:
                return new DOMContactDAO();
            case JACKSON:
                return new JacksonContactDao();
            case SAX:
                return new SAXContactDAO();
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
        }
        return null;
    }

}
