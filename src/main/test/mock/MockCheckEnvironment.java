package mock;

import client.BL.Accountant.FinancialCheckSellbl.FinancialCheckSellController;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/11/7.
 */
public class MockCheckEnvironment extends FinancialCheckSellController{
    ArrayList<moneyPO> billPOArrayList;
    public ArrayList<moneyPO> check(String time){
        return billPOArrayList;
    }

    public ResultMessage getexcel(){
        return ResultMessage.Success;
    }
}
