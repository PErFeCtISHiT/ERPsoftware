package server.Po;

import java.io.Serializable;

public class WarningPO implements Serializable {
    private Double kind;
    private String keyno;
    private String note;
    private String oper;
    private Double ischeck;
    private Double isred;
    private String goodsno;
    private String goodsname;
    private Double num;
    private Double warningnum;

    public WarningPO() {

    }

    public Double getKind() {
        return kind;
    }

    public void setKind(Double kind) {
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

    public Double getIscheck() {
        return ischeck;
    }

    public void setIscheck(Double ischeck) {
        this.ischeck = ischeck;
    }

    public Double getIsred() {
        return isred;
    }

    public void setIsred(Double isred) {
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

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Double getWarningnum() {
        return warningnum;
    }

    public void setWarningnum(Double warningnum) {
        this.warningnum = warningnum;
    }

    public WarningPO(Double kind, String keyno, String note, String oper, Double ischeck, Double isred, String goodsno, String goodsname, Double num, Double warningnum) {

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