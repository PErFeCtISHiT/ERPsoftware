package client.BL.Accountant.FinancialAccountbl.Mock;

import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.Vo.coVO;
import server.Po.coPO;
import shared.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class FinancialAccountControllerMock extends FinancialAccountController {

    /**
     * Add account
     *
     * @param vo
     * @return
     */
    public ResultMessage addAccount(coVO po){
        return null;
    }

    /**
     * Delete account
     *
     * @param vo
     * @return
     */
    public boolean deleteAccount(coVO vo){
        return false;
    }


    /**
     * Modify account
     *
     * @param vo
     * @return
     */
    public coVO modifyAccount(coVO vo){
        return null;
    }

    /**
     * Find accounts
     *
     * @param key
     * @return
     */
    public ArrayList<coVO> findAccount(String key){
        return null;
    }
}
