package server.Dataservice.Financedataservice;

import server.Dataservice.pubservice.pub;

import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 14:00 2017/12/5
 */
public interface moneyList extends pub {
    void deleteByNO(String no) throws RemoteException;
}
