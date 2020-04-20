package models;

import gateways.EntityClass;
import javafx.beans.property.*;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Wepon implements EntityClass {
    private int id;
    private StringProperty mark = new SimpleStringProperty();
    private FloatProperty calibr = new SimpleFloatProperty();
    private IntegerProperty ammo = new SimpleIntegerProperty();

    @Id
    @GeneratedValue(generator="gen_wepon")
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {this.id = id;}

    public String getMark() {
        return mark.get();
    }
    @Transient
    public StringProperty markProperty() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark.set(mark);
    }

    public float getCalibr() {
        return calibr.get();
    }
    @Transient
    public FloatProperty calibrProperty() {
        return calibr;
    }

    public void setCalibr(float calibr) {
        this.calibr.set(calibr);
    }

    public int getAmmo() {
        return ammo.get();
    }
    @Transient
    public IntegerProperty ammoProperty() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo.set(ammo);
    }
    public String toString(){
        return getMark() +" "+ String.valueOf(getCalibr());
    }


    public Wepon(){}
    public Wepon(String mark, Float calibr, Integer ammo) {
        this.mark.set(mark);
        this.calibr.set(calibr);
        this.ammo.set(ammo);
    }

}