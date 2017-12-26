package client.BL.Stockman.StockmanStockGlancebl;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 17:39 2017/12/2
 */
public class ConsumerGoods {
    public final SimpleStringProperty goodsName;
    public final SimpleStringProperty outNum;
    public final SimpleStringProperty inNum;
    public final SimpleStringProperty inSum;
    public final SimpleStringProperty outSum;
    public final SimpleStringProperty numAll;


    public String getGoodsName() {
        return goodsName.get();
    }

    public SimpleStringProperty goodsNameProperty() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName.set(goodsName);
    }

    public String getOutNum() {
        return outNum.get();
    }

    public SimpleStringProperty outNumProperty() {
        return outNum;
    }

    public void setOutNum(String outNum) {
        this.outNum.set(outNum);
    }

    public String getInNum() {
        return inNum.get();
    }

    public SimpleStringProperty inNumProperty() {
        return inNum;
    }

    public void setInNum(String inNum) {
        this.inNum.set(inNum);
    }

    public String getInSum() {
        return inSum.get();
    }

    public SimpleStringProperty inSumProperty() {
        return inSum;
    }

    public void setInSum(String inSum) {
        this.inSum.set(inSum);
    }

    public String getOutSum() {
        return outSum.get();
    }

    public SimpleStringProperty outSumProperty() {
        return outSum;
    }

    public void setOutSum(String outSum) {
        this.outSum.set(outSum);
    }

    public String getNumAll() {
        return numAll.get();
    }

    public SimpleStringProperty numAllProperty() {
        return numAll;
    }

    public void setNumAll(String numAll) {
        this.numAll.set(numAll);
    }

    public ConsumerGoods(String goodsName, String outNum, String inNum, String inSum, String outSum, String numAll) {
        this.goodsName = new SimpleStringProperty(goodsName);
        this.outNum = new SimpleStringProperty(outNum);
        this.inNum = new SimpleStringProperty(inNum);

        this.inSum = new SimpleStringProperty(inSum);
        this.outSum = new SimpleStringProperty(outSum);
        this.numAll = new SimpleStringProperty(numAll);
    }
}
