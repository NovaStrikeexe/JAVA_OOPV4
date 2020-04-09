package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Human extends EntityClass{
    protected StringProperty nameofhuman = new SimpleStringProperty();
    protected StringProperty snameofhuman = new SimpleStringProperty();
    protected IntegerProperty ageofhuman = new SimpleIntegerProperty();

    public void setNameofhuman(String nameofhuman) {
        this.nameofhuman.set(nameofhuman);
    }

    public void setSnameofhuman(String snameofhuman) { this.snameofhuman.set(snameofhuman); }

    public void setAgeofhuman(Integer ageofhuman) { this.ageofhuman.set(ageofhuman); }


    public StringProperty getNameofhuman() {
        return nameofhuman;
    }

    public StringProperty getSnameofhuman() {
        return snameofhuman;
    }


    public IntegerProperty getAgeofhuman() {
        return ageofhuman;
    }


    public Human() {
        super();
    }
    public String toString(){
        return getShortName();
    }

    private String getShortName() {
        return snameofhuman.get() + " " + nameofhuman.get().charAt(0);
    }

    public Human(String nameofhuman, String snameofhuman, Integer ageofhuman) {
        super();
        this.nameofhuman.set(nameofhuman);
        this.snameofhuman.set(snameofhuman);
        this.ageofhuman.set(ageofhuman);

    }
}

