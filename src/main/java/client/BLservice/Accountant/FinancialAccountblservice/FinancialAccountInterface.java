package client.BLservice.Accountant.FinancialAccountblservice;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.Vo.coVO;
import server.Po.coPO;
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
    ResultMessage addAccount(coVO vo) throws RemoteException;
    /**
     * Delete account
     *
     * @param vo
     * @return
     */
    ResultMessage deleteAccount(coVO vo) throws RemoteException;
    /**
     * Modify account
     *
     * @param vo
     * @return
     */
    ResultMessage modifyAccount(coVO vo)throws RemoteException;

    /**
     * Find accounts
     *
     * @param key
     * @return
     */
    ArrayList<coVO> findAccount(String key) throws RemoteException;

    /**
     * show accounts
     *
     * @param
     * @return
     */
    List<coPO> show() throws RemoteException;

    Account VoToAccount(coVO co) throws RemoteException;

    coVO AccountToVo(Account account) throws RemoteException;

    coVO PoToVo(coPO po) throws RemoteException;

    coPO VoToPo(coVO vo) throws RemoteException;


    }
