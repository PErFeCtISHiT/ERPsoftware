package client.BL.Saleman.SalemanStockinblservice;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

import client.Vo.goodsVO;
/**
 * Created by Leonarda on 2017/12/3.
 */
public class StockinBill {
    public final SimpleStringProperty BuyinID;
    public final SimpleStringProperty BuyinOffer;
    public final SimpleStringProperty BuyinStoreHouse;
    public final SimpleStringProperty BuyinOperater;
    public final SimpleStringProperty BuyinGoodsList;
    public final SimpleStringProperty BuyinTips;
    public final SimpleStringProperty BuyinSum;

    public final SimpleStringProperty BuyinKinds;


    public StockinBill(String a,String b,String c,String d,String e,String f,String g,String h){
        this.BuyinID=new SimpleStringProperty(a);
        this.BuyinOffer=new SimpleStringProperty(b);
        this.BuyinStoreHouse=new SimpleStringProperty(c);
        this.BuyinOperater=new SimpleStringProperty(d);
        this.BuyinGoodsList=new SimpleStringProperty(e);
        this.BuyinTips=new SimpleStringProperty(f);
        this.BuyinSum=new SimpleStringProperty(g);
        this.BuyinKinds=new SimpleStringProperty(h);
    }

    public void setBuyinKinds(String buyinKinds) {
        this.BuyinKinds.set(buyinKinds);
    }

    public String getBuyinKinds() {
        return BuyinKinds.get();
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
