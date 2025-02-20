/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaee.projcount.resources;

import jakarta.enterprise.inject.spi.CDI;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private final String username;
    
    public User(String username) {
        this.username = username;
    }

    private UserListBean getUserListBean() {
        return CDI.current().select(UserListBean.class).get();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        getUserListBean().addUser(event.getSession().getId(), username);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        getUserListBean().removeUser(event.getSession().getId());
    }

    public String getUsername() {
        return username;
    }
}