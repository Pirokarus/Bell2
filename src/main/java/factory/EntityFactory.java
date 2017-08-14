package factory;

import exceptions.MyNotPhoneNumberException;
import model.data.Contact;
import model.data.Entity;
import model.data.Group;

import java.util.Set;

public class EntityFactory {
    public static Entity getEntity(String name){
        return new Group(name);
    }

    public static Entity getEntity(int id, String name){
        return new Group(id, name);
    }

    public static Entity getEntity(String firstName, String number) throws MyNotPhoneNumberException {
        return new Contact(firstName, number);
    }

    public static Entity getEntity(String firstName, String lastName, String number) throws MyNotPhoneNumberException {
        return new Contact(firstName, lastName, number);
    }

    public static Entity getEntity(int id, String firstName, String lastName, String number, Set<Integer> groupId) throws MyNotPhoneNumberException {
        return new Contact(id, firstName, lastName, number, groupId);
    }
}
