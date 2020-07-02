package priv.yangkuncheng.entity;

import lombok.Data;

@Data
public class Student {
    private long id;
    private String name;
    private Classes classes;

    public Student(long id, String name, Classes classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
