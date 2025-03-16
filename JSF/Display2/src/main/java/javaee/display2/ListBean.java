
package javaee.display2;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;



@Named
@SessionScoped
public class ListBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private ArrayList<Person> people = new ArrayList();
    
    public ArrayList<Person> getPeople(){
        people.clear();
        Person p1 = new Person("Antek", "Dupa", "Gowno");
        Person p2 = new Person("Antek", "Dupaaaaa", "Gownoaaa");
        Person p3 = new Person("Antekssss", "Dupassss", "Gownosss");
        people.add(p1);
        people.add(p2);
        people.add(p3);
        return people;
    }
    
}
