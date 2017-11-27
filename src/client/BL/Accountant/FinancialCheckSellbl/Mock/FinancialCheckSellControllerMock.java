package client.BL.Accountant.FinancialCheckSellbl.Mock;

import client.BL.Accountant.FinancialCheckSellbl.FinancialCheckSellController;
import client.Vo.saleVO;

import java.util.ArrayList;

public class FinancialCheckSellControllerMock extends FinancialCheckSellController {


    public ArrayList<saleVO> check(String time){
        return null;
    }

    public boolean getExcel(String address){
        return false;
    }
}
