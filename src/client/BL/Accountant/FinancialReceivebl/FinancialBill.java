package client.BL.Accountant.FinancialReceivebl;

import client.Vo.moneyVO;
import client.Vo.moneylistVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FinancialBill {

    private String ID;

    private String Billtype;

    private String operater;

    private String consumerType;

    private String consumerID;

    private ArrayList<MoneyList> moneyList;

    private double sum;

    private moneyVO vo;

    public FinancialBill(){

        try {
            this.ID = this.getID();
            this.Billtype = this.getBillType();
            this.operater= this.getOperater();
            this.consumerType= this.getConsumerType();
            this.moneyList = this.getMoneyList();
            for (int i=0;i<moneyList.size();i++){
                moneyList.get(i).setlistNO(ID);
            }
            this.sum = this.getSum();

        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    public String getID() throws RemoteException{
        //data.getID
        //return link.getRemoteHelper().getMoneyBill().getID();
        return null;
    }

//    public String setID(String ID) throws RemoteException{
//
//    }

    public  String getBillType() throws RemoteException{
        return null;
    }

    public String getOperater() throws RemoteException{
        return null;
    }


    public String getConsumerType() throws RemoteException{
        return null;
    }

    public String getConsumerID() throws  RemoteException{
        return null;
    }

    public ArrayList<MoneyList> getMoneyList() throws RemoteException{
        return null;
    }

    public Double getSum() throws RemoteException{
        return null;
    }

    public moneyVO summit() throws RemoteException{
        //data.insert
        return null;
    }

    public moneyVO saveAsDraft() throws RemoteException{

        return null;
    }



}
