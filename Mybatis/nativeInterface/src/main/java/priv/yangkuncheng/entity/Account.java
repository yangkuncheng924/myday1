package priv.yangkuncheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Account {
    private long id;
    private String username;
    private String password;
    private int age;

    public Account(long id, String username, String password, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public Account() {
    }
    //
//    public Account() {
//    }
}
