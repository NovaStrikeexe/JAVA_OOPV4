package gateways;
import exceptions.EntityNotFound;
import models.Action;
public class ActionHibernateGateway extends SimpleHibernateGateway<Action> implements ActionGW {
    public Action getGiven() throws EntityNotFound {
        return this.find(1);
    }
    public Action getBacked() throws EntityNotFound {
        return this.find(2);
    }
}
