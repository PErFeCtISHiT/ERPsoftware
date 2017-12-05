package client.BL.Accountant.FinancialPaybl;

import client.BL.Accountant.FinancialAccountbl.Account;
import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.BL.Accountant.FinancialReceivebl.AccountBill;
import client.BL.Accountant.FinancialReceivebl.Consumer;
import client.BL.Accountant.FinancialReceivebl.FinancialBill;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.BLservice.Accountant.FinancialPayblservice.FinancialPayInterface;
import client.RMI.link;
import client.Vo.coVO;
import client.Vo.moneyVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.*;

public class FinancialPayController implements FinancialPayInterface {


    FinancialAccountController Accountcontroller  = new FinancialAccountController();



    @Override
    public ResultMessage summit(FinancialBill financialBill) throws RemoteException{
        moneyPO moneypo = FinancialBillToMoneyPO(financialBill);
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
        for (int i=0; i< moneyLists.size();i++){
            link.getRemoteHelper().getmoneyList().addObject(moneyLists.get(i),18);
        }
    }

    @Override
    public void ReEditBill(String Keyno) throws RemoteException{

    }


    @Override
    public ArrayList<AccountBill> getAllDraftPay() throws RemoteException{
        List<moneyPO>  moneyPOList = link.getRemoteHelper().getMoneyBill().findAll(5);
        ArrayList<moneyPO> DraftPayPO = PickDraftPay(moneyPOList);
        ArrayList<AccountBill> accountBills = new ArrayList<AccountBill>();
        for (int i=0; i<DraftPayPO.size();i++){
            accountBills.add(PoToAccountBill(DraftPayPO.get(i)));
        }

        return accountBills;
    }

    @Override
    public AccountBill PoToAccountBill(moneyPO po) throws RemoteException{
        AccountBill bill = new AccountBill();

        if (po.getKind()==0.0){
            bill.setKind("收款单");
        }
        else if (po.getKind() ==1.0){
            bill.setKind("付款单");
        }
        else {
            bill.setKind("现金费用单");
        }
        bill.setConsumer(po.getConsumer());
        bill.setAccoun(po.getAccoun());
        bill.setMoneyList(po.getMoneyList());
        bill.setKeyno(po.getKeyno());
        bill.setConsumertype(po.getConsumertype());
        bill.setOper(po.getOper());


        bill.setIscheck(String.valueOf(po.getIscheck()));
        bill.setIsDraft(String.valueOf(po.getIsDraft()));
        bill.setIsred(String.valueOf(po.getIsred()));
        bill.setSumall(String.valueOf(po.getSumall()));

        return bill;
    }


    @Override
    public ArrayList<moneyPO> PickDraftPay(List<moneyPO> pos) throws RemoteException{
        ArrayList<moneyPO> draftPay = new ArrayList<moneyPO>();

        for(int i=0;i<pos.size();i++){
            if (pos.get(i).getKind().equals(1.0)&&pos.get(i).getIsDraft().equals(1.0)){
                draftPay.add(pos.get(i));
            }
        }
        return draftPay;
    }






    @Override
    public moneyPO FinancialBillToMoneyPO(FinancialBill financialBill) throws RemoteException {
        moneyPO moneypo = new moneyPO();

        String consumerID = financialBill.getConsumerID();
        double sum = financialBill.getSum();
        String moneylistNO = financialBill.getMoneyList().get(0).getlistNO();
        String billtype = financialBill.getBillType();
        String billID = financialBill.getID();
        String operater = financialBill.getOperater();
        String consumerType = financialBill.getConsumerType();

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
    public Consumer PoToConsumer(consumerPO po) {
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