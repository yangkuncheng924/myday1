package priv.yangkuncheng.mybatis;

import javax.print.attribute.standard.RequestingUserName;
import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String pawword;

    public User(Integer id, String name, String pawword) {
        this.id = id;
        this.name = name;
        this.pawword = pawword;
    }

    public User() {
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

    public String getpawword(String s) {
        return pawword;
    }

    public void setPassword(String pawword) {
        this.pawword = pawword;
    }
}
