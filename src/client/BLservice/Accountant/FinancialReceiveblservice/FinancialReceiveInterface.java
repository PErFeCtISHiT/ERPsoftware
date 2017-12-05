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

    ResultMessage getReceiveID();

    moneyVO find(String iD);

    ResultMessage summit(FinancialBill financialBill) throws RemoteException;

    ResultMessage saveAsDraft(FinancialBill financialBill) throws RemoteException;

    moneyPO FinancialBillToMoneyPO(FinancialBill financialBill) throws RemoteException;

    ArrayList<Account> getAllAccount() throws RemoteException;

    ArrayList<Consumer> getAllConsumer() throws RemoteException;

    Consumer PoToConsumer(consumerPO po) throws RemoteException;

}
