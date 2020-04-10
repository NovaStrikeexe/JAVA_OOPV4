package models;

import gateways.EntityClass;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.PROPERTY)
public class Human implements EntityClass {
    private int id;
    protected StringProperty nameofhuman = new SimpleStringProperty();
    protected StringProperty snameofhuman = new SimpleStringProperty();
    protected IntegerProperty ageofhuman = new SimpleIntegerProperty();

    public Human() { }

    public void setId(int id) { this.id = id; }

    public void setNameofhuman(String nameofhuman) {
        this.nameofhuman.set(nameofhuman);
    }

    public void setSnameofhuman(String snameofhuman) { this.snameofhuman.set(snameofhuman); }

    public void setAgeofhuman(Integer ageofhuman) { this.ageofhuman.set(ageofhuman); }

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
    @GeneratedValue(generator="sqlite_person")
    public int getId() { return id; }

    public String toString(){
        return getShortName();
    }

    private String getShortName() {
        return snameofhuman.get() + " " + nameofhuman.get().charAt(0);
    }

    public Human(long id, StringProperty nameofhuman, StringProperty snameofhuman, IntegerProperty ageofhuman) {
        this.nameofhuman = nameofhuman;
        this.snameofhuman = snameofhuman;
        this.ageofhuman = ageofhuman;
    }
}

