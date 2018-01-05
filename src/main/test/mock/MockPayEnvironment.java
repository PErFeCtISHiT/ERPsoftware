package mock;

import client.BL.Accountant.FinancialPaybl.FinancialPayController;
import client.Vo.moneyListVO;
import shared.ResultMessage;

/**
 * Created by Leonarda on 2017/11/7.
 */
public class MockPayEnvironment extends FinancialPayController {
    public ResultMessage getPayID() {
        return ResultMessage.Success;
    }

    public moneyListVO find(String iD) {
        return new moneyListVO();
    }

    public ResultMessage addBill(moneyListVO vo) {
        return ResultMessage.Success;
    }

    public moneyListVO summit() {
        return new moneyListVO();
    }
}
