package client.Presentation.AccountantUI.Test;

import client.BL.Accountant.FinancialReceivebl.FinancialReceiveController;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.RMI.link;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Test
{



    public static void main(String[] args) {
        link.linktoServer();
       Add();
    }

    public static void Add(){
        FinancialReceiveController receiveController = new FinancialReceiveController();
        MoneyList l1=new MoneyList("1","1","123", "12.5", "C");
        MoneyList l2=new MoneyList("2","2","1234", "99.5", "C");
        ArrayList<MoneyList> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);

        try {
            receiveController.saveMoneyList(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

}
