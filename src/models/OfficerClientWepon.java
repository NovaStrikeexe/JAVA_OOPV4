package models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class OfficerClientWepon extends EntityClass {
    private ObjectProperty<Officer> officer = new SimpleObjectProperty<>();
    private ObjectProperty<Client> client = new SimpleObjectProperty<>();
    private ObjectProperty<Wepon> wepon = new SimpleObjectProperty<>();
    private ObjectProperty<Action> action = new SimpleObjectProperty<>();

    public OfficerClientWepon(Officer officer, Client client, Wepon wepon, Action action) {
        this.officer.set(officer);
        this.client.set(client);
        this.wepon.set(wepon);
        this.action.set(action);
    }

    public Officer getOfficer() { return officer.get(); }

    public ObjectProperty<Officer> officerProperty() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer.set(officer);
    }

    public Client getClient() {
        return client.get();
    }

    public ObjectProperty<Client> clientProperty() {
        return client;
    }

    public void setClient(Client client) {
        this.client.set(client);
    }

    public Wepon getWepon() {
        return wepon.get();
    }

    public ObjectProperty<Wepon> weponProperty() {
        return wepon;
    }

    public void setWepon(Wepon wepon) {
        this.wepon.set(wepon);
    }

    public Action getAction() {
        return action.get();
    }

    public ObjectProperty<Action> actionProperty() {
        return action;
    }

    public void setAction(Action action) {
        this.action.set(action);
    }

}
