package model;

import model.dao.AbstractDAO;
import model.dao.SimpleDAO;
import model.data.Base;
import model.data.Contact;
import model.data.Group;

import java.util.HashSet;

public class Service {

    private AbstractDAO dao;

    public Base downloadData(){                     //Извличение данных

        dao = new SimpleDAO();
        Base base = dao.getBase();
        Contact.setId_count(dao.getBase().getContactId());
        Group.setId_count(dao.getBase().getGroupId());
        if (base.getContactSet() == null){
            base.setContactSet(new HashSet<Contact>());
            Contact.setId_count(0);
        }
        if (base.getGroupSet() == null){
            base.setGroupSet(new HashSet<Group>());
            Group.setId_count(0);
        }
        return base;
    }

    public void save(Base base){                                 //Функция сохранения во внешнюю БД
        base.setContactId(Contact.getId_count());
        base.setGroupId(Group.getId_count());
        dao.saveBase(base);
    }

}
