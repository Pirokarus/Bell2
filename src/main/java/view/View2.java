package view;

import exceptions.MyNotPhoneNumberException;
import model.services.ContactService;
import model.services.GroupService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class View2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        try {
            System.out.println(ContactService.getInstance().getAll(1));
            System.out.println(GroupService.getInstance().getAll(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
