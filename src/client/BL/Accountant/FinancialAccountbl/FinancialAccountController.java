package client.BL.Accountant.FinancialAccountbl;

import client.BLservice.Accountant.FinancialAccountblservice.FinancialAccountInterface;
import client.RMI.link;
import client.Vo.coVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class FinancialAccountController implements FinancialAccountInterface {

    /**
     * Add account
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage addAccount(coVO vo) throws RemoteException {
        return link.getRemoteHelper().getCoaccount().addObject(vo,10);
    }

    /**
     * Delete account
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteAccount(coVO vo)throws RemoteException{
        return link.getRemoteHelper().getCoaccount().deleteObject(vo,10);
    }

    /**
     * Modify account
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage modifyAccount(coVO vo)throws RemoteException{

        return link.getRemoteHelper().getCoaccount().modifyObject(vo,10);
    }

    /**
     * Find accounts
     *
     * @param key
     * @return
     */
    @Override
    public ArrayList<coVO> findAccount(String key){

        return null;
    }

    /**
     * show accounts
     *
     * @return
     */
    @Override
    public List<coVO> show() throws RemoteException{

        return link.getRemoteHelper().getCoaccount().findAll(10);
    }

    @Override
    public Account VoToAccount(coVO co) throws RemoteException{

        String id=co.getKeyno();
        String name= co.getKeyname();
        Double money = co.getSumall();
        Account account = new Account(id,name,money.toString());
        return account;
    }
    @Override
    public coVO AccountToVo(Account account) throws RemoteException{

        String id=account.getaccountID();
        String name= account.getaccountName();
        Double money = Double.parseDouble(account.getmoney());
        coVO co = new coVO();
        co.setKeyname(name);
        co.setSumall(money);
        co.setKeyno(id);
        return co;
    }
}

