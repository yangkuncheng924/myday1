package priv.yangkuncheng.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String  name;
    private String  pawword;

    public User() {
    }

    public User(Integer id, String name, String pawword) {
        this.id = id;
        this.name = name;
        this.pawword = pawword;
    }

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

    public String getPawword() {
        return pawword;
    }

    public void setPawword(String pawword) {
        this.pawword = pawword;
    }
}
