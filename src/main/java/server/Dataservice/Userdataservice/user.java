package server.Dataservice.Userdataservice;

import server.Dataservice.pubservice.pub;
import server.Po.userPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 19:04 2017/11/27
 */
public interface user extends pub {
    List login(String username, String password) throws RemoteException;
    String getpasswordByName(String username) throws RemoteException;
    String getJobByName(String username) throws RemoteException;
    void FaceService(String username)throws RemoteException;
    String getNameByFaceTag() throws RemoteException;
}
