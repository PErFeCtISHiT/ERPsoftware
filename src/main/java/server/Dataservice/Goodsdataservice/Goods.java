package server.Dataservice.Goodsdataservice;

import server.Dataservice.Pubservice.pub;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

public interface Goods extends pub {
    ResultMessage addObject(Object object,int type) throws RemoteException;
    ResultMessage deleteObject(Object object,int type) throws RemoteException;
    ResultMessage modifyObject(Object object,int type) throws RemoteException;
    List goodsfindGoods(String keyword) throws RemoteException;
    List goodsfindByKind(String kind)throws RemoteException;

}
