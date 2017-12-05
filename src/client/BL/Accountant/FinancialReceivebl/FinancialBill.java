package client.BL.Accountant.FinancialReceivebl;

import client.RMI.link;
import client.Vo.moneyVO;
import client.Vo.moneyListVO;
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

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public  String getBillType() {
        return this.Billtype;
    }

    public void setBilltype(String billtype) {
        this.Billtype =billtype;
    }

    public String getOperater() {
        return this.operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }


    public String getConsumerType() {
        return this.consumerType;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    public String getConsumerID() {
        return this.consumerID;
    }

    public void setConsumerID(String consumerID) {
        this.consumerID = consumerID;
    }


    public ArrayList<MoneyList> getMoneyList() {
        return this.moneyList;
    }

    public void setMoneyList(ArrayList<MoneyList> moneyList) {
        this.moneyList = moneyList;
    }

    public Double getSum() {
        return this.sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

}
