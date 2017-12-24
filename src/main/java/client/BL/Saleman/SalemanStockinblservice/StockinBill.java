package client.BL.Saleman.SalemanStockinblservice;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

import client.Vo.goodsVO;
/**
 * Created by Leonarda on 2017/12/3.
 */
public class StockinBill {
    public SimpleStringProperty BuyinKind;
    public SimpleStringProperty BuyinID;
    public SimpleStringProperty BuyinTips;
    public SimpleStringProperty BuyinOperater;
    public SimpleStringProperty BuyinisCheck;
    public SimpleStringProperty BuyinisRed;
    public SimpleStringProperty BuyinOffer;
    public SimpleStringProperty BuyinStoreHouse;
    public SimpleStringProperty BuyinGoodsList;
    public SimpleStringProperty BuyinSum;
    public SimpleStringProperty BuyinisDraft;

    public StockinBill(String kind,String id,String tips,String operater,String ischeck,String isred,String offer,String storehouse,String goodslist,String sum,String isDraft){
        this.BuyinKind=new SimpleStringProperty(kind);
        this.BuyinID=new SimpleStringProperty(id);
        this.BuyinTips=new SimpleStringProperty(tips);
        this.BuyinOperater=new SimpleStringProperty(operater);
        this.BuyinisCheck=new SimpleStringProperty(ischeck);
        this.BuyinisRed=new SimpleStringProperty(isred);
        this.BuyinOffer=new SimpleStringProperty(offer);
        this.BuyinStoreHouse=new SimpleStringProperty(storehouse);
        this.BuyinGoodsList=new SimpleStringProperty(goodslist);
        this.BuyinSum=new SimpleStringProperty(sum);
        this.BuyinisDraft=new SimpleStringProperty(isDraft);
    }
    public StockinBill(){}

    public void setBuyinisDraft(String buyinisDraft) {
        this.BuyinisDraft.set(buyinisDraft);
    }

    public String getBuyinisDraft() {
        return BuyinisDraft.get();
    }

    public void setBuyinisCheck(String buyinisCheck) {
        this.BuyinisCheck.set(buyinisCheck);
    }

    public void setBuyinisRed(String buyinisRed) {
        this.BuyinisRed.set(buyinisRed);
    }

    public void setBuyinKind(String buyinKind) {
        this.BuyinKind.set(buyinKind);
    }

    public String getBuyinKind() {
        return BuyinKind.get();
    }

    public String getBuyinisRed() {
        return BuyinisRed.get();
    }

    public String getBuyinisCheck() {
        return BuyinisCheck.get();
    }

    public String getBuyinSum() {
        return BuyinSum.get();
    }

    public void setBuyinGoodsList(String buyinGoodsList) {
        this.BuyinGoodsList.set(buyinGoodsList);
    }

    public String getBuyinGoodsList() {
        return BuyinGoodsList.get();
    }

    public void setBuyinID(String buyinID) {
        this.BuyinID.set(buyinID);
    }

    public void setBuyinOffer(String buyinOffer) {
        this.BuyinOffer.set(buyinOffer);
    }

    public void setBuyinOperater(String buyinOperater) {
        this.BuyinOperater.set(buyinOperater);
    }

    public void setBuyinStoreHouse(String buyinStoreHouse) {
        this.BuyinStoreHouse.set(buyinStoreHouse);
    }

    public void setBuyinSum(String buyinSum) {
        this.BuyinSum.set(buyinSum);
    }

    public void setBuyinTips(String buyinTips) {
        this.BuyinTips.set(buyinTips);
    }

    public String getBuyinID() {
        return BuyinID.get();
    }

    public String getBuyinTips() {
        return BuyinTips.get();
    }

    public String getBuyinStoreHouse() {
        return BuyinStoreHouse.get();
    }

    public String getBuyinOperater() {
        return BuyinOperater.get();
    }

    public String getBuyinOffer() {
        return BuyinOffer.get();
    }

}
