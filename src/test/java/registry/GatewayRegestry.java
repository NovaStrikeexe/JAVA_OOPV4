package registry;
import gateways.*;
import models.*;

public class GatewayRegestry {
    private Gateway<Action> actionGateway = new ActionHibernateGateway();
    private Gateway<Client> clientGateway = new ClientHibernateGateway();
    private Gateway<OfficerClientWepon> officerClientWeponGateway = new OFCLNWPHIbernateGateway();
    private Gateway<Officer> officerGateway = new OfficerHibernateGateway();
    private Gateway<Wepon> weponGateway = new WeponHibernateGateway();

    public Gateway<Action> getActionGateway() {
        return actionGateway;
    }

    public Gateway<Client> getClientGateway() {
        return clientGateway;
    }

    public Gateway<OfficerClientWepon> getOfficerClientWeponGateway() {
        return officerClientWeponGateway;
    }

    public Gateway<Officer> getOfficerGateway() {
        return officerGateway;
    }


    public Gateway<Wepon> getWeponGateway() {
        return weponGateway;
    }

    private GatewayRegestry(){}
    private static GatewayRegestry instance =new GatewayRegestry();
    public static GatewayRegestry getInstance(){return instance;}
}
