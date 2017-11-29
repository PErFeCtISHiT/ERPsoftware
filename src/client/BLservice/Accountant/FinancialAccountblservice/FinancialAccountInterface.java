package client.BLservice.Accountant.FinancialAccountblservice;

import client.Vo.coVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinancialAccountInterface {

    /**
     * Add account
     *
     * @param vo
     * @return
     */
    public ResultMessage addAccount(coVO po) throws RemoteException;
    /**
     * Delete account
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteAccount(coVO po) throws RemoteException;
    /**
     * Modify account
     *
     * @param vo
     * @return
     */
    public coVO modifyAccount(coVO po);

    /**
     * Find accounts
     *
     * @param key
     * @return
     */
    public ArrayList<coVO> findAccount(String key);

    /**
     * show accounts
     *
     * @param
     * @return
     */

    public ArrayList<coVO> show() ;

}
