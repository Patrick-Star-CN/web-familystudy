package com.study;

import java.io.Serializable;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class CookieBean implements Serializable {
    private String message;
    private String username;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CookieBean(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public CookieBean() {
    }
}
