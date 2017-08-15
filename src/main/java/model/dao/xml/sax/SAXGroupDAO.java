package model.dao.xml.sax;

import factory.EntityFactory;
import model.dao.GroupDAO;
import model.data.Group;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SAXGroupDAO /*implements GroupDAO*/ {
    //@Override
    public void save(Group group) throws ParserConfigurationException, IOException, SAXException, TransformerException {

    }

    //@Override
    public void remove(Group group) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {

    }

    //@Override
    public void removeById(int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {

    }

    //@Override
    public void update(Group group, int id) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {

    }

    //@Override
    public Set<Group> getAll() throws Exception {
        final Set<Group> groupSet = new HashSet<Group>();
        ClassLoader classLoader = getClass().getClassLoader();
        String xmlPath = classLoader.getResource("Groups.xml").getFile();

            try {


                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();

                DefaultHandler handler = new DefaultHandler() {

                    int id;
                    String name;
                    String symbol;

                    @Override
                    public void startElement(String uri, String localName, String qName,
                                             Attributes attributes) throws SAXException {
                        symbol = qName;
                    }

                    @Override
                    public void characters(char[] ch, int start, int length) throws SAXException {
                        if (symbol.equals("id")) {
                            id = Integer.valueOf(new String(ch, start, length));
                        }
                        if (symbol.equals("name")) {
                            name = new String(ch, start, length);
                        }
                    }

                    @Override
                    public void endElement(String uri, String localName,
                                           String qName) throws SAXException {

                        if (qName.equals("Group")) {
                            Group group = null;

                            group = (Group) EntityFactory.getEntity(id, name);

                            groupSet.add(group);
                        }
                    }
                };

                saxParser.parse(xmlPath, handler);

            } catch (Exception e) {

            }
            return groupSet;

    }

    //@Override
    public Group getById(int id) throws Exception {
        Set<Group> groupSet = getAll();

        Group group = null;

        for(Group group1:groupSet){
            if (group1.getId()==id){
                group=group1;
            }
        }

        return group;
    }
}
