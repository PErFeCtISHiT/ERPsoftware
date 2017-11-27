package client.BLservice.Accountant.FinancialCheckSellblservice;

import client.Vo.saleVO;

import java.util.ArrayList;

public interface FinancialCheckSellInterface {


    public ArrayList<saleVO> check(String time);

    public boolean getExcel(String address);

}
