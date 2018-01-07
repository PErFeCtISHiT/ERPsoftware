package client.BLservice.Accountant.FinancialPayblservice;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialReceivebl.AccountBill;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.BL.Accountant.FinancialReceivebl.FinancialBill;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import server.Po.consumerPO;
import server.Po.moneyListPO;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface FinancialPayInterface {

    public ResultMessage summit(FinancialBill financialBill) throws RemoteException;

    public ResultMessage resummit(FinancialBill financialBill) throws RemoteException;

    public ResultMessage saveAsDraft(FinancialBill financialBill) throws RemoteException;

    public FinancialBill ReEditBill(String Keyno) throws RemoteException;

    public FinancialBill PoToFinancialBill(moneyPO po) throws RemoteException;

    public ArrayList<MoneyList> PoToMoneyLists(List<moneyListPO> list) throws RemoteException;

    public ArrayList<AccountBill> getAllPromotedPay() throws RemoteException;

    public ArrayList<AccountBill> getAllUnderPromotedPay() throws RemoteException;

    public void saveMoneyList(ArrayList<MoneyList> moneyLists) throws RemoteException;

    public ArrayList<AccountBill> getAllDraftPay() throws RemoteException;

    public AccountBill PoToAccountBill(moneyPO po) throws RemoteException;

    public ArrayList<moneyPO> PickDraftPay(List<moneyPO> pos) throws RemoteException;

    public moneyPO FinancialBillToMoneyPO(FinancialBill financialBill) throws RemoteException;

    public ArrayList<Account> getAllAccount() throws RemoteException;

    public ArrayList<Consumer> getAllConsumer() throws RemoteException;

    public Consumer PoToConsumer(consumerPO po) throws RemoteException;

}
