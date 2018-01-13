package client.BLservice.Manager.ManagerCheckSituationblService;

import java.rmi.RemoteException;

public interface ManagerCheckSituationService {
    String getSalesIncome() throws RemoteException;   //销售收入
    String getStockOverflow() throws RemoteException;    //报溢收入
    String getCost() throws RemoteException;   //成本调价
    String getStockDifferBetweenTwice() throws RemoteException;
    String getCommodity() throws RemoteException;    //商品类收入
    String getCut() throws RemoteException;     //折让
    String getExpenditure() throws RemoteException;    //销售支出
    String getReportedLoss() throws RemoteException;   //商品报损支出
    String getGoodsGiven() throws RemoteException;   //商品增送支出
    String getAllCommodity() throws RemoteException;    //商品类支出
    String getAfterCut() throws RemoteException;   //折让后总支出
    String getProfit() throws RemoteException;   //利润
}
