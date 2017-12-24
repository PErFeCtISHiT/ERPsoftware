package client.BL.Accountant.FinancialBuildAccountbl;

import javafx.beans.property.SimpleStringProperty;


/**
 * 期初建账——商品 领域对象
 *
 * 包含商品ID，商品名称，商品类型，商品进货价，商品销售价，最近进货价，最近销售价
 */
public class AccountBuild_good {

    public final SimpleStringProperty goodsID;
    public final SimpleStringProperty goodsName;
    public final SimpleStringProperty goodsModel;
    public final SimpleStringProperty goodsType;
    public final SimpleStringProperty goodsInprice;
    public final SimpleStringProperty goodsOutprice;
    public final SimpleStringProperty goodsReceinprice;
    public final SimpleStringProperty goodsReceoutprice;

    public AccountBuild_good(String goodsID, String goodsName, String goodsModel, String goodsType, String goodsInprice, String goodsOutprice, String goodsReceinprice, String goodsReceoutprice) {
        this.goodsID = new SimpleStringProperty(goodsID);
        this.goodsName = new SimpleStringProperty(goodsName);
        this.goodsModel = new SimpleStringProperty(goodsModel);
        this.goodsType = new SimpleStringProperty(goodsType);
        this.goodsInprice = new SimpleStringProperty(goodsInprice);
        this.goodsOutprice = new SimpleStringProperty(goodsOutprice);
        this.goodsReceinprice = new SimpleStringProperty(goodsReceinprice);
        this.goodsReceoutprice = new SimpleStringProperty(goodsReceoutprice);
    }
    public AccountBuild_good() {
        this.goodsID = new SimpleStringProperty();
        this.goodsName = new SimpleStringProperty();
        this.goodsModel = new SimpleStringProperty();
        this.goodsType = new SimpleStringProperty();
        this.goodsInprice = new SimpleStringProperty();
        this.goodsOutprice = new SimpleStringProperty();
        this.goodsReceinprice = new SimpleStringProperty();
        this.goodsReceoutprice = new SimpleStringProperty();
    }


    public String getGoodsID() {
        return goodsID.get();
    }

    public void setGoodsID(String goodsID) {
        this.goodsID.set(goodsID);
    }

    public String getGoodsName() {
        return goodsName.get();
    }

    public void setGoodsName(String goodsName) {
        this.goodsName.set(goodsName);
    }

    public String getGoodsModel() {
        return goodsModel.get();
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel.set(goodsModel);
    }

    public String getGoodsType() {
        return goodsType.get();
    }

    public void setGoodsType(String goodsNum) {
        this.goodsType.set(goodsNum);
    }

    public String getGoodsInprice() {
        return goodsInprice.get();
    }

    public void setGoodsInprice(String goodsInprice) {
        this.goodsInprice.set(goodsInprice);
    }

    public String getGoodsOutprice() {
        return goodsOutprice.get();
    }

    public void setGoodsOutprice(String goodsOutprice) {
        this.goodsOutprice.set(goodsOutprice);
    }


    public String getGoodsReceinprice() {
        return goodsReceinprice.get();
    }

    public void setGoodsReceinprice(String goodsReceinprice) {
        this.goodsReceinprice.set(goodsReceinprice);
    }

    public String getGoodsReceoutprice() {
        return goodsReceoutprice.get();
    }

    public void setGoodsReceoutprice(String goodsReceoutprice) {
        this.goodsReceoutprice.set(goodsReceoutprice);
    }


}
