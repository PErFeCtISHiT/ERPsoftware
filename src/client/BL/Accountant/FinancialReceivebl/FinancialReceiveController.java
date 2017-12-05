package client.BL.Accountant.FinancialReceivebl;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.BLservice.Accountant.FinancialReceiveblservice.FinancialReceiveInterface;
import client.RMI.link;
import client.Vo.coVO;
import client.Vo.moneyVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.*;

public class FinancialReceiveController implements FinancialReceiveInterface {


    FinancialAccountController Accountcontroller  = new FinancialAccountController();



    @Override
    public ResultMessage getReceiveID(){
        return null;
    }

    @Override
    public moneyVO find(String iD){
        return null;
    }


    @Override
    public ResultMessage summit(FinancialBill financialBill) throws RemoteException{
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);

        System.out.println("summit");
        System.out.println(moneypo.getKind());
        System.out.println(moneypo.getConsumer());
        System.out.println(moneypo.getIsred());
        System.out.println(moneypo.getSumall());
        System.out.println(moneypo.getMoneyList());



        link.getRemoteHelper().getMoneyBill().addObject(moneypo,5);
        return null;
    }

    @Override
    public ResultMessage saveAsDraft (FinancialBill financialBill) throws RemoteException{
        ArrayList<MoneyList> moneyLists = financialBill.getMoneyList();
        saveMoneyList(moneyLists);
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);
        moneypo.setIsDraft(1.0);
        System.out.println("draft");

        link.getRemoteHelper().getMoneyBill().addObject(moneypo,5);
        return null;
    }
    @Override
    public void saveMoneyList(ArrayList<MoneyList> moneyLists) throws RemoteException{
//        link.getRemoteHelper()



    }





    @Override
    public moneyPO FinancialBillToMoneyPO(FinancialBill financialBill) throws RemoteException {
        moneyPO moneypo = new moneyPO();
        String billtype = financialBill.getBillType();
        String billID = financialBill.getID();
        String operater = financialBill.getOperater();
        String consumerType = financialBill.getConsumerType();
        String consumerID = financialBill.getConsumerID();
        double sum = financialBill.getSum();
        String moneylistNO = financialBill.getMoneyList().get(0).getlistNO();


        moneypo.setKind(1.0);
        moneypo.setKeyno(billID);
        moneypo.setAccoun("");
        moneypo.setConsumer(consumerID);
        moneypo.setConsumertype(consumerType);
        moneypo.setIscheck(0.0);
        moneypo.setIsred(0.0);
        moneypo.setIsDraft(0.0);
        moneypo.setOper(operater);
        moneypo.setMoneyList(moneylistNO);
        moneypo.setSumall(sum);

        return moneypo;
    }


    @Override
    public ArrayList<Account> getAllAccount() throws RemoteException {

        List<coPO> list = link.getRemoteHelper().getCoaccount().findAll(10);
        ArrayList<Account> colist = new ArrayList<Account>();
        for (int i=0;i<list.size();i++){
            coVO newco = Accountcontroller.PoToVo(list.get(i));
            Account account = Accountcontroller.VoToAccount(newco);
            colist.add(account);
        }

        return colist;
    }

    @Override
    public ArrayList<Consumer> getAllConsumer() throws RemoteException {

        List<consumerPO> list = link.getRemoteHelper().getConsumer().findAll(2);
        ArrayList<Consumer> consumer =new ArrayList<Consumer>();
        for (int i=0;i<list.size();i++){
            Consumer newcon = PoToConsumer(list.get(i));
            consumer.add(newcon);
        }

        return consumer;
    }

    @Override
    public Consumer PoToConsumer(consumerPO po) throws RemoteException{
        Consumer con = new Consumer();
        con.setconsumerID(po.getKeyno());
        con.setconsumerName(po.getKeyname());
        con.setconsumerLevel(String.valueOf(po.getLev()));
        con.setstaff(po.getServer());
        con.setinOutGap(String.valueOf(po.getPay()-po.getReceive()));
        con.setactualIN(String.valueOf(po.getPay()));
        con.setdueIN(String.valueOf(po.getReceive()));
        con.setduePay(String.valueOf(po.getCapacit()));
        return con;
    }



}