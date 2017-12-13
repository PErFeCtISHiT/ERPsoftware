package client.BL.Saleman.SalemanSaleblservice;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Leonarda on 2017/12/3.
 */
public class SelloutBill {
    public SimpleStringProperty selloutkinds;
    public SimpleStringProperty selloutID;
    public SimpleStringProperty selloutTip;
    public SimpleStringProperty selloutOperater;
    public SimpleStringProperty selloutisCheck;
    public SimpleStringProperty selloutisred;
    public SimpleStringProperty selloutConsumer;
    public SimpleStringProperty selloutServer;
    public SimpleStringProperty selloutWarehouse;
    public SimpleStringProperty selloutGoodslist;
    public SimpleStringProperty selloutBeforeMoney;
    public SimpleStringProperty selloutDiscount;
    public SimpleStringProperty selloutCard;
    public SimpleStringProperty selloutSum;
    public SimpleStringProperty selloutisDraft;

    public SelloutBill(String kind,String id,String tip,String oper,String ischeck,String isred,String consumer,String server,String house,String list,String beforemoney,String discount,String card,String sum,String isdraft){
        this.selloutkinds=new SimpleStringProperty(kind);
        this.selloutID=new SimpleStringProperty(id);
        this.selloutTip=new SimpleStringProperty(tip);
        this.selloutOperater=new SimpleStringProperty(oper);
        this.selloutisCheck=new SimpleStringProperty(ischeck);
        this.selloutisred=new SimpleStringProperty(isred);
        this.selloutConsumer=new SimpleStringProperty(consumer);
        this.selloutServer=new SimpleStringProperty(server);
        this.selloutWarehouse=new SimpleStringProperty(house);
        this.selloutGoodslist=new SimpleStringProperty(list);
        this.selloutBeforeMoney=new SimpleStringProperty(beforemoney);
        this.selloutDiscount=new SimpleStringProperty(discount);
        this.selloutCard=new SimpleStringProperty(card);
        this.selloutSum=new SimpleStringProperty(sum);
        this.selloutisDraft=new SimpleStringProperty(isdraft);
    }

    public SelloutBill(){}

    public void setSelloutisCheck(String selloutisCheck) {
        this.selloutisCheck.set(selloutisCheck);
    }

    public void setSelloutisDraft(String selloutisDraft) {
        this.selloutisDraft.set(selloutisDraft);
    }

    public void setSelloutisred(String selloutisred) {
        this.selloutisred.set(selloutisred);
    }

    public String getSelloutisCheck() {
        return selloutisCheck.get();
    }

    public String getSelloutisDraft() {
        return selloutisDraft.get();
    }

    public String getSelloutisred() {
        return selloutisred.get();
    }

    public void setSelloutkinds(String selloutkinds) {
        this.selloutkinds.set(selloutkinds);
    }

    public String getSelloutkinds() {
        return selloutkinds.get();
    }

    public void setSelloutWarehouse(String selloutWarehouse) {
        this.selloutWarehouse.set(selloutWarehouse);
    }

    public String getSelloutWarehouse() {
        return selloutWarehouse.get();
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
