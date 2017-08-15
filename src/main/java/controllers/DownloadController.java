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



    /**
     * Метод добавления контакта
     * @param contact
     * @throws TransformerException
     * @throws ParserConfigurationException
     */
    public void addContact(Contact contact, int user_id) throws TransformerException, ParserConfigurationException {
        try {
            contactService.save(contact, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод обновляет контакт
     * @param contact
     * @param id
     * @throws MyNotPhoneNumberException
     */
    public void updateContact(Contact contact, int id, int user_id) throws MyNotPhoneNumberException{
        try {
            contactService.update(contact, id, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаляет контакт по id
     * @param id
     */
    public void deliteContact(int id){
        try {
            contactService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод добавляет новую группу
     * @param group
     */
    public void addGroup(Group group, int user_id){
        try {
            groupService.save(group, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаляет группу по id
     * @param id
     */
    public void deliteGroup(int id){
        try {
            groupService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод обновляет группу
     * @param group
     * @param id
     */
    public void updateGroup(Group group, int id, int user_id){
        try {
            groupService.update(group,id, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addContactGroup(int idC, int idG) {
        contactService.addContactGroup(idC,idG);
    }

    public void removeContactGroup(int idC, int idG) {
        contactService.removeContactGroup(idC,idG);
    }

    public int login(String login, String password) {
        return contactService.login(login,password);
    }
}
