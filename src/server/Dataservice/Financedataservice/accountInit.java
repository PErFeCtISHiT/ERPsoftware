package server.Dataservice.Financedataservice;

import server.Dataservice.pubservice.pub;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:28 2017/12/10
 */
public interface accountInit extends pub {
    List getPastAccount(String year) throws RemoteException;
    List getPastConsumer(String year) throws RemoteException;
    List getPastGoods(String year) throws RemoteException;
    void Build(String year) throws RemoteException, IllegalAccessException, IntrospectionException, InvocationTargetException;
}
