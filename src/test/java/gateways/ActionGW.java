package gateways;

import exceptions.EntityNotFound;
import models.Action;

public interface ActionGW extends Gateway<Action> {
    Action getGiven() throws EntityNotFound;
    Action getBacked() throws EntityNotFound ;

}
