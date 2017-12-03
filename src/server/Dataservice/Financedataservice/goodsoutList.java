package server.Dataservice.Financedataservice;

import server.Dataservice.pubservice.pub;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 21:28 2017/12/3
 */
public interface goodsoutList extends pub {
    List findbysaleno(String no)throws RemoteException;
}
