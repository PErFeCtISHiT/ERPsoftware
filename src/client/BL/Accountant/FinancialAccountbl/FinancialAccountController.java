package client.BL.Accountant.FinancialAccountbl;

import client.BLservice.Accountant.FinancialAccountblservice.FinancialAccountInterface;
import client.RMI.link;
import client.Vo.coVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FinancialAccountController implements FinancialAccountInterface {

    /**
     * Add account
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage addAccount(coVO po) throws RemoteException {
        return link.getRemoteHelper().getCoaccount().addObject(po,10);
    }

    /**
     * Delete account
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteAccount(coVO po)throws RemoteException{
        return link.getRemoteHelper().getCoaccount().deleteObject(po,10);
    }


    /**
     * Modify account
     *
     * @param vo
     * @return
     */
    @Override
    public coVO modifyAccount(coVO po){
        return null;
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
    public ArrayList<coVO> show() {
        return null;
    }
}

