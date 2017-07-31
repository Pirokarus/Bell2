package model.data.Jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import factory.EntityFactory;
import model.data.Group;

import java.util.HashSet;
import java.util.Set;

@JacksonXmlRootElement(localName = "groupSet")
public class JacksonGroupSet {

    @JacksonXmlProperty(localName = "Group")
    @JacksonXmlElementWrapper(useWrapping = false)
    private JacksonGroup[] groups;

    public JacksonGroupSet() {
    }

    public JacksonGroup[] getGroups() {
        return groups;
    }

    public void setGroups(JacksonGroup[] groups) {
        this.groups = groups;
    }

    public JacksonGroupSet(Set<Group> groupSet){

        this.groups = new JacksonGroup[groupSet.size()];

        int i = 0;
        for (Group group : groupSet){
            this.groups[i] = new JacksonGroup(group.getId(),group.getName());
            ++i;
        }
    }

    public Set<Group> toGroupSet(){
        Set<Group> out = new HashSet<Group>();

        if (this.groups!=null) {
            for (int i = 0; i < this.groups.length; ++i) {
                out.add((Group) EntityFactory.getEntity(this.groups[i].getId(), this.groups[i].getName()));
            }
        }
        return out;
    }
}
