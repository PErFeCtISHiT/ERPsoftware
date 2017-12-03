package server.Po;
import java.io.Serializable;

public class stockexceptionPO implements Serializable {
    private Long kind;
    private String note;
    private String oper;
    private Long ischeck;
    private String isred;
    private String goodsno;
    private String goodsname;
    private Long numinbase;
    private Long numinsys;
    private String keyno;

    public stockexceptionPO() {

    }

    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
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

    public Long getIscheck() {
        return ischeck;
    }

    public void setIscheck(Long ischeck) {
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

    public Long getNuminbase() {
        return numinbase;
    }

    public void setNuminbase(Long numinbase) {
        this.numinbase = numinbase;
    }

    public Long getNuminsys() {
        return numinsys;
    }

    public void setNuminsys(Long numinsys) {
        this.numinsys = numinsys;
    }

    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    public stockexceptionPO(Long kind, String note, String oper, Long ischeck, String isred, String goodsno, String goodsname, Long numinbase, Long numinsys, String keyno) {

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