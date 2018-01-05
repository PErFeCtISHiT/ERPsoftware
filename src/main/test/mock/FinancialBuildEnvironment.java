package mock;

import client.BL.Accountant.FinancialBuildAccountbl.FinancialBuildController;
import client.Vo.AccountInitVO;
import server.Po.coPO;
import server.Po.consumerPO;
import server.Po.goodsPO;
import shared.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/11/7.
 */
public class FinancialBuildEnvironment extends FinancialBuildController {
    public ResultMessage accountbuild(ArrayList<goodsPO> goods, ArrayList<consumerPO> consumer, ArrayList<coPO> Account) {
        return ResultMessage.Success;
    }

    public AccountInitVO getPast(ArrayList<goodsPO> goods, ArrayList<consumerPO> consumer, ArrayList<coPO> Account) {
        return new AccountInitVO();
    }
}
