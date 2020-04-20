package models;

import gateways.EntityClass;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.PROPERTY)
public class OfficerClientWepon implements EntityClass {
    private int id;
    private ObjectProperty<Officer> officer = new SimpleObjectProperty<>();
    private ObjectProperty<Client> client = new SimpleObjectProperty<>();
    private ObjectProperty<Wepon> wepon = new SimpleObjectProperty<>();
    private ObjectProperty<Action> action = new SimpleObjectProperty<>();

    public OfficerClientWepon(){}
    public OfficerClientWepon(Officer officer, Client client, Wepon wepon, Action action) {
        this.officer.set(officer);
        this.client.set(client);
        this.wepon.set(wepon);
        this.action.set(action);
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officer_id", nullable = false)
    public Officer getOfficer() {
        return officer.get();
    }
    @Transient
    public ObjectProperty<Officer> officerProperty() {
        return officer;
    }
    public void setOfficer(Officer officer) {
        this.officer.set(officer);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    public Client getClient() {
        return client.get();
    }
    @Transient
    public ObjectProperty<Client> clientProperty() {
        return client;
    }
    public void setClient(Client client) {
        this.client.set(client);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wepon_id", nullable = false)
    public Wepon getWepon() {
        return wepon.get();
    }
    @Transient
    public ObjectProperty<Wepon> weponProperty() {
        return wepon;
    }
    public void setWepon(Wepon wepon) {
        this.wepon.set(wepon);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id", nullable = false)
    public Action getAction() {
        return action.get();
    }
    @Transient
    public ObjectProperty<Action> actionProperty() {
        return action;
    }
    public void setAction(Action action) {
        this.action.set(action);
    }

    @Id
    @GeneratedValue(generator="sqlite_officerClientWepon")
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) { }
}
