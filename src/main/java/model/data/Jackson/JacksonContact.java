package model.data.Jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import exceptions.MyNotPhoneNumberException;
import factory.EntityFactory;
import model.data.Contact;


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
    private Integer groupId;

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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public JacksonContact(Contact contact){
        this.id = contact.getId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.number = contact.getNumber();
        this.groupId = contact.getGroupId();
    }

    public Contact getContact() throws MyNotPhoneNumberException {
        return (Contact) EntityFactory.getEntity(id,firstName,lastName,number,getGroupId());
    }

}
