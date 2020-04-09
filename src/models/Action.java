package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Action extends EntityClass{
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
}


