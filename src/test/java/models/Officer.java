package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.PROPERTY)
public class Officer extends Human {
    private int id;
    private StringProperty WorkExperience = new SimpleStringProperty();
    private StringProperty WorkSchedule = new SimpleStringProperty();

    @Id
    @GeneratedValue(generator="sqlite_officer")
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) { }

    public void setWorkExperience(String WorkExperience) {
        this.WorkExperience.set(WorkExperience);
    }

    public void setWorkSchedule(String WorkSchedule) {
        this.WorkSchedule.set(WorkSchedule);
    }
    @Transient
    public StringProperty getWorkExperience() {
        return WorkExperience;
    }
    public void setWorkExperienceStr(String WorkExperienceStr){this.WorkExperience.set(WorkExperienceStr);}
    public String getWorkExperienceStr(){return WorkExperience.get();}
    @Transient
    public StringProperty getWorkSchedule() {
        return WorkSchedule;
    }
    public void setWorkScheduleStr(String WorkScheduleStr){this.WorkSchedule.set(WorkScheduleStr);}
    public String getWorkScheduleStr(){return WorkSchedule.get();}

    public String toString() {
        return super.toString();
    }

    public Officer() { }
    public Officer(String nameofhuman, String snameofhuman, Integer ageofhuman,
                   String WorkExperience, String WorkSchedule) {
        this.nameofhuman.set(nameofhuman);
        this.snameofhuman.set(snameofhuman);
        this.ageofhuman.set(ageofhuman);
        this.WorkExperience.set(WorkExperience);
        this.WorkSchedule.set(WorkSchedule);
    }
}
