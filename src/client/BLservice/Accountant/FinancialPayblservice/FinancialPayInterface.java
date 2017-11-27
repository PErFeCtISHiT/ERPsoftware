package client.BLservice.Accountant.FinancialPayblservice;

import client.Vo.moneyVO;
import shared.ResultMessage;

public interface FinancialPayInterface {


    public ResultMessage getPayID();

    public moneyVO find(String iD);

    public ResultMessage addBill(moneyVO vo);

    public moneyVO summit();
}
