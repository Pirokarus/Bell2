package model.services;

import model.data.Group;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Set;

public interface AbstractGroupService {
    /**
     * Метод сохраняет новую группу
     * @param group
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws TransformerException
     */
    void save(Group group) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    /**
     * Метод удаляет группу
     * @param group
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws XPathExpressionException
     * @throws TransformerException
     */
    void remove(Group group) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException;

    /**
     * Метод удаляет группу по id
     * @param id
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws XPathExpressionException
     * @throws TransformerException
     */
    void removeById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException;

    /**
     * Метод обновляет группу
     * @param group
     * @param id
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws XPathExpressionException
     * @throws TransformerException
     */
    void update(Group group, int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException;

    /**
     * Метод возвращает множество всех групп
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws XPathExpressionException
     */
    Set<Group> getAll() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException;

    /**
     * Метод возвращает группу с указанным id
     * @param id
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws XPathExpressionException
     */
    Group getById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException;
}
