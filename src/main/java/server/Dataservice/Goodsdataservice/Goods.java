package server.Dataservice.Goodsdataservice;

import server.Dataservice.Pubservice.pub;

import java.rmi.RemoteException;
import java.util.List;

public interface Goods extends pub {
    List goodsFindGoodsByKeyword(String keyword) throws RemoteException;
    List goodsFindByKind(String kind)throws RemoteException;

}
