package mock;

import client.BL.Accountant.FinancialReceivebl.FinancialReceiveController;
import client.Vo.buyinVO;
import shared.ResultMessage;

/**
 * Created by Leonarda on 2017/11/7.
 */
public class MockReveiveEnvironment extends FinancialReceiveController {
    private String ID;

    public String getReceiveID() {
        return ID;
    }

    public buyinVO find(String ID) {
        return new buyinVO();
    }

    public ResultMessage addBill() {
        return ResultMessage.Success;
    }

    public buyinVO summit() {
        return new buyinVO();
    }
}
