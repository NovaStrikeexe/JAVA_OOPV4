package models;

import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.PROPERTY)
public class ShootingRange{

    private long id;
    private Officer officer = new Officer();
    private StringProperty shotingGalleryType;
    private int sumOFTargets;
    private int activeTargets;

    public ShootingRange(long id,Officer officer, StringProperty shotingGalleryType, int sumOFTargets, int activeTargets) {
        this.id = id;
        this.officer = officer;
        this.shotingGalleryType = shotingGalleryType;
        this.sumOFTargets = sumOFTargets;
        this.activeTargets = activeTargets;
    }
    public void setId(long id) { this.id = id; }
    public Officer getOfficer() {
        return officer;
    }
    @Id
    @GeneratedValue(generator="sqlite_person")
    public long getId() { return id; }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    public String getShotingGalleryType() {
        return shotingGalleryType.get();
    }

    public StringProperty shotingGalleryTypeProperty() {
        return shotingGalleryType;
    }

    public void setShotingGalleryType(String shotingGalleryType) {
        this.shotingGalleryType.set(shotingGalleryType);
    }

    public int getSumOFTargets() {
        return sumOFTargets;
    }

    public void setSumOFTargets(int sumOFTargets) {
        this.sumOFTargets = sumOFTargets;
    }

    public int getActiveTargets() {
        return activeTargets;
    }

    public void setActiveTargets(int activeTargets) {
        this.activeTargets = activeTargets;
    }
}
