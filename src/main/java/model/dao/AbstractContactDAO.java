package model.dao;

import exceptions.MyNotPhoneNumberException;
import model.data.Contact;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Set;

public interface AbstractContactDAO {
    void save(Contact contact) throws Exception;
    void remove(Contact contact) throws XPathExpressionException, ParserConfigurationException, TransformerException, IOException, SAXException;
    void removeById(int id) throws ParserConfigurationException, XPathExpressionException, TransformerException, IOException, SAXException;
    void update(Contact contact, int id) throws XPathExpressionException, TransformerException, ParserConfigurationException, IOException, SAXException;
    Set<Contact> getAll() throws Exception;
    Contact getById(int id) throws Exception;
}
