package client.BL.Accountant.FinancialReceivebl;

import client.Vo.moneyVO;
import client.Vo.moneylistVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FinancialBill {

    private String ID;

    private String type;

    private String operater;

    private String consumerType;

    private String consumerID;

    private ArrayList<moneylistVO> moneyList;

    private double sum;

    private moneyVO vo;

    public FinancialBill(){
//        try{
//
//        }catch(RemoteException e){
//            e.printStackTrace();
//        }
    }

    public String getID() throws RemoteException{
        //data.getID
        //return link.getRemoteHelper().getMoneyBill().getID();
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
