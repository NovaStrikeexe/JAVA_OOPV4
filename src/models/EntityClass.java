package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class EntityClass {
    protected IntegerProperty id = new SimpleIntegerProperty();

    public EntityClass() {
        this.id.set(0);
    }

    public  EntityClass(int id){
        this.id.set(id);
    }

    public int getId(){
        return this.id.get();
    }

    public IntegerProperty idProperty(){
        return this.id;
    }

    public void setId(int id){
        this.id.set(id);
    }

    public boolean isSaved(){
        return  this.id.get() != 0;
    }
}
