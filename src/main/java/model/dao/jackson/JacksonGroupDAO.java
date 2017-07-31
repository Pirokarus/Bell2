package model.dao.jackson;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.dao.GroupDAO;
import model.data.Group;
import model.data.Jackson.JacksonGroupSet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class JacksonGroupDAO implements GroupDAO {
    @Override
    public void save(Group group) throws ParserConfigurationException, IOException, SAXException, TransformerException {

    }

    @Override
    public void remove(Group group) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {

    }

    @Override
    public void removeById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {

    }

    @Override
    public void update(Group group, int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {

    }

    @Override
    public Set<Group> getAll() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

            XmlMapper mapper = new XmlMapper();
            JacksonGroupSet jacksonGroupSet = mapper.readValue(new File(xmlPath),
                    JacksonGroupSet.class);
            return jacksonGroupSet.toGroupSet();

    }

    @Override
    public Group getById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();
        XmlMapper mapper = new XmlMapper();
        JacksonGroupSet jacksonGroupSet = mapper.readValue(new File(xmlPath),
                JacksonGroupSet.class);

        Set<Group> groupSet = jacksonGroupSet.toGroupSet();
        Group outGroup = null;
        for (Group group : groupSet) {
            if(group.getId()==id){
                outGroup = group;
            }
        }

        return outGroup;
    }
}
