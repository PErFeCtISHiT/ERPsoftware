package client.BL.Accountant.FinancialReceivebl;

import client.BLservice.Accountant.FinancialReceiveblservice.FinancialReceiveInterface;
import client.Vo.moneyVO;
import shared.ResultMessage;

public class FinancialReceiveController implements FinancialReceiveInterface {

    @Override
    public ResultMessage getReceiveID(){
        return null;
    }

    @Override
    public moneyVO find(String iD){
        return null;
    }

    @Override
    public ResultMessage addBill(moneyVO vo){
        return null;
    }

    @Override
    public moneyVO summit(){
        return null;
    }
}