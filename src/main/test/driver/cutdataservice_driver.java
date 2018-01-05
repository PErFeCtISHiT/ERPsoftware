package driver;

import server.Dataservice.Cutdataservice.cut;
import server.Po.cutPO;

import java.rmi.RemoteException;

public class cutdataservice_driver {

    public void driver(cut cutdata) throws RemoteException {
        cutPO po = new cutPO();
        String id = null;

        cutdata.addObject(po, 13);
        System.out.println("Get ID succeed !");
        cutdata.modifyObject(po, 13);
        System.out.println("Insert succeed !");
        cutdata.deleteObject(po, 13);
        System.out.println("Delete succeed !");
        cutdata.findAll(7);
        System.out.println("Find succeed !");
    }
}