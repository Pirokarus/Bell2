import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.dao.JacksonContactDao;
import model.dao.JacksonGroupDAO;
import model.dao.SAXContactDAO;
import model.dao.SAXGroupDAO;
import model.data.Contact;
import model.data.JacksonContactSet;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        SAXGroupDAO jacksonContactDao = new SAXGroupDAO();


        Test test = new Test();

        String xml = test.xml();
        String xsd = test.xsd();

        //jacksonContactDao.save();
        //jacksonContactDao.save(new Contact("d","d","2"));
/*
        XmlMapper mapper = new XmlMapper();

        Set<Contact> contactSet = new HashSet<Contact>();
        contactSet.add(new Contact("c","c","1"));
        contactSet.add(new Contact("d","d","2"));

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.writeValue(new File(xml),
                new JacksonContactSet(contactSet));*/

        System.out.println(jacksonContactDao.getAll());

    }

    public String xml(){
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Contacts.xml").getFile();
        return  xmlPath;
    }

    public String xsd(){
        ClassLoader classLoader = getClass().getClassLoader();
        String xsdPath = classLoader.getResource("ContactSet.xsd").getFile();
        return  xsdPath;
    }
}
