package client.BLservice.Accountant.FinancialAccountblservice;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.Vo.coVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface FinancialAccountInterface {

    /**
     * Add account
     *
     * @param vo
     * @return
     */
    public ResultMessage addAccount(coVO vo) throws RemoteException;
    /**
     * Delete account
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteAccount(coVO vo) throws RemoteException;
    /**
     * Modify account
     *
     * @param vo
     * @return
     */
    public ResultMessage modifyAccount(coVO vo)throws RemoteException;

    /**
     * Find accounts
     *
     * @param key
     * @return
     */
    public ArrayList<coVO> findAccount(String key) throws RemoteException;

    /**
     * show accounts
     *
     * @param
     * @return
     */
    public List<coVO> show() throws RemoteException;

    public Account VoToAccount(coVO co) throws RemoteException;

    public coVO AccountToVo(Account account) throws RemoteException;
}
