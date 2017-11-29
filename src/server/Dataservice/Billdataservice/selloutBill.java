package server.Dataservice.Billdataservice;

import server.Dataservice.pubservice.pub;
import server.Po.selloutPO;
import shared.ResultMessage;

import java.rmi.RemoteException;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:18 2017/11/26
 */
public interface selloutBill extends pub {
    selloutPO selloutfindByNO(String No)throws RemoteException;
}
