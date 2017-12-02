package client.BL.Accountant.FinancialCheckSellbl;

import javafx.beans.property.SimpleStringProperty;

public  class Sale {

    public final SimpleStringProperty saleTime;
    public final SimpleStringProperty goodsName;
    public final SimpleStringProperty goodsType;
    public final SimpleStringProperty goodsNum;
    public final SimpleStringProperty goodsPrice;
    public final SimpleStringProperty totalSum;

    public final SimpleStringProperty consumer;
    public final SimpleStringProperty operater;
    public final SimpleStringProperty base;



    public Sale(String saleTime, String goodsName, String goodsType,String goodsNum,
                String goodsPrice, String totalSum,String consumer,String operater,String base) {
        this.saleTime = new SimpleStringProperty(saleTime);
        this.goodsName = new SimpleStringProperty(goodsName);
        this.goodsType = new SimpleStringProperty(goodsType);
        this.goodsNum = new SimpleStringProperty(goodsNum);
        this.goodsPrice = new SimpleStringProperty(goodsPrice);
        this.totalSum = new SimpleStringProperty(totalSum);
        this.consumer = new SimpleStringProperty(consumer);
        this.operater = new SimpleStringProperty(operater);
        this.base = new SimpleStringProperty(base);

    }

    public String getSaleTime() {
        return saleTime.get();
    }

    public void setSaleTime(String fName) {
        saleTime.set(fName);
    }

    public String getGoodsName() {
        return goodsName.get();
    }

    public void setGoodsName(String fName) {
        goodsName.set(fName);
    }

    public String getGoodsType() {
        return goodsType.get();
    }

    public void setGoodsType(String fName) {
        goodsType.set(fName);
    }

    public String getGoodsNum() {
        return goodsNum.get();
    }

    public void setGoodsNum(String fName) {
        goodsNum.set(fName);
    }

    public String getGoodsPrice() {
        return goodsPrice.get();
    }

    public void setGoodsPrice(String fName) {
        goodsPrice.set(fName);
    }

    public String getTotalSum() {
        return totalSum.get();
    }

    public void setTotalSum(String fName) {
        totalSum.set(fName);
    }


    public String getConsumer() {
        return consumer.get();
    }

    public void setConsumer(String fName) {
        consumer.set(fName);
    }

    public String getOperater() {
        return operater.get();
    }

    public void setOperater(String fName) { operater.set(fName); }

    public String getBase() {
        return base.get();
    }

    public void setBase(String fName) {
        base.set(fName);
    }




}