package client.BL.Manager.ManagerMakeCutService;

import client.BLservice.Manager.ManagerMakeCutblservice.ManagerMakeCutblInterface;
import client.RMI.link;
import server.Po.cutPO;
import server.Po.packPO;
import server.Po.salePO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public class CutController implements ManagerMakeCutblInterface {


    @Override
    public List<cutPO> showcutPO() throws RemoteException {
        return link.getRemoteHelper().getCut().findAll(12);
    }

    @Override
    public void addPO(cutPO po) throws RemoteException {
        link.getRemoteHelper().getCut().addObject(po,12);
    }


}
