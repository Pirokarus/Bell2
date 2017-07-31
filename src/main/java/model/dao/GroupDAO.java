package model.dao;

import model.data.Group;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Set;

public interface GroupDAO {
    void save(Group group) throws Exception;
    void remove(Group group) throws Exception;
    void removeById(int id) throws Exception;
    void update(Group group, int id) throws Exception;
    Set<Group> getAll() throws Exception;
    Group getById(int id) throws Exception;
}
