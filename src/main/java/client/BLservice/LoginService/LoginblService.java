package client.BLservice.LoginService;

import java.rmi.RemoteException;
import java.util.List;
import server.Po.userPO;
import shared.ResultMessage;

/**
 * Created by Leonarda on 2017/12/8.
 */
public interface LoginblService {
    List<userPO> getAlluser(String username,String password) throws RemoteException;
    ResultMessage addUser(userPO user,int type) throws RemoteException;
}
