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

/**
 * @author: yotta
 * @description: controller for account management
 * @date: modify in 18:18 2017/12/24
 */
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
    public ResultMessage deleteAccount(coVO vo) throws RemoteException{
        //coPO po = VoToPo(vo);
        System.out.println("Test");
        System.out.println(vo.getKeyno());
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
    public ArrayList<Account> findAccount(String key) throws RemoteException{

        List<coPO> list = link.getRemoteHelper().getCoaccount().findAccount(key);
        ArrayList<Account> accList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            Account newaccount = VoToAccount(PoToVo(list.get(i)));
            accList.add(newaccount);
        }
        return accList;
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

    /**
     * transform VO to Account
     *
     * @param co
     * @return Account
     */

    @Override
    public Account VoToAccount(coVO co) {

        String id=co.getKeyno();
        String name= co.getKeyname();
        Double money = co.getSumall();
        Account account = new Account(id,name,money.toString());
        return account;
    }

    /**
     * transform Account to VO
     *
     * @param account
     * @return coVO
     */

    @Override
    public coVO AccountToVo(Account account) {

        String id=account.getaccountID();
        String name= account.getaccountName();
        Double money = Double.parseDouble(account.getmoney());
        coVO co = new coVO();
        co.setKeyname(name);
        co.setSumall(money);
        co.setKeyno(id);
        return co;
    }

    /**
     * transform PO to VO
     *
     * @param po
     * @return
     */

    @Override
    public coVO PoToVo(coPO po) {

        String id=po.getKeyno();
        String name= po.getKeyname();
        Double money = po.getSumall();
        coVO co = new coVO();
        co.setKeyname(name);
        co.setSumall(money);
        co.setKeyno(id);
        return co;
    }

    /**
     * transform VO to PO
     *
     * @param vo
     * @return
     */


    @Override
    public coPO VoToPo(coVO vo) {

        String id=vo.getKeyno();
        String name= vo.getKeyname();
        Double money = vo.getSumall();
        coPO po = new coPO();
        po.setKeyname(name);
        po.setSumall(money);
        po.setKeyno(id);
        return po;
    }


}

