package model.data.Jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import factory.EntityFactory;
import model.data.Group;

public class JacksonGroup {
    @JacksonXmlProperty(localName = "id")
    private Integer id;

    @JacksonXmlProperty(localName = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JacksonGroup() {
    }

    public JacksonGroup(Group group){
        this.id = group.getId();
        this.name = group.getName();
    }

    public Group getGroup(){
        return (Group) EntityFactory.getEntity(id,name);
    }
}
