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
import server.Po.moneyPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface FinancialCashInterface {

    public ResultMessage summit(FinancialCash financialCash) throws RemoteException;

    public ResultMessage saveAsDraft (FinancialCash financialCash) throws RemoteException;

    public void ReEditBill(String Keyno) throws RemoteException;

    public ArrayList<AccountBill> getAllPromotedCash() throws RemoteException;

    public ArrayList<AccountBill> getAllUnderPromotedCash() throws RemoteException;

    public void saveMoneyList(ArrayList<MoneyList> moneyLists) throws RemoteException;

    public ArrayList<AccountBill> getAllDraftCash() throws RemoteException;

    public AccountBill PoToAccountBill(moneyPO po) throws RemoteException;

    public ArrayList<moneyPO> PickDraftCash(List<moneyPO> pos) throws RemoteException;

    public moneyPO FinancialCashToMoneyPO(FinancialCash financialCash) throws RemoteException;

    public ArrayList<Account> getAllAccount() throws RemoteException;

    public ArrayList<Consumer> getAllConsumer() throws RemoteException;

    public Consumer PoToConsumer(consumerPO po) throws RemoteException;

}
