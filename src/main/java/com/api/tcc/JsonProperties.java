package com.api.tcc;

import org.hibernate.dialect.Dialect;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonProperties {
    private String source;
    private String user;
    private String password;
    private Dialect dialect;
    private int port;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Dialect getDialect() {
        return dialect;
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}