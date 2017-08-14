package model.dao.xml.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.dao.GroupDAO;
import model.dao.MyValidator;
import model.data.Contact;
import model.data.Group;
import model.data.Jackson.JacksonContactSet;
import model.data.Jackson.JacksonGroupSet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JacksonGroupDAO implements GroupDAO {
    @Override
    public void save(Group group) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        XmlMapper mapper = new XmlMapper();

        Set<Group> groupSet;
        String xsdPath = classLoader.getResource("GroupSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)){
            JacksonGroupSet jacksonGroupSet = mapper.readValue(new File(xmlPath),
                    JacksonGroupSet.class);
            groupSet = jacksonGroupSet.toGroupSet();
        }
        else{
            groupSet = new HashSet<Group>();
        }

        groupSet.add(group);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(xmlPath),
                new JacksonGroupSet(groupSet));
    }

    //@Override
    public void remove(Group group) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        XmlMapper mapper = new XmlMapper();

        Set<Group> groupSet;
        String xsdPath = classLoader.getResource("GroupSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)){
            JacksonGroupSet jacksonGroupSet = mapper.readValue(new File(xmlPath),
                    JacksonGroupSet.class);
            groupSet = jacksonGroupSet.toGroupSet();

            if (groupSet.contains(group)) {

                groupSet.remove(group);

                String xmlPath1 = classLoader.getResource("Contacts.xml").getFile();

                XmlMapper mapper1 = new XmlMapper();

                Set<Contact> contactSet;
                String xsdPath1 = classLoader.getResource("ContactSet.xsd").getFile();

                if(MyValidator.checkXMLforXSD(xmlPath1,xsdPath1)){

                    JacksonContactSet jacksonContactSet = mapper.readValue(new File(xmlPath1),
                            JacksonContactSet.class);

                    contactSet = jacksonContactSet.toContactSet();
/*
                    for(Contact contact:contactSet){
                        if(contact.getGroupId()==group.getId()){
                            contact.setGroupId(-1);
                        }
                    }
*/
                    mapper1.enable(SerializationFeature.INDENT_OUTPUT);
                    mapper1.writeValue(new File(xmlPath1),
                            new JacksonContactSet(contactSet));
                }
            }

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(xmlPath),
                    new JacksonGroupSet(groupSet));
        }
    }

    @Override
    public void removeById(int id) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        XmlMapper mapper = new XmlMapper();

        Set<Group> groupSet;
        String xsdPath = classLoader.getResource("GroupSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)){
            JacksonGroupSet jacksonGroupSet = mapper.readValue(new File(xmlPath),
                    JacksonGroupSet.class);
            groupSet = jacksonGroupSet.toGroupSet();

            Group group = null;
            for (Group group1:groupSet){
                if(group1.getId()==id){
                    group = group1;
                }
            }

            if (group!=null) {

                groupSet.remove(group);

                String xmlPath1 = classLoader.getResource("Contacts.xml").getFile();

                XmlMapper mapper1 = new XmlMapper();

                Set<Contact> contactSet;
                String xsdPath1 = classLoader.getResource("ContactSet.xsd").getFile();

                if(MyValidator.checkXMLforXSD(xmlPath1,xsdPath1)){

                    JacksonContactSet jacksonContactSet = mapper.readValue(new File(xmlPath1),
                            JacksonContactSet.class);

                    contactSet = jacksonContactSet.toContactSet();
/*
                    for(Contact contact:contactSet){
                        if(contact.getGroupId()==group.getId()){
                            contact.setGroupId(-1);
                        }
                    }
*/
                    mapper1.enable(SerializationFeature.INDENT_OUTPUT);
                    mapper1.writeValue(new File(xmlPath1),
                            new JacksonContactSet(contactSet));
                }
            }

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(xmlPath),
                    new JacksonGroupSet(groupSet));
        }
    }

    @Override
    public void update(Group group, int id) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

        XmlMapper mapper = new XmlMapper();

        Set<Group> groupSet;
        String xsdPath = classLoader.getResource("GroupSet.xsd").getFile();
        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)){
            JacksonGroupSet jacksonGroupSet = mapper.readValue(new File(xmlPath),
                    JacksonGroupSet.class);
            groupSet = jacksonGroupSet.toGroupSet();
        }
        else{
            groupSet = new HashSet<Group>();
        }

        Group group1 = null;

        for(Group group2:groupSet){
            if(group2.getId()==id){
                group1 = group2;
            }
        }

        if(group1!=null){
            groupSet.remove(group1);
        }

        groupSet.add(group);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(xmlPath),
                new JacksonGroupSet(groupSet));
    }

    @Override
    public Set<Group> getAll() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();
        String xsdPath = classLoader.getResource("GroupSet.xsd").getFile();

        if(MyValidator.checkXMLforXSD(xmlPath,xsdPath)) {
            XmlMapper mapper = new XmlMapper();
            JacksonGroupSet jacksonGroupSet = mapper.readValue(new File(xmlPath),
                    JacksonGroupSet.class);

            Set<Group> groupSet = jacksonGroupSet.toGroupSet();

            int maxId = 0;

            for (Group group : groupSet) {
                if (group.getId() > maxId) {
                    maxId = group.getId();
                }
            }

            Group.setId_count(maxId);

            return groupSet;
        }
        else return new HashSet<Group>();

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
