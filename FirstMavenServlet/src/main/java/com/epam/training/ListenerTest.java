package com.epam.training;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerTest implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, ServletRequestListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener.contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener.contextDestroyed()");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("ServletContextAttributeListener.attributeAdded(): " + event.getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("ServletContextAttributeListener.attributeRemoved(): " + event.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("ServletContextAttributeListener.attributeReplaced(): " + event.getName());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSessionListener.sessionCreated(): " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("HttpSessionListener.sessionDestroyed(): " + se.getSession().getId());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequestListener.requestDestroyed()");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequestListener.requestInitialized()");
    }

}
