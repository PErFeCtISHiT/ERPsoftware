package mock; /**
 * Created by Leonarda on 2017/11/6.
 */

import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import server.Po.coPO;
import shared.ResultMessage;

import java.util.ArrayList;

public class MockAccoutEnvironment extends FinancialAccountController {
    coPO co;

    public ResultMessage addaccount(coPO co) {
        this.co = co;
        return ResultMessage.Success;
    }

    public ResultMessage deleteaccount(coPO co) {
        return ResultMessage.Success;
    }

    public ResultMessage modify(coPO co) {
        return ResultMessage.Success;
    }

    public ArrayList<coPO> Search(String keyword) {
        ArrayList<coPO> a = new ArrayList<coPO>();
        return a;
    }

}
