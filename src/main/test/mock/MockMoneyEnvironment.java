package mock; /**
 * Created by Leonarda on 2017/11/7.
 */

import client.BL.Accountant.FinancialCashbl.Mock.FinancialMoneyControllerMock;
import client.Vo.moneyListVO;
import shared.ResultMessage;

import java.util.HashMap;

public class MockMoneyEnvironment extends FinancialMoneyControllerMock {
    public moneyListVO find(String iD) {
        return new moneyListVO();
    }

    public HashMap<String, String> getAllconsumer() {
        return null;
    }

    public ResultMessage addBill(moneyListVO vo) {
        return ResultMessage.Success;
    }

    public moneyListVO summit() {
        return new moneyListVO();
    }
}
