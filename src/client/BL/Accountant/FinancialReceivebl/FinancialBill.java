package client.BL.Accountant.FinancialReceivebl;

import client.RMI.link;
import client.Vo.moneyVO;
import client.Vo.moneylistVO;
import shared.ResultMessage;

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

    public FinancialBill(String ID, String Billtype, String operater, String consumerType,
                         String consumerID, ArrayList<MoneyList> moneyList, double sum){


        this.ID = ID;
        this.Billtype = Billtype;
        this.operater= operater;
        this.consumerType= consumerType;
        this.consumerID = consumerID;
        this.moneyList = moneyList;
        for (int i=0;i<moneyList.size();i++){
            moneyList.get(i).setlistNO(ID);
        }
        this.sum = sum;

    }

    public String getID() throws RemoteException{
        return null;
    }

    public void setID(String ID) throws RemoteException{
        this.ID = ID;
    }

    public  String getBillType() throws RemoteException{
        return null;
    }

    public void setBilltype(String billtype) throws RemoteException{
        this.Billtype =billtype;
    }

    public String getOperater() throws RemoteException{
        return null;
    }

    public void setOperater(String operater) throws RemoteException{
        this.operater = operater;
    }


    public String getConsumerType() throws RemoteException{
        return null;
    }

    public void setConsumerType(String consumerType) throws RemoteException{
        this.consumerType = consumerType;
    }

    public String getConsumerID() throws  RemoteException{
        return null;
    }

    public void setConsumerID(String consumerID) throws RemoteException{
        this.consumerID = consumerID;
    }


    public ArrayList<MoneyList> getMoneyList() throws RemoteException{
        return null;
    }

    public void setMoneyList(ArrayList<MoneyList> moneyList) throws RemoteException{
        this.moneyList = moneyList;
    }

    public Double getSum() throws RemoteException{
        return null;
    }

    public void setSum(double sum) throws RemoteException{

        this.sum = sum;
    }

}
