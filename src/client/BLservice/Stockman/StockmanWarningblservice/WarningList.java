package client.BLservice.Stockman.StockmanWarningblservice;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:48 2017/12/5
 */
public interface WarningList {
    List getAllDraft() throws RemoteException;
}
