package client.BLservice.Accountant.FinancialPayblservice;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.Vo.moneyVO;
import server.Po.consumerPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinancialPayInterface {


    ResultMessage getPayID();

    moneyVO find(String iD);

    ResultMessage addBill(moneyVO vo);

    moneyVO summit();

    ArrayList<Account> getAllAccount() throws RemoteException;

    ArrayList<Consumer> getAllConsumer() throws RemoteException;

    Consumer PoToConsumer(consumerPO po) throws RemoteException;
}
