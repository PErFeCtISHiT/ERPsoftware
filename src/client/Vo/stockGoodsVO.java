package client.Vo;

import java.io.Serializable;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:29 2017/12/8
 */
public class stockGoodsVO implements Serializable{
    private String keyno;
    private String goodsno;
    private String goodsname;
    private Double keynum;
    private Double sumall;

    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    public String getGoodsno() {
        return goodsno;
    }

    public void setGoodsno(String goodsno) {
        this.goodsno = goodsno;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Double getKeynum() {
        return keynum;
    }

    public void setKeynum(Double keynum) {
        this.keynum = keynum;
    }

    public Double getSumall() {
        return sumall;
    }

    public void setSumall(Double sumall) {
        this.sumall = sumall;
    }
}
