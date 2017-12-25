package client.BL.LodinblService;

import client.BLservice.LoginService.LoginblService;
import client.RMI.link;
import server.Po.userPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/8.
 */
public class LoginController implements LoginblService {
    public List getAlluser(String username, String password) throws RemoteException{
        return link.getRemoteHelper().getUser().login(username,password);
    }

    @Override
    public ResultMessage addUser(userPO user,int type) throws RemoteException{
        return link.getRemoteHelper().getUser().addObject(user,type);
    }

}
