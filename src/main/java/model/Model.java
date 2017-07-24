package model;

import model.data.Base;
import model.data.Contact;
import model.data.Group;

import java.util.*;

public class Model extends Observable {                                //Класс - модель
    private Set<Contact> contactSet;
    private Set<Group> groupSet;
    private List<Observer> observers = new ArrayList<>();

    private static Model model;

    static {
        model = new Model();
    }

    public static Model getInstance(){
        return model;
    }

    private Model(){
    }



    public void register(Observer outlet) {

        observers.add(outlet);

    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {

        this.contactSet = contactSet;
        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }

    public void setModel(Base base){
        this.contactSet = base.getContactSet();
        this.groupSet = base.getGroupSet();

        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }


    /*  Следующие функции являются аналогами функций реализованных в View, поэтому на данный момент не используются

    public boolean addContact(Contact contact){

        boolean out = true;

        for (Contact c : this.contactSet) {
            if(c.getNumber().equals(contact.getNumber())){
                out = false;
            }
        }

        if(out){
            this.contactSet.add(contact);
        }

        return out;
    }

    public boolean addGroup(Group group){

        boolean out = true;

        for (Group g : this.groupSet) {
            if(g.getName().equals(group.getName())){
                out = false;
            }
        }

        if(out){
            this.groupSet.add(group);
        }

        return out;
    }

    public void deliteContact(Contact contact){
        this.contactSet.remove(contact);
    }*/
}
