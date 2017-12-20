package client.BL.Manager.ManagerMakeCutService;

import client.BLservice.Manager.ManagerMakeCutblservice.ManagerMakeCutInterfaceForPack;
import client.RMI.link;
import server.Po.packPO;

import java.rmi.RemoteException;
import java.util.List;

public class PackController implements ManagerMakeCutInterfaceForPack{

    @Override
    public List<packPO> showpackPO() throws RemoteException {
        return link.getRemoteHelper().getPack().findAll(14);
    }
}
