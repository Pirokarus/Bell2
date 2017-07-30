package model.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

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
            this.groups[i] = new JacksonGroup(group);
            ++i;
        }
    }

    public Set<Group> toGroupSet(){
        Set<Group> out = new HashSet<Group>();

        for(int i = 0; i<this.groups.length; ++i){
            out.add(this.groups[i].getGroup());
        }
        return out;
    }
}
