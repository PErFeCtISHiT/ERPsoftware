package mock;

import client.BL.Accountant.FinancialCheckSellbl.FinancialCheckSellController;
import server.Po.moneyPO;
import shared.ResultMessage;

/**
 * Created by Leonarda on 2017/11/7.
 */
public class MockSituationEnvironment extends FinancialCheckSellController {
    private moneyPO bill;

    public moneyPO check() {
        return bill;
    }

    public ResultMessage getexcel() {
        return ResultMessage.Success;
    }
}
