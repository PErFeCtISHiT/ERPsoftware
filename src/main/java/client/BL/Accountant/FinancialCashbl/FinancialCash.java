package client.BL.Accountant.FinancialCashbl;

import client.BL.Accountant.FinancialReceivebl.MoneyList;

import java.util.ArrayList;

public class FinancialCash {

    private String ID;

    private String Billtype;

    private String operater;

    private String Account;

    private ArrayList<MoneyList> moneyList;

    private double sum;

    public FinancialCash(String ID, String Billtype, String operater,
                         String Account, ArrayList<MoneyList> moneyList, double sum){


        this.ID = ID;
        this.Billtype = Billtype;
        this.operater= operater;
        this.Account= Account;
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


    public String getAccount() {
        return this.Account;
    }

    public void setAccount(String consumerType) {
        this.Account = consumerType;
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
