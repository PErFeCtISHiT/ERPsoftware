package client.Vo;
import java.io.Serializable;

public class stockexceptionVO implements Serializable {
    private double kind;
    private String note;
    private String oper;
    private double ischeck;
    private String isred;
    private String goodsno;
    private String goodsname;
    private double numinbase;
    private double numinsys;
    private String keyno;

    public stockexceptionVO() {

    }

    public double getKind() {
        return kind;
    }

    public void setKind(double kind) {
        this.kind = kind;
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

    public String getIsred() {
        return isred;
    }

    public void setIsred(String isred) {
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

    public double getNuminbase() {
        return numinbase;
    }

    public void setNuminbase(Long numinbase) {
        this.numinbase = numinbase;
    }

    public double getNuminsys() {
        return numinsys;
    }

    public void setNuminsys(double numinsys) {
        this.numinsys = numinsys;
    }

    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    public stockexceptionVO(double kind, String note, String oper, double ischeck, String isred, String goodsno, String goodsname, double numinbase, double numinsys, String keyno) {

        this.kind = kind;
        this.note = note;
        this.oper = oper;
        this.ischeck = ischeck;
        this.isred = isred;
        this.goodsno = goodsno;
        this.goodsname = goodsname;
        this.numinbase = numinbase;
        this.numinsys = numinsys;
        this.keyno = keyno;
    }
}