package client.BL.Accountant.FinancialAccountbl;

import client.BLservice.Accountant.FinancialAccountblservice.FinancialAccountInterface;
import client.Vo.coVO;
import shared.ResultMessage;
import java.util.ArrayList;

public class FinancialAccountController implements FinancialAccountInterface {

    /**
     * Add account
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage addAccount(coVO po){
        return null;
    }

    /**
     * Delete account
     *
     * @param vo
     * @return
     */
    @Override
    public boolean deleteAccount(coVO po){
        return false;
    }


    /**
     * Modify account
     *
     * @param vo
     * @return
     */
    @Override
    public coVO modifyAccount(coVO po){
        return null;
    }

    /**
     * Find accounts
     *
     * @param key
     * @return
     */
    @Override
    public ArrayList<coVO> findAccount(String key){
        return null;
    }
}

