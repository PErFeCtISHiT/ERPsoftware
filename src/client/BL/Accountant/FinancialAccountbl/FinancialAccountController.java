package client.BL.Accountant.FinancialAccountbl;

import client.BLservice.Accountant.FinancialAccountblservice.FinancialAccountInterface;
import client.RMI.link;
import client.Vo.coVO;
import server.Dataservice.Codataservice.Coaccount;
import server.Po.coPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class FinancialAccountController implements FinancialAccountInterface {


    private Account account;


    public FinancialAccountController() {
        account = new Account();
    }

    /**
     * Add account
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage addAccount(coVO vo) throws RemoteException {
        System.out.println("Add");
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
    public ResultMessage modifyAccount(coVO vo) throws RemoteException{

        return link.getRemoteHelper().getCoaccount().modifyObject(vo,10);
    }

    /**
     * Find accounts
     *
     * @param key
     * @return
     */
    @Override
    public ArrayList<coVO> findAccount(String key) throws RemoteException{

        return null;
    }

    /**
     * show accounts
     *
     * @return
     */
    @Override
    public List<coPO> show() throws RemoteException{

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

    @Override
    public coVO PoToVo(coPO po) throws RemoteException{

        String id=po.getKeyno();
        String name= po.getKeyname();
        Double money = po.getSumall();
        coVO co = new coVO();
        co.setKeyname(name);
        co.setSumall(money);
        co.setKeyno(id);
        return co;
    }



}

