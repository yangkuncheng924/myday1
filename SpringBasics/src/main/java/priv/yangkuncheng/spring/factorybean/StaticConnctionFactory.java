package priv.yangkuncheng.spring.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StaticConnctionFactory {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;

    }
}