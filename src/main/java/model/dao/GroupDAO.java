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
    /**
     * Метод сохраняет группу в файл Groups.xml, если файл пустой или в нем содержится не валидная информация,
     * то перезаписывает файл с нужной группой
     * @param group
     * @throws Exception
     */
    void save(Group group) throws Exception;

    /**
     * Метод удаляет группу из файла Groups.xml, если она там записана
     * @param group
     * @throws Exception
     */
    //void remove(Group group) throws Exception;

    /**
     * Метод удаляет группу с указаным id из файла Groups.xml, если она там записана
     * @param id
     * @throws Exception
     */
    void removeById(int id) throws Exception;

    /**
     * Метод обновляет группу с указаным id из файла Groups.xml, если она там записана,
     * если группа не найдена, то создаётся новая группа
     * @param group
     * @param id
     * @throws Exception
     */
    void update(Group group, int id) throws Exception;

    /**
     * Метод возвращает множество всех групп из файла Groups.xml
     * @return
     * @throws Exception
     */
    Set<Group> getAll() throws Exception;

    /**
     * Метод возвращает группу с указаным id из файла Groups.xml
     * @param id
     * @return
     * @throws Exception
     */
    Group getById(int id) throws Exception;
}
