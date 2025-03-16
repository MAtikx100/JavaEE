/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package javaee.emplyees1;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mysza
 */
@Named
@SessionScoped
public class EmplyeeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String address;
    private ArrayList<Employee> lista = new ArrayList();
    
    public void adder(){
        Employee e = new Employee(name, surname, address);
        lista.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Employee> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Employee> lista) {
        this.lista = lista;
    }
    
}
