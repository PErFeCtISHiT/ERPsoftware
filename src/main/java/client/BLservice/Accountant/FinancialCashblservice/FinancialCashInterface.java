package client.BLservice.Accountant.FinancialCashblservice;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialCashbl.FinancialCash;
import client.BL.Accountant.FinancialReceivebl.AccountBill;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.BL.Accountant.FinancialReceivebl.FinancialBill;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.Vo.moneyVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.moneyListPO;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 *
 * @author: yotta
 * @description: controller for Cash（现金费用）
 * @date: modify in 18:20 2017/12/24
 */
public interface FinancialCashInterface {
    /**
     * 提交单据
     *
     * @param financialCash
     * @return
     * @throws RemoteException
     */
    public ResultMessage summit(FinancialCash financialCash) throws RemoteException;
    /**
     * 再次提交
     *
     * @param financialCash
     * @return
     * @throws RemoteException
     */
    public ResultMessage resummit(FinancialCash financialCash) throws RemoteException;
    /**
     * 保存草稿
     *
     * @param financialCash
     * @return
     * @throws RemoteException
     */
    public ResultMessage saveAsDraft (FinancialCash financialCash) throws RemoteException;
    /**
     * 编辑草稿
     *
     * @param Keyno
     * @return
     * @throws RemoteException
     */
    public FinancialCash ReEditBill(String Keyno) throws RemoteException;
    /**
     * PO转换
     *
     * @param po
     * @return
     * @throws RemoteException
     */
    public FinancialCash PoToFinancialCash( moneyPO po) throws RemoteException;
    /**
     * PO转换
     *
     * @param list
     * @return
     * @throws RemoteException
     */
    public ArrayList<MoneyList> PoToMoneyLists (List<moneyListPO> list) throws RemoteException;
    /**
     * 所有已经审批的单据
     *
     * @return
     * @throws RemoteException
     */
    public ArrayList<AccountBill> getAllPromotedCash() throws RemoteException;
    /**
     * 正在审批的单据
     * @return
     * @throws RemoteException
     */

    public ArrayList<AccountBill> getAllUnderPromotedCash() throws RemoteException;
    /**
     * 保存条目列表
     *
     * @param moneyLists
     * @throws RemoteException
     */
    public void saveMoneyList(ArrayList<MoneyList> moneyLists) throws RemoteException;
    /**
     * 草稿单据
     *
     * @return
     * @throws RemoteException
     */

    public ArrayList<AccountBill> getAllDraftCash() throws RemoteException;
    /**
     * PO转换
     * @param po
     * @return
     * @throws RemoteException
     */
    public AccountBill PoToAccountBill(moneyPO po) throws RemoteException;
    /**
     * 筛选草稿
     *
     * @param pos
     * @return
     * @throws RemoteException
     */

    public ArrayList<moneyPO> PickDraftCash(List<moneyPO> pos) throws RemoteException;
    /**
     * 类型转换
     *
     * @param financialCash
     * @return
     * @throws RemoteException
     */
    public moneyPO FinancialCashToMoneyPO(FinancialCash financialCash) throws RemoteException;
    /**
     * 账户列表
     *
     * @return
     * @throws RemoteException
     */
    public ArrayList<Account> getAllAccount() throws RemoteException;
    /**
     * 客户列表
     *
     * @return
     * @throws RemoteException
     */
    public ArrayList<Consumer> getAllConsumer() throws RemoteException;
    /**
     * 类型转化
     *
     * @param po
     * @return
     */
    public Consumer PoToConsumer(consumerPO po) throws RemoteException;

}
