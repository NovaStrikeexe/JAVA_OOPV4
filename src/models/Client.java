package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client extends Human {

    private BooleanProperty type_of_visit = new SimpleBooleanProperty();


    public void setType_of_visit(Boolean type_of_visit) {
        this.type_of_visit.set(type_of_visit);
    }
    public String toString(){
        return super.toString();
    }


    public BooleanProperty getTypeOfvisist() {
        return type_of_visit;
    }


    public Client(String nameofhuman, String snameofhuman, Integer ageofhuman, Boolean type_of_visit) {
        super();
        this.nameofhuman.set(nameofhuman);
        this.snameofhuman.set(snameofhuman);
        this.ageofhuman.set(ageofhuman);
        this.type_of_visit.set(type_of_visit);
    }
}

