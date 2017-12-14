package client.BL.Accountant.FinancialReceivebl.Mock;

import client.BL.Accountant.FinancialReceivebl.FinancialReceiveController;
import client.Vo.moneyVO;
import shared.ResultMessage;

public class FinancialReceiveControllerMock extends FinancialReceiveController {

    public ResultMessage getReceiveID(){
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
