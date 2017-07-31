package controllers;

import exceptions.MyNotPhoneNumberException;
import model.data.Contact;
import model.data.Group;
import model.services.ContactService;
import model.services.GroupService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class DownloadController {

    ContactService contactService = ContactService.getInstance();
    GroupService groupService = GroupService.getInstance();


    public void addContact(Contact contact) throws TransformerException, ParserConfigurationException {
        try {
            contactService.save(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateContact(Contact contact, int id) throws MyNotPhoneNumberException{
        try {
            contactService.update(contact, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deliteContact(int id){
        try {
            contactService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addGroup(Group group){
        try {
            groupService.save(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deliteGroup(int id){
        try {
            groupService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGroup(Group group, int id){
        try {
            groupService.update(group,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
