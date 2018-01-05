package driver;


import server.Dataservice.Consumerdataservice.Consumer;
import server.Po.consumerPO;

import java.rmi.RemoteException;

public class consumerdataservice_driver {

    public void driver(Consumer consumerdata) throws RemoteException {
        consumerPO po = new consumerPO(null, 0, 0, null, null, null, null, 0, 0, 0, null, null);
        String id = null;

        consumerdata.addObject(po, 13);
        System.out.println("Get ID succeed !");
        consumerdata.modifyObject(po, 13);
        System.out.println("Insert succeed !");
        consumerdata.deleteObject(po, 13);
        System.out.println("Delete succeed !");
        consumerdata.findConsumer(id);
        System.out.println("Find succeed !");
    }
}