package factory;

import exceptions.MyNotPhoneNumberException;
import model.data.Contact;
import model.data.Entity;
import model.data.Group;

public class EntityFactory {
    public Entity getEntity(String name){
        return new Group(name);
    }

    public Entity getEntity(String firstName, String number) throws MyNotPhoneNumberException {
        return new Contact(firstName, number);
    }

    public Entity getEntity(String firstName, String lastName, String number) throws MyNotPhoneNumberException {
        return new Contact(firstName, lastName, number);
    }
}
