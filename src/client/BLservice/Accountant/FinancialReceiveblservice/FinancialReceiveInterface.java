package client.BLservice.Accountant.FinancialReceiveblservice;

import client.Vo.moneyVO;
import shared.ResultMessage;

public interface FinancialReceiveInterface {

    public ResultMessage getReceiveID();

    public moneyVO find(String iD);

    public ResultMessage addBill(moneyVO vo);

    public moneyVO summit();
}
