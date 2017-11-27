package client.BLservice.Accountant.FinancialMoneyblservice;

import client.Vo.moneyVO;
import shared.ResultMessage;

public interface FinancialMoneyInterface {

    public ResultMessage getMoneyID();

    public moneyVO find(String iD);

    public ResultMessage addBill(moneyVO vo);

    public moneyVO summit();

    public ResultMessage getSum();
}
