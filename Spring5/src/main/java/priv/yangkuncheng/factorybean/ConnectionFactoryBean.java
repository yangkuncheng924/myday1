package priv.yangkuncheng.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactoryBean implements FactoryBean<Connection> {
    private String diverClassName;
    private String url;
    private String username;
    private String password;

    public String getDiverClassName() {
        return diverClassName;
    }

    public void setDiverClassName(String diverClassName) {
        this.diverClassName = diverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Connection getObject() throws Exception {
        Class.forName(diverClassName);

        Connection coon = DriverManager.getConnection(url, username, password);
        return coon;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
