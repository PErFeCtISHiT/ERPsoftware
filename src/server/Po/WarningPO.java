package server.Po;

import java.io.Serializable;

public class WarningPO implements Serializable {
    private Long kind;
    private String keyno;
    private String note;
    private String oper;
    private Long ischeck;
    private Long isred;
    private String goodsno;
    private String goodsname;
    private Long num;
    private Long warningnum;

    public WarningPO() {

    }

    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
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

    public Long getIscheck() {
        return ischeck;
    }

    public void setIscheck(Long ischeck) {
        this.ischeck = ischeck;
    }

    public Long getIsred() {
        return isred;
    }

    public void setIsred(Long isred) {
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

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getWarningnum() {
        return warningnum;
    }

    public void setWarningnum(Long warningnum) {
        this.warningnum = warningnum;
    }

    public WarningPO(Long kind, String keyno, String note, String oper, Long ischeck, Long isred, String goodsno, String goodsname, Long num, Long warningnum) {

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