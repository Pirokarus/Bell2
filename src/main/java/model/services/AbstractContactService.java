package model.services;

import exceptions.MyNotPhoneNumberException;
import model.data.Contact;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Set;

public interface AbstractContactService {
    /**
     * Метод охраняет контакт
     * @param contact
     * @throws Exception
     */
    void save(Contact contact) throws Exception;

    /**
     * Метод удаляет контакт
     * @param contact
     * @throws Exception
     */
    //void remove(Contact contact) throws Exception;

    /**
     * Метод удаляет контакт по id
     * @param id
     * @throws Exception
     */
    void removeById(int id) throws Exception;

    /**
     * Метод обновляет контакт
     * @param contact
     * @param id
     * @throws Exception
     */
    void update(Contact contact, int id) throws Exception;

    /**
     * Метод возвращает список всех контактов
     * @return
     * @throws Exception
     */
    Set<Contact> getAll() throws Exception;

    /**
     * Метод возвращает контакт по id
     * @param id
     * @return
     * @throws Exception
     */
    Contact getById(int id) throws Exception;

}
