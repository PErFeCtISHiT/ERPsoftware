package server.Dataservice.Goodsdataservice;

import server.Dataservice.Pubservice.pub;

import java.rmi.RemoteException;
import java.util.List;

public interface GoodsKinds extends pub {
    List goodsKindsFindByKeyWord(String keyword)throws RemoteException;
}
