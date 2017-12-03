package client.BL.Saleman.SalemanSaleblservice;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Leonarda on 2017/12/3.
 */
public class SelloutBill {
    public final SimpleStringProperty selloutID;
    public final SimpleStringProperty selloutConsumer;
    public final SimpleStringProperty selloutServer;
    public final SimpleStringProperty selloutOperater;
    public final SimpleStringProperty selloutGoodslist;
    public final SimpleStringProperty selloutBeforeMoney;
    public final SimpleStringProperty selloutDiscount;
    public final SimpleStringProperty selloutCard;
    public final SimpleStringProperty selloutSum;
    public final SimpleStringProperty selloutTip;

    public SelloutBill(String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9,String a10){
        this.selloutID=new SimpleStringProperty(a1);
        this.selloutConsumer=new SimpleStringProperty(a2);
        this.selloutServer=new SimpleStringProperty(a3);
        this.selloutOperater=new SimpleStringProperty(a4);
        this.selloutGoodslist=new SimpleStringProperty(a5);
        this.selloutBeforeMoney=new SimpleStringProperty(a6);
        this.selloutDiscount=new SimpleStringProperty(a7);
        this.selloutCard=new SimpleStringProperty(a8);
        this.selloutSum=new SimpleStringProperty(a9);
        this.selloutTip=new SimpleStringProperty(a10);
    }

    public void setSelloutBeforeMoney(String selloutBeforeMoney) {
        this.selloutBeforeMoney.set(selloutBeforeMoney);
    }

    public void setSelloutConsumer(String selloutConsumer) {
        this.selloutConsumer.set(selloutConsumer);
    }

    public void setSelloutDiscount(String selloutDiscount) {
        this.selloutDiscount.set(selloutDiscount);
    }

    public void setSelloutCard(String selloutCard) {
        this.selloutCard.set(selloutCard);
    }

    public void setSelloutGoodslist(String selloutGoodslist) {
        this.selloutGoodslist.set(selloutGoodslist);
    }

    public void setSelloutID(String selloutID) {
        this.selloutID.set(selloutID);
    }

    public void setSelloutOperater(String selloutOperater) {
        this.selloutOperater.set(selloutOperater);
    }

    public void setSelloutServer(String selloutServer) {
        this.selloutServer.set(selloutServer);
    }

    public void setSelloutSum(String selloutSum) {
        this.selloutSum.set(selloutSum);
    }

    public void setSelloutTip(String selloutTip) {
        this.selloutTip.set(selloutTip);
    }

    public String getSelloutBeforeMoney() {
        return selloutBeforeMoney.get();
    }

    public String getSelloutTip() {
        return selloutTip.get();
    }

    public String getSelloutSum() {
        return selloutSum.get();
    }

    public String getSelloutServer() {
        return selloutServer.get();
    }

    public String getSelloutOperater() {
        return selloutOperater.get();
    }

    public String getSelloutID() {
        return selloutID.get();
    }

    public String getSelloutGoodslist() {
        return selloutGoodslist.get();
    }

    public String getSelloutDiscount() {
        return selloutDiscount.get();
    }

    public String getSelloutConsumer() {
        return selloutConsumer.get();
    }

    public String getSelloutCard() {
        return selloutCard.get();
    }
}
