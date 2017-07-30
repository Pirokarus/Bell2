package model;

/*
public class Model extends Observable {                                //Класс - модель
    private Set<Contact> contactSet;
    private Set<Group> groupSet;
    private List<Observer> observers = new ArrayList<Observer>();

    private static Model model;

    static {
        model = new Model();
    }

    public static Model getInstance(){
        return model;
    }

    private Model(){
    }

    public void updateEvent(){
        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }

    public void register(Observer outlet) {

        observers.add(outlet);

    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {

        this.contactSet = contactSet;
        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }

    public void setModel(Base base){
        this.contactSet = base.getContactSet();
        this.groupSet = base.getGroupSet();

        for (Observer outlet:this.observers){
            outlet.update(this,true);
        }
    }



    public boolean addContact(Contact contact){

        boolean out = true;

        for (Contact c : this.contactSet) {
            if(c.getNumber().equals(contact.getNumber())){
                out = false;
            }
        }

        if(out){
            this.contactSet.add(contact);
            updateEvent();
        }

        return out;
    }

    public boolean addGroup(Group group){

        boolean out = true;

        for (Group g : this.groupSet) {
            if(g.getName().equals(group.getName())){
                out = false;
            }
        }

        if(out){
            this.groupSet.add(group);
            updateEvent();
        }

        return out;
    }

    public void deliteContact(Contact contact){
        this.contactSet.remove(contact);
    }

    public void deliteContact(int id){
        Contact rContact = null;

        for (Contact contact:contactSet){
            if(id == contact.getId()){
                rContact = contact;
            }
        }
        if (rContact != null) {
            contactSet.remove(rContact);
            updateEvent();
        }
    }

    public void updateContact(Contact contact, int id) throws MyNotPhoneNumberException {
        for (Contact contact1 : this.contactSet){
            if(contact1.getId()==id){
                contact1.setFirstName(contact.getFirstName());
                contact1.setLastName(contact.getLastName());
                contact1.setNumber(contact.getNumber());
                contact1.setGroupId(contact.getGroupId());

                updateEvent();
            }
        }
    }

    public void deliteGroup(int id){
        Group dGroup = null;

        for (Group group : this.groupSet){
            if(id == group.getId()){
                dGroup = group;
            }
        }
        if (dGroup != null){
            this.groupSet.remove(dGroup);
            updateEvent();
        }

        for (Contact contact:contactSet){
            if(contact.getGroupId() != -1) {
                if (contact.getGroupId() == id) {
                    contact.setGroupId(-1);
                }
            }
        }
    }

    public void updateGroup(Group group, int id){
        for (Group group1 : this.groupSet){
            if(group1.getId() == id){
                group1.setName(group.getName());

                updateEvent();

                for (Contact contact : this.contactSet){
                    if (contact.getGroupId() == id){
                        contact.setGroupId(group1.getId());
                    }
                }

            }
        }
    }
}*/
