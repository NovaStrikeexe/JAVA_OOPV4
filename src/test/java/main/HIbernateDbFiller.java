package main;

import gateways.*;
import models.Action;
import models.Client;
import models.Officer;
import models.Wepon;
import registry.GatewayRegestry;

public class HIbernateDbFiller {
    public static void main(String[] args) {
        ClientHibernateGateway clientHibernateGateway = (ClientHibernateGateway) GatewayRegestry.getInstance().getClientGateway();
        OfficerHibernateGateway officerHibernateGateway = (OfficerHibernateGateway) GatewayRegestry.getInstance().getOfficerGateway();
        WeponHibernateGateway weponHibernateGateway = (WeponHibernateGateway) GatewayRegestry.getInstance().getWeponGateway();
        ActionHibernateGateway actionHibernateGateway =(ActionHibernateGateway) GatewayRegestry.getInstance().getActionGateway();
        OFCLNWPHIbernateGateway ofclnwphIbernateGateway =(OFCLNWPHIbernateGateway) GatewayRegestry.getInstance().getOfficerClientWeponGateway();
        Client client1 = new Client("Nova", "Strike", 25, true);
        Client client2 = new Client("Alex", "Strike", 45, true);
        Client client3 = new Client("Jackob", "Irons", 20, false);
        Client client4 = new Client("Michell", "Irons", 22, true);
        Client client5 = new Client("George", "William", 18, false);

        Officer officer1 = new Officer("Hilda", "Richards", 35, "10-Years", "800/1700");
        Officer officer2 = new Officer("Winfred", "Joseph", 55, "20-Years", "800/1700");
        Officer officer3 = new Officer("Pierce", "Owens", 25, "1-Year", "1300/1700");
        Officer officer4 = new Officer("Francis", "Bradford", 26, "2-Year", "1300/1700");
        Officer officer5 = new Officer("Olivia", "Alexander", 24, "None", "800/1300");

        Wepon wepon1 = new Wepon("Ak-15", (float) 5.56, 30);
        Wepon wepon2 = new Wepon("Ak-47", (float) 7.62, 60);
        Wepon wepon3 = new Wepon("M416", (float) 5.56, 45);
        Wepon wepon4 = new Wepon("M16A2", (float) 7.62, 30);
        Wepon wepon5 = new Wepon("M417", (float) 0.338, 20);

        /*TODO ACTION DB*/
        Action action1 = new Action();
        Action action2 = new Action();

        clientHibernateGateway.insert(client1);
        clientHibernateGateway.insert(client2);
        clientHibernateGateway.insert(client3);
        clientHibernateGateway.insert(client4);
        clientHibernateGateway.insert(client5);

        officerHibernateGateway.insert(officer1);
        officerHibernateGateway.insert(officer2);
        officerHibernateGateway.insert(officer3);
        officerHibernateGateway.insert(officer4);
        officerHibernateGateway.insert(officer5);

        weponHibernateGateway.insert(wepon1);
        weponHibernateGateway.insert(wepon2);
        weponHibernateGateway.insert(wepon3);
        weponHibernateGateway.insert(wepon4);
        weponHibernateGateway.insert(wepon5);

    }
}
