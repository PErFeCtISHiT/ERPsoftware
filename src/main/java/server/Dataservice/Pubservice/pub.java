package server.Dataservice.Pubservice;

import shared.ResultMessage;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: 数据层公共方法
 * @date: create in 13:55 2017/11/26
 */
public interface pub extends Remote{
    ResultMessage addObject(Object object,int type) throws RemoteException;
    ResultMessage deleteObject(Object object,int type) throws RemoteException;
    ResultMessage modifyObject(Object object,int type) throws RemoteException;
    List findAll(int type)throws RemoteException;
    List findbyNO(int type,String no)throws RemoteException;
    ResultMessage exportToExcel(int type,String path) throws RemoteException, IOException, InterruptedException;
}
