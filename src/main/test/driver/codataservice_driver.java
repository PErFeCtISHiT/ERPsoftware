package driver;

import server.Dataservice.Codataservice.Coaccount;
import server.Po.coPO;

import java.rmi.RemoteException;

public class codataservice_driver {

    public void driver(Coaccount codata) throws RemoteException {
        coPO po = new coPO();
        String id = null;
        po.setKeyno(null);

        codata.addObject(po,13);
        System.out.println("Get ID succeed !");
        codata.modifyObject(po,13);
        System.out.println("Insert succeed !");
        codata.deleteObject(po,13);
        System.out.println("Delete succeed !");
        codata.findAccount(id);
        System.out.println("Find succeed !");
    }
}