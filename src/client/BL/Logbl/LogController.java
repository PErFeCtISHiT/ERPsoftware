package client.BL.Logbl;

import client.BLservice.LogblInterface.LogblInteface;
import client.RMI.link;
import server.Po.logPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class LogController implements LogblInteface{


    @Override
    public ArrayList<Log> show() throws RemoteException {
        List<logPO> list = link.getRemoteHelper().getLog().findAll(13);
        ArrayList<Log> loglist = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            Log nl = PoToLog(list.get(i));
            loglist.add(nl);
        }
        return loglist;
    }

    @Override
    public Log PoToLog(logPO log) throws RemoteException {

        Log newlog = new Log();
        newlog.settime(log.getAdddate().toString());
        newlog.setstaffno(log.getOperatorno());
        newlog.setoperation(log.getOpno());
        return newlog;
    }
}
