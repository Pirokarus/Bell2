package model.data;

import java.io.Serializable;

public class Group extends Entity implements Serializable{             //Класс для описания групп

    private static int id_count;
    private Integer id;
    private String name;

    {
        id = id_count;
        ++id_count;
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Индекс: " + id.toString() +
                " Название: " + name + '\'' +
                "\n";
    }

    public static int getId_count() {
        return id_count;
    }

    public static void setId_count(int id_count) {
        Group.id_count = id_count;
    }
}
