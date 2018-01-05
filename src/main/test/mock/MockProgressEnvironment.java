package mock;

import client.BL.Accountant.FinancialCashbl.Mock.FinancialMoneyControllerMock;
import server.Po.moneyPO;
import shared.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/11/7.
 */
public class MockProgressEnvironment extends FinancialMoneyControllerMock {
    ArrayList<moneyPO> a;

    public ArrayList<moneyPO> check(String time) {
        return a;
    }

    public ResultMessage getexcel() {
        return ResultMessage.Success;
    }
}
