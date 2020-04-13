package registry;
import gateways.*;
public class GatewayRegestry {
    private ActionGateway actionGateway = new ActionGateway();
    private ClientGateway clientGateway = new ClientGateway();
    private OfficerClientWeponGateway officerClientWeponGateway = new OfficerClientWeponGateway();
    private OfficerGateway officerGateway = new OfficerGateway();
    private ShootingRangeGateway shootingRangeGateway = new ShootingRangeGateway();
    private WeponGateway weponGateway = new WeponGateway();

    public ActionGateway getActionGateway() {
        return actionGateway;
    }

    public ClientGateway getClientGateway() {
        return clientGateway;
    }

    public OfficerClientWeponGateway getOfficerClientWeponGateway() {
        return officerClientWeponGateway;
    }

    public OfficerGateway getOfficerGateway() {
        return officerGateway;
    }

    public ShootingRangeGateway getShootingRangeGateway() {
        return shootingRangeGateway;
    }

    public WeponGateway getWeponGateway() {
        return weponGateway;
    }
    private GatewayRegestry(){}
    private static GatewayRegestry instance =new GatewayRegestry();
    public GatewayRegestry getInstance(){return instance;}
}
