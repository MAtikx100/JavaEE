package mateusz.pepla.losoweliczby;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Random;

@Named
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String stringNum;
    private int higher;
    private boolean providedNum;

    public String submit(){

        Random r = new Random();
        int lower;
        providedNum = true;
        try {
            lower = Integer.parseInt(stringNum);
        } catch (Exception e){
            providedNum = false;
            return "result";
        }
        do {
           higher = r.nextInt();
        } while (higher <= lower);

        return "result";
    }

    public String getStringNum() {
        return stringNum;
    }

    public void setStringNum(String stringNum) {
        this.stringNum = stringNum;
    }

    public int getHigher() {
        return higher;
    }

    public void setHigher(int higher) {
        this.higher = higher;
    }

    public boolean isProvidedNum() {
        return providedNum;
    }

    public void setProvidedNum(boolean providedNum) {
        this.providedNum = providedNum;
    }
}
