package server.Dataservice.Consumerdataservice;

import server.Dataservice.pubservice.pub;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:02 2017/11/27
 */
public interface Consumer extends pub {
    List findConsumer(String keyword) throws RemoteException;
}
