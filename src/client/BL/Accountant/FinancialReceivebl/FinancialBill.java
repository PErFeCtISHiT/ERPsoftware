package client.BL.Accountant.FinancialReceivebl;

import client.RMI.link;
import client.Vo.moneyVO;

import java.rmi.RemoteException;

public class FinancialBill {

    private String ID;

    private String type;

    private TransferList list = new TransferList();

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


}
