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
    void save(Contact contact) throws Exception;
    void remove(Contact contact) throws Exception;
    void removeById(int id) throws Exception;
    void update(Contact contact, int id) throws Exception;
    Set<Contact> getAll() throws Exception;
    Contact getById(int id) throws Exception;
}
