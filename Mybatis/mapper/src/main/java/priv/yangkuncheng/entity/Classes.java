package priv.yangkuncheng.entity;


import lombok.Data;

import java.util.List;
@Data
public class Classes {
    private long id=0;
    private String name=null;
    private List<Student>students=null;

    public Classes(long id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Classes() {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
