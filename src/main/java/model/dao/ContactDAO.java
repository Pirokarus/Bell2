package model.dao;

import exceptions.MyNotPhoneNumberException;
import model.data.Contact;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Set;

public interface ContactDAO {
    /**
     * Метод сохраняет контакт в файл Contacts.xml, если файл пустой или в нем содержится не валидная информация,
     * то перезаписывает файл с нужным контактом
     * @param contact
     * @throws Exception
     */
    void save(Contact contact) throws Exception;

    /**
     * Метод удаляет контакт из файла Contacts.xml
     * @param contact
     * @throws Exception
     */
    void remove(Contact contact) throws Exception;

    /**
     * Метод удаляет контакт из файла Contacts.xml по id
     * @param id
     * @throws Exception
     */
    void removeById(int id) throws Exception;

    /**
     * Метод обновляет контакт из файла Contacts.xml по id,
     * если такого контакта нет, то создаёт новый
     * @param contact
     * @param id
     * @throws Exception
     */
    void update(Contact contact, int id) throws Exception;

    /**
     * Метод возвращает множество всех контактов из файла Contacts.xml
     * @return
     * @throws Exception
     */
    Set<Contact> getAll() throws Exception;

    /**
     * Метод возвращает контакт из файла Contacts.xml по id
     * @param id
     * @return
     * @throws Exception
     */
    Contact getById(int id) throws Exception;
}
