package client.BL.Accountant.FinancialPaybl.Mock;

import client.BL.Accountant.FinancialPaybl.FinancialPayController;
import client.Vo.moneyVO;
import shared.ResultMessage;

public class FinancialPayControllerMock extends FinancialPayController {


    public ResultMessage getPayID(){
        return null;
    }

    public moneyVO find(String iD){
        return null;
    }

    public ResultMessage addBill(moneyVO vo){
        return null;
    }

    public moneyVO summit(){
        return null;
    }
}
