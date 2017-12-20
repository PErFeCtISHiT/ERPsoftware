package server.Dataservice.Financedataservice;

import client.Vo.saleVO;
import server.Dataservice.pubservice.pub;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 21:27 2017/12/3
 */
public interface sale extends pub {
    List findbySaleVO(saleVO saleVO) throws RemoteException;
    List search(String detail)throws RemoteException;
}
