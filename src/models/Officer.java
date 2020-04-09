package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Officer extends Human {
    private StringProperty WorkExperience = new SimpleStringProperty();
    private StringProperty WorkSchedule = new SimpleStringProperty();


    public void setWorkExperience(String WorkExperience) {

        this.WorkExperience.set(WorkExperience);
    }

    public void setWorkSchedule(String WorkSchedule) {

        this.WorkSchedule.set(WorkSchedule);
    }

    public StringProperty getWorkExperience() {
        return WorkExperience;
    }

    public StringProperty getWorkSchedule() {
        return WorkSchedule;
    }

    public String toString(){
        return super.toString();
    }

    public Officer() {
    }

    public Officer(String nameofhuman, String snameofhuman, Integer ageofhuman,
                   String WorkExperience, String WorkSchedule) {
        this.nameofhuman.set(nameofhuman);
        this.snameofhuman.set(snameofhuman);
        this.ageofhuman.set(ageofhuman);
        this.WorkExperience.set(WorkExperience);
        this.WorkSchedule.set(WorkSchedule);
    }
}
