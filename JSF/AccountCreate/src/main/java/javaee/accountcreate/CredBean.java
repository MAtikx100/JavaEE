/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package javaee.accountcreate;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mysza
 */
@Named(value = "credBean")
@SessionScoped
public class CredBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String user;
    private String pass;
    private String error = "Invalid";
    private List<Credentials> lista = new ArrayList<>();
    
    public CredBean() {
    }
    
    public void adder(){
        Credentials c = new Credentials(user, pass);
        lista.add(c);
        this.error = "Ivnalid";
    }
    
    public void check(){
        for (int i = 0; i < lista.size(); i++){
            if ((lista.get(i).login == null ? user == null : lista.get(i).login.equals(user)) && (lista.get(i).pass == null ? pass == null : lista.get(i).pass.equals(pass))){
                this.error = "Valid";
            }
        } 
        
        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Credentials> getLista() {
        return lista;
    }

    public void setLista(List<Credentials> lista) {
        this.lista = lista;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
