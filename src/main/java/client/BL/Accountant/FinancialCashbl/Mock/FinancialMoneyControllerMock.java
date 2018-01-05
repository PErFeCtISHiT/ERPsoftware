package client.BL.Accountant.FinancialCashbl.Mock;

import client.BL.Accountant.FinancialCashbl.FinancialCashController;
import client.Vo.moneyListVO;
import client.Vo.moneyVO;
import shared.ResultMessage;

public class FinancialMoneyControllerMock extends FinancialCashController {

    public ResultMessage getMoneyID(){
        return null;
    }

    public moneyListVO find(String iD){
        return null;
    }

    public ResultMessage addBill(moneyVO vo){
        return null;
    }

    public moneyListVO summit(){
        return null;
    }

    public ResultMessage getSum(){
        return null;
    }
}
