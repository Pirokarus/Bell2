package factory;

import model.dao.*;

public class DAOFactory {
    public static AbstractContactDAO getContactDAO(DAOTypes type){
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

    public static AbstractGroupDAO getGroupDAO(DAOTypes type){
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
