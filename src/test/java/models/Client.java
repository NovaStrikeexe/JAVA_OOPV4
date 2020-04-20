package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.PROPERTY)
public class Client extends Human {
    private int id;
    @Id
    @GeneratedValue(generator="sqlite_client")
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
    }

    private BooleanProperty type_of_visit = new SimpleBooleanProperty();


    public void setType_of_visit(Boolean type_of_visit) {
        this.type_of_visit.set(type_of_visit);
    }
    public String toString(){
        return super.toString();
    }

    @Transient
    public BooleanProperty getTypeOfvisist() {
        return type_of_visit;
    }
    public void settypeOfVisistBool(boolean typeOfVisistBool){ this.type_of_visit.set( typeOfVisistBool);}
    public boolean gettypeOfVisistBool(){return type_of_visit.get();}

    public Client(){}
    public Client(String nameofhuman, String snameofhuman, Integer ageofhuman, Boolean type_of_visit) {
        super();
        this.nameofhuman.set(nameofhuman);
        this.snameofhuman.set(snameofhuman);
        this.ageofhuman.set(ageofhuman);
        this.type_of_visit.set(type_of_visit);
    }
}

