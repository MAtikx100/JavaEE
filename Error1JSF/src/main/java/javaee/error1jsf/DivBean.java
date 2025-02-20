/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package javaee.error1jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@Named
@SessionScoped
public class DivBean implements Serializable{

    private static final long serialVersionUID = 1L;
    protected int numerator;
    protected int denominator;
    private String result;
    
    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String results){
        this.result = results;
    }
    public String performDivision() {
        if (denominator == 0) {
            return "error";
        } else {
            result = String.valueOf((double) numerator / denominator);
            return "index";
        }
    }

}
