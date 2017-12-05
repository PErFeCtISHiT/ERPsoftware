package client.Vo;
import java.io.Serializable;

public class stockexceptionVO implements Serializable {
    private Double kind;
    private String note;
    private String oper;
    private Double ischeck;
    private String isred;
    private String goodsno;
    private String goodsname;
    private Double numinbase;
    private Double numinsys;
    private String keyno;

    private Double isDraft;

    public Double getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Double isDraft) {
        this.isDraft = isDraft;
    }
    public stockexceptionVO() {

    }

    public Double getKind() {
        return kind;
    }

    public void setKind(Double kind) {
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

    public Double getIscheck() {
        return ischeck;
    }

    public void setIscheck(Double ischeck) {
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

    public Double getNuminbase() {
        return numinbase;
    }

    public void setNuminbase(Double numinbase) {
        this.numinbase = numinbase;
    }

    public Double getNuminsys() {
        return numinsys;
    }

    public void setNuminsys(Double numinsys) {
        this.numinsys = numinsys;
    }

    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    public stockexceptionVO(Double kind, String note, String oper, Double ischeck, String isred, String goodsno, String goodsname, Double numinbase, Double numinsys, String keyno) {

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