package models;

import gateways.EntityClass;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
@Entity
public class Action implements EntityClass {
    private int id;
    private StringProperty name = new SimpleStringProperty();

    private Action(String n) {
        name.set(n);
    }
    public String toString(){
        return name.get();
    }
    public Action() {
    }

    public static Action getGiving() {
        return new Action("Given");
    }

    public static Action getBacking() {
        return new Action("Backed");
    }

    @Id
    @GeneratedValue(generator="gen_action")
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}


