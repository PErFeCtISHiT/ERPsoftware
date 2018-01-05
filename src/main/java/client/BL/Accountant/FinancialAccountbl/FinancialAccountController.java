package client.BL.Accountant.FinancialAccountbl;

import client.BLservice.Accountant.FinancialAccountblservice.FinancialAccountInterface;
import client.RMI.link;
import client.Vo.coVO;
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


    public FinancialAccountController() {
        Account account = new Account();
    }

    /**
     * Add account
     *
     * @return result
     * @param： vo
     */
    @Override
    public ResultMessage addAccount(coVO vo) throws RemoteException {
        System.out.println("Add");
        return link.getRemoteHelper().getCoaccount().addObject(vo, 10);
    }

    /**
     * Delete account
     *
     * @return result
     * @param： vo
     */
    @Override
    public ResultMessage deleteAccount(coVO vo) throws RemoteException {
        //coPO po = VoToPo(vo);
        System.out.println("Test");
        System.out.println(vo.getKeyno());
        return link.getRemoteHelper().getCoaccount().deleteObject(vo, 10);

    }

    /**
     * Modify account
     *
     * @return result
     * @param： vo
     */
    @Override
    public ResultMessage modifyAccount(coVO vo) throws RemoteException {

        return link.getRemoteHelper().getCoaccount().modifyObject(vo, 10);
    }

    /**
     * Find accounts
     *
     * @return result
     * @param： key
     */
    @Override
    public ArrayList<Account> findAccount(String key) throws RemoteException {

        List<coPO> list = link.getRemoteHelper().getCoaccount().findAccount(key);
        ArrayList<Account> accList = new ArrayList<>();
        for (coPO aList : list) {
            Account newaccount = VoToAccount(PoToVo(aList));
            accList.add(newaccount);
        }
        return accList;
    }

    /**
     * show accounts
     *
     * @return result
     */
    @Override
    public List<coPO> show() throws RemoteException {

        return link.getRemoteHelper().getCoaccount().findAll(10);
    }

    /**
     * transform VO to Account
     *
     * @return Account
     * @param： co
     */

    @Override
    public Account VoToAccount(coVO co) {

        String id = co.getKeyno();
        String name = co.getKeyname();
        Double money = co.getSumall();
        return new Account(id, name, money.toString());
    }

    /**
     * transform Account to VO
     *
     * @return coVO
     * @param： account
     */

    @Override
    public coVO AccountToVo(Account account) {

        String id = account.getaccountID();
        String name = account.getaccountName();
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
     * @return result
     * @param： po
     */

    @Override
    public coVO PoToVo(coPO po) {

        String id = po.getKeyno();
        String name = po.getKeyname();
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
     * @return result
     * @param： vo
     */


    @Override
    public coPO VoToPo(coVO vo) {

        String id = vo.getKeyno();
        String name = vo.getKeyname();
        Double money = vo.getSumall();
        coPO po = new coPO();
        po.setKeyname(name);
        po.setSumall(money);
        po.setKeyno(id);
        return po;
    }


}

