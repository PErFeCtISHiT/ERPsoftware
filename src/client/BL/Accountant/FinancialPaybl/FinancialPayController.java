package client.BL.Accountant.FinancialPaybl;

import client.BLservice.Accountant.FinancialPayblservice.FinancialPayInterface;
import client.Vo.moneyVO;
import shared.ResultMessage;

public class FinancialPayController implements FinancialPayInterface{

    @Override
    public ResultMessage getPayID(){
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
