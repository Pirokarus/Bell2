package model.services;

import model.data.Group;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Set;

public interface AbstractGroupService {
    void save(Group group) throws ParserConfigurationException, IOException, SAXException, TransformerException;
    void remove(Group group) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException;
    void removeById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException;
    void update(Group group, int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException;
    Set<Group> getAll() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException;
    Group getById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException;
}
