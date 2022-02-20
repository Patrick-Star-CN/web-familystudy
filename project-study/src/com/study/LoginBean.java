package com.study;

import java.io.Serializable;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class LoginBean implements Serializable {
    private String username;
    private String password;

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

    public LoginBean() {
    }

    public LoginBean(String name, String password) {
        this.username = name;
        this.password = password;
    }
}
