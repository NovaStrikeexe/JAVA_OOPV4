package models;

import javafx.beans.property.StringProperty;

public class ShootingRange extends EntityClass {

    private Officer officer = new Officer();
    private StringProperty shotingGalleryType;
    private int sumOFTargets;
    private int activeTargets;

    public ShootingRange(Officer officer, StringProperty shotingGalleryType, int sumOFTargets, int activeTargets) {
        this.officer = officer;
        this.shotingGalleryType = shotingGalleryType;
        this.sumOFTargets = sumOFTargets;
        this.activeTargets = activeTargets;
    }

    public Officer getOfficer() {
        return officer;
    }

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
