/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package javaee.displayname;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author mysza
 */
@Named(value = "nameBean")
@SessionScoped
public class NameBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    
    public NameBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String display(){
        return "display";
    }
}
