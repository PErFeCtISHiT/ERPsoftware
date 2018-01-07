package server.Dataservice.Codataservice;

import server.Dataservice.Pubservice.pub;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:01 2017/11/27
 */
public interface Coaccount extends pub {
    List findAccount(String keyword) throws RemoteException;

}
