package mock;

import client.BL.Accountant.FinancialCheckSellbl.FinancialCheckSellController;
import server.Po.moneyPO;

/**
 * Created by Leonarda on 2017/11/7.
 */
public class ExamineEnvironment extends FinancialCheckSellController {
    public Boolean examine(moneyPO bill) {
        return true;
    }
}
