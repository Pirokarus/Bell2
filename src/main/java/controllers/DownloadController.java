package controllers;

import model.Model;
import model.Service;
import model.data.Base;
import model.data.Contact;
import model.data.Group;

import java.util.Set;

public class DownloadController {

    Model model = Model.getInstance();
    Service service = new Service();

    public void downloadModelData(){
        Base base = service.downloadData();
        model.setModel(base);
    }

    public void updateModelContactSet(Set<Contact> contactSet) {
        model.setContactSet(contactSet);
        save();
    }

    public void updateModelGroupSet(Set<Group> groupSet) {
        model.setGroupSet(groupSet);
        save();
    }

    public void save(){
        Base base = new Base();
        base.setContactSet(model.getContactSet());
        base.setGroupSet(model.getGroupSet());
        service.save(base);
    }
}
