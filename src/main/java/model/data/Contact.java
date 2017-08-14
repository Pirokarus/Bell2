package model.data;

import exceptions.MyNotPhoneNumberException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Contact extends Entity implements Serializable{           //Класс для описания контактов

    private static int id_count;
    private Integer id;
    private String firstName;
    private String lastName;
    private String number;
    private Set<Integer> groupId = new HashSet<>();

    public Contact(String firstName, String number) throws MyNotPhoneNumberException {
        this.firstName = firstName;
        setNumber(number);
    }

    public Contact(String firstName, String lastName, String number) throws MyNotPhoneNumberException {
        this.firstName = firstName;
        this.lastName = lastName;
        setNumber(number);
    }

    public Contact(Integer id, String firstName, String lastName, String number, Set<Integer> groupId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.groupId = groupId;
        --id_count;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws MyNotPhoneNumberException {
        char[] nimChar = number.toCharArray();
        for (char c:nimChar){
            if(!(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'||c=='+')){
                throw new MyNotPhoneNumberException();
            }
        }
        this.number = number;
    }

    public Set<Integer> getGroupId() {
        return groupId;
    }

    public void setGroupId(Set<Integer> groupId) {
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public static int getId_count() {
        return id_count;
    }

    public static void setId_count(int id_count) {
        Contact.id_count = id_count;
    }

    public void addGroupId(Integer i){
        groupId.add(i);
    }

    public void removeGroup(Integer i){
        groupId.remove(i);
    }

    public boolean containGroup(Integer id){
        return groupId.contains(id);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number='" + number + '\'' +
                ", groupId=" + groupId + '\'' +
                "\n";
    }
}
