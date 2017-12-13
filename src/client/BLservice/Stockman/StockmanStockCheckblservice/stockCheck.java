package client.BLservice.Stockman.StockmanStockCheckblservice;

import shared.ResultMessage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:23 2017/11/26
 */
public interface stockCheck {
    List stockCheck() throws RemoteException;
    ResultMessage exportToExcel(int type,String path) throws RemoteException,IOException;
}
