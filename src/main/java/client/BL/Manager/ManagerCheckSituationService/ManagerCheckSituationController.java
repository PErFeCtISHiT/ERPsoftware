package client.BL.Manager.ManagerCheckSituationService;

import client.BLservice.Manager.ManagerCheckSituationblService.ManagerCheckSituationService;
import client.RMI.link;
import server.Po.*;

import java.rmi.RemoteException;
import java.util.List;

public class ManagerCheckSituationController implements ManagerCheckSituationService{
    public String getSalesIncome() throws RemoteException {
        double result=0;
        List a= link.getRemoteHelper().getSelloutBill().findAll(4);
        int length=a.size();

        for(int i=0;i<length;i++){
            selloutPO sellout=(selloutPO)link.getRemoteHelper().getSelloutBill().findAll(4).get(i);
            result=result+sellout.getFinalsum();
        }

        String re=String.valueOf(result);
        return re;
    }

    public String getStockOverflow() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getStockOverflowBill().findAll(7);
        int length=a.size();

        for(int i=0;i<length;i++){
            stockexceptionPO stock=(stockexceptionPO)link.getRemoteHelper().getStockOverflowBill().findAll(7) .get(i);
            double l=Math.abs(stock.getNuminsys()-stock.getNuminbase());
            String name=stock.getGoodsno();
            result=result+l*1;
        }

        String re=String.valueOf(result);
        return re;
    }

    public String getCost() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getGoods().findAll(0);
        int length=a.size();

        for(int i=0;i<length;i++){
            goodsPO good=(goodsPO)link.getRemoteHelper().getGoods().findAll(0).get(i);
            double plusprice=Math.abs(good.getReceprice()-good.getInprice());
            double num=good.getNum();

            result=result+num*plusprice;
        }

        String re=String.valueOf(result);
        return re;
    }

    public String getStockDifferBetweenTwice() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getBuyinBill().findAll(3);
        int length=a.size();

        double b1=0;
        double b2=0;
        for(int i=0;i<length;i++){
            buyinPO buyin=(buyinPO)link.getRemoteHelper().getBuyinBill().findAll(3).get(i);
            if(buyin.getKind()==0){
                b1=b1+buyin.getSumall();
            }else{
                b2=b2+buyin.getSumall();
            }

            result=result+Math.abs(b1-b2);
        }

        String re=String.valueOf(result);
        return re;
    }

    public String getCommodity() throws RemoteException{
        double result=Double.parseDouble(getStockOverflow())+Double.parseDouble(getCost())+Double.parseDouble(getStockDifferBetweenTwice());
        return String.valueOf(result);
    }

    public String getCut() throws RemoteException{
        double result=Double.parseDouble(getCommodity())+Double.parseDouble(getSalesIncome());
        return String.valueOf(result);
    }

    public String getExpenditure() throws RemoteException {
        double result=0;
        List a=link.getRemoteHelper().getBuyinBill().findAll(3);
        int length=a.size();

        for(int i=0;i<length;i++){
            buyinPO buyin=(buyinPO) link.getRemoteHelper().getBuyinBill().findAll(3).get(i);
            result=result+buyin.getSumall();
        }

        String re=String.valueOf(result);
        return re;
    }

    public String getReportedLoss() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getStockOverflowBill().findAll(7);
        int length=a.size();

        for(int i=0;i<length;i++){
            stockexceptionPO stock=(stockexceptionPO)link.getRemoteHelper().getStockOverflowBill().findAll(7) .get(i);
            double l=Math.abs(stock.getNuminsys()-stock.getNuminbase());
            String name=stock.getGoodsno();
            result=result+l*10;
        }

        String re=String.valueOf(result);
        return re;
    }

    public String getGoodsGiven() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getGiftBill().findAll(6);
        int length=a.size();

        for(int i=0;i<length;i++){
            giftPO gift=(giftPO)link.getRemoteHelper().getGiftBill().findAll(6).get(i);
            double l=gift.getNum();
            String name=gift.getGoodsno();
            goodsPO good=(goodsPO)link.getRemoteHelper().getGoods().findbyNO(0,name).get(0);
            double price=good.getOutprice();

            result=result+l*price;
        }

        String re=String.valueOf(result);
        return re;
    }

    public String getAllCommodity() throws RemoteException{
        double result=Double.parseDouble((getReportedLoss()))+Double.parseDouble(getGoodsGiven());
        return String.valueOf(result);
    }

    public String getAfterCut() throws RemoteException {
        double result=Double.parseDouble(getAllCommodity())+Double.parseDouble(getExpenditure());
        return String.valueOf(result);
    }

    public String getProfit() throws RemoteException {
        double result=Double.parseDouble(getCut())-Double.parseDouble(getAfterCut());
        return String.valueOf(result);
    }

}
