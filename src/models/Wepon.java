package models;

import javafx.beans.property.*;

public class Wepon extends EntityClass {
    private StringProperty mark = new SimpleStringProperty();
    private FloatProperty calibr = new SimpleFloatProperty();
    private IntegerProperty ammo = new SimpleIntegerProperty();


    public String getMark() {
        return mark.get();
    }

    public StringProperty markProperty() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark.set(mark);
    }

    public float getCalibr() {
        return calibr.get();
    }

    public FloatProperty calibrProperty() {
        return calibr;
    }

    public void setCalibr(float calibr) {
        this.calibr.set(calibr);
    }

    public int getAmmo() {
        return ammo.get();
    }

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