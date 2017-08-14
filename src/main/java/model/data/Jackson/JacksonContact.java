package model.data.Jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import exceptions.MyNotPhoneNumberException;
import factory.EntityFactory;
import model.data.Contact;

import java.util.Set;


public class JacksonContact {

    @JacksonXmlProperty(localName = "id")
    private Integer id;

    @JacksonXmlProperty(localName = "firstName")
    private String firstName;

    @JacksonXmlProperty(localName = "lastName")
    private String lastName;

    @JacksonXmlProperty(localName = "number")
    private String number;

    @JacksonXmlProperty(localName = "groupId")
    private Set<Integer> groupId;

    public JacksonContact() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Integer> getGroupId() {
        return groupId;
    }

    public void setGroupId(Set<Integer> groupId) {
        this.groupId = groupId;
    }

    /*
    public JacksonContact(Contact contact){
        this.id = contact.getId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.number = contact.getNumber();
        this.groupId = contact.getGroupId();
    }*/

    public JacksonContact(Integer id, String firstName, String lastName, String number, Set<Integer> groupId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.groupId = groupId;
    }

    /*
    public Contact getContact() throws MyNotPhoneNumberException {
        return (Contact) EntityFactory.getEntity(id,firstName,lastName,number,getGroupId());
    }*/

}
