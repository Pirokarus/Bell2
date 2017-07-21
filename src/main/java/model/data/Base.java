package model.data;

import java.io.Serializable;
import java.util.Set;

public class Base implements Serializable{          //Общий класс для сериализации, хранящий в себе помимо данных из модели static параметры классов

    private Set<Contact> contactSet;
    private Set<Group> groupSet;
    private int contactId = 0;
    private int groupId = 0;

    public Base() {
    }

    public Base(Set<Contact> contactSet, Set<Group> groupSet, int contactId, int groupId) {
        this.contactSet = contactSet;
        this.groupSet = groupSet;
        this.contactId = contactId;
        this.groupId = groupId;
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
