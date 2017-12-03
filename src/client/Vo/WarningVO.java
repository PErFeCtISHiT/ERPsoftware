package client.Vo;

import java.io.Serializable;

public class WarningVO implements Serializable {
    private double kind;
    private String keyno;
    private String note;
    private String oper;
    private double ischeck;
    private double isred;
    private String goodsno;
    private String goodsname;
    private double num;
    private double warningnum;

    public WarningVO() {

    }

    public double getKind() {
        return kind;
    }

    public void setKind(double kind) {
        this.kind = kind;
    }

    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public double getIscheck() {
        return ischeck;
    }

    public void setIscheck(double ischeck) {
        this.ischeck = ischeck;
    }

    public double getIsred() {
        return isred;
    }

    public void setIsred(double isred) {
        this.isred = isred;
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

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getWarningnum() {
        return warningnum;
    }

    public void setWarningnum(Long warningnum) {
        this.warningnum = warningnum;
    }

    public WarningVO(double kind, String keyno, String note, String oper, double ischeck, double isred, String goodsno, String goodsname, double num, double warningnum) {

        this.kind = kind;
        this.keyno = keyno;
        this.note = note;
        this.oper = oper;
        this.ischeck = ischeck;
        this.isred = isred;
        this.goodsno = goodsno;
        this.goodsname = goodsname;
        this.num = num;
        this.warningnum = warningnum;
    }
}