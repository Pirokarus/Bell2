package model.data.Jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import exceptions.MyNotPhoneNumberException;
import factory.EntityFactory;
import model.data.Contact;

import java.util.HashSet;
import java.util.Set;

@JacksonXmlRootElement(localName = "contactSet")
public class JacksonContactSet {
    @JacksonXmlProperty(localName = "Contact")
    @JacksonXmlElementWrapper(useWrapping = false)
    private JacksonContact[] contacts;

    public JacksonContactSet() {
    }

    public JacksonContact[] getContacts() {
        return contacts;
    }

    public void setContacts(JacksonContact[] contacts) {
        this.contacts = contacts;
    }

    public JacksonContactSet(Set<Contact> contactSet){

        this.contacts = new JacksonContact[contactSet.size()];

        int i = 0;
        for (Contact contact : contactSet){
            this.contacts[i] = new JacksonContact(contact.getId(),contact.getFirstName(),
                    contact.getLastName(),contact.getNumber(),contact.getGroupId());
            ++i;
        }
    }

    public Set<Contact> toContactSet() throws MyNotPhoneNumberException {
        Set<Contact> out = new HashSet<Contact>();

        if (this.contacts!=null) {
            for (int i = 0; i < this.contacts.length; ++i) {
                out.add((Contact)EntityFactory.getEntity(this.contacts[i].getId(),this.contacts[i].getFirstName(),
                        this.contacts[i].getLastName(),this.contacts[i].getNumber(),this.contacts[i].getGroupId()));
            }
        }
        return out;
    }
}
