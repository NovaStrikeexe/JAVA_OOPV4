package models;

import gateways.EntityClass;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.PROPERTY)
public abstract class Human implements EntityClass {
    public int id;
    protected StringProperty nameofhuman = new SimpleStringProperty();
    protected StringProperty snameofhuman = new SimpleStringProperty();
    protected IntegerProperty ageofhuman = new SimpleIntegerProperty();

    public Human() { }

    public void setId(int id) { this.id = id; }

    public void setNameofhumanStr(String nameofhuman) {
        this.nameofhuman.set(nameofhuman);
    }

    public void setSnameofhumanStr(String snameofhuman) { this.snameofhuman.set(snameofhuman); }

    public void setAgeofhumanInt(Integer ageofhuman) { this.ageofhuman.set(ageofhuman); }

    public String getNameofhumanStr() {
        return nameofhuman.get();
    }
    public String getSnameofhumanStr() {
        return snameofhuman.get();
    }
    public Integer getAgeofhumanInt() {
        return ageofhuman.get();
    }

    @Transient
    public StringProperty getNameofhuman() {
        return nameofhuman;
    }
    @Transient
    public StringProperty getSnameofhuman() {
        return snameofhuman;
    }
    @Transient
    public IntegerProperty getAgeofhuman() {
        return ageofhuman;
    }
    @Id
    @GeneratedValue(generator="gen_human")
    @Override
    public int getId() { return id; }

    public String toString(){
        return getShortName();
    }
    @Transient
    public String getShortName() {
        return snameofhuman.get() + " " + nameofhuman.get().charAt(0);
    }


    public Human(int id, StringProperty nameofhuman, StringProperty snameofhuman, IntegerProperty ageofhuman) {
        this.nameofhuman = nameofhuman;
        this.snameofhuman = snameofhuman;
        this.ageofhuman = ageofhuman;
    }
}

