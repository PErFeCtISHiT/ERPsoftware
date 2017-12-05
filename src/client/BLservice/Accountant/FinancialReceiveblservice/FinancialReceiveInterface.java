package client.BLservice.Accountant.FinancialReceiveblservice;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.BL.Accountant.FinancialReceivebl.FinancialBill;
import client.Vo.moneyVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface FinancialReceiveInterface {

    public ResultMessage getReceiveID();

    public moneyVO find(String iD);

    public ResultMessage addBill(moneyVO vo);

    public ResultMessage summit(FinancialBill financialBill) throws RemoteException;

    public ResultMessage saveAsDraft (FinancialBill financialBill) throws RemoteException;

    public moneyPO FinancialBillToMoneyPO(FinancialBill financialBill) throws RemoteException;

    public ArrayList<Account> getAllAccount() throws RemoteException;

    public ArrayList<Consumer> getAllConsumer() throws RemoteException;

    public Consumer PoToConsumer(consumerPO po) throws RemoteException;

}
