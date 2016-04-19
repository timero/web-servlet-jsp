package com.epam.training.model;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {

    private static final long serialVersionUID = 1L;

    public User() {
        super();
    }

    public User(String username, boolean admin) {
        super();
        this.username = username;
        this.admin = admin;
    }

    private String username;

    private boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public String getUsername() {
        return username;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBindingListener.valueBound()");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBindingListener.valueUnbound()");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("HttpSessionActivationListener.sessionWillPassivate()");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("HttpSessionActivationListener.sessionDidActivate()");
    }

}
