package client.BL.Stockman.StockmanGoodsbl;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:15 2017/12/2
 */
public class Goods {
    public String getGoodsID() {
        return goodsID.get();
    }

    public SimpleStringProperty goodsIDProperty() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID.set(goodsID);
    }

    public String getGoodsName() {
        return goodsName.get();
    }

    public SimpleStringProperty goodsNameProperty() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName.set(goodsName);
    }

    public String getGoodsModel() {
        return goodsModel.get();
    }

    public SimpleStringProperty goodsModelProperty() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel.set(goodsModel);
    }

    public String getGoodsNum() {
        return goodsNum.get();
    }

    public SimpleStringProperty goodsNumProperty() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum.set(goodsNum);
    }

    public String getGoodsInprice() {
        return goodsInprice.get();
    }

    public SimpleStringProperty goodsInpriceProperty() {
        return goodsInprice;
    }

    public void setGoodsInprice(String goodsInprice) {
        this.goodsInprice.set(goodsInprice);
    }

    public String getGoodsOutprice() {
        return goodsOutprice.get();
    }

    public SimpleStringProperty goodsOutpriceProperty() {
        return goodsOutprice;
    }

    public void setGoodsOutprice(String goodsOutprice) {
        this.goodsOutprice.set(goodsOutprice);
    }

    public String getGoodsReceinprice() {
        return goodsReceinprice.get();
    }

    public SimpleStringProperty goodsReceinpriceProperty() {
        return goodsReceinprice;
    }

    public void setGoodsReceinprice(String goodsReceinprice) {
        this.goodsReceinprice.set(goodsReceinprice);
    }

    public String getGoodsReceoutprice() {
        return goodsReceoutprice.get();
    }

    public SimpleStringProperty goodsReceoutpriceProperty() {
        return goodsReceoutprice;
    }

    public void setGoodsReceoutprice(String goodsReceoutprice) {
        this.goodsReceoutprice.set(goodsReceoutprice);
    }

    public final SimpleStringProperty goodsID;
    public final SimpleStringProperty goodsName;
    public final SimpleStringProperty goodsModel;
    public final SimpleStringProperty goodsNum;
    public final SimpleStringProperty goodsInprice;
    public final SimpleStringProperty goodsOutprice;
    public final SimpleStringProperty goodsReceinprice;
    public final SimpleStringProperty goodsReceoutprice;
    public final SimpleStringProperty goodsWarningnum;
    public final SimpleStringProperty batch;
    public final SimpleStringProperty batchno;
    public final SimpleStringProperty outdate;

    public String getBatch() {
        return batch.get();
    }

    public SimpleStringProperty batchProperty() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch.set(batch);
    }

    public String getBatchno() {
        return batchno.get();
    }

    public SimpleStringProperty batchnoProperty() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno.set(batchno);
    }

    public String getOutdate() {
        return outdate.get();
    }

    public SimpleStringProperty outdateProperty() {
        return outdate;
    }

    public void setOutdate(String outdate) {
        this.outdate.set(outdate);
    }

    public String getGoodsWarningnum() {
        return goodsWarningnum.get();
    }

    public SimpleStringProperty goodsWarningnumProperty() {
        return goodsWarningnum;
    }

    public void setGoodsWarningnum(String goodsWarningnum) {
        this.goodsWarningnum.set(goodsWarningnum);
    }

    public Goods(String goodsID, String goodsName, String goodsModel, String goodsNum, String goodsInprice, String goodsOutprice, String goodsReceinprice, String goodsReceoutprice, String warningnum, String batch, String batchno, String outdate) {
        this.goodsID = new SimpleStringProperty(goodsID);
        this.goodsName = new SimpleStringProperty(goodsName);
        this.goodsModel = new SimpleStringProperty(goodsModel);
        this.goodsNum = new SimpleStringProperty(goodsNum);
        this.goodsInprice = new SimpleStringProperty(goodsInprice);
        this.goodsOutprice = new SimpleStringProperty(goodsOutprice);
        this.goodsReceinprice = new SimpleStringProperty(goodsReceinprice);
        this.goodsReceoutprice = new SimpleStringProperty(goodsReceoutprice);
        this.goodsWarningnum = new SimpleStringProperty(warningnum);
        this.batch = new SimpleStringProperty(batch);
        this.batchno = new SimpleStringProperty(batchno);
        this.outdate = new SimpleStringProperty(outdate);
    }
}
