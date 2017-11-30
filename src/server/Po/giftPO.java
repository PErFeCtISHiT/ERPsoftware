package server.Po;
import java.io.Serializable;
public class giftPO implements Serializable{
    private Long kind;
    private String note;
    private String oper;
    private Long ischeck;
    private Long isred;
    private String goodsno;
    private String goodsname;
    private String consumerno;
    private String comsumername;
    private Long num;
    private String keyno;

    public giftPO() {

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

    public String getConsumerno() {
        return consumerno;
    }

    public void setConsumerno(String consumerno) {
        this.consumerno = consumerno;
    }

    public String getComsumername() {
        return comsumername;
    }

    public void setComsumername(String comsumername) {
        this.comsumername = comsumername;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    public giftPO(Long kind, String note, String oper, Long ischeck, Long isred, String goodsno, String goodsname, String consumerno, String comsumername, Long num, String keyno) {

        this.kind = kind;
        this.note = note;
        this.oper = oper;
        this.ischeck = ischeck;
        this.isred = isred;
        this.goodsno = goodsno;
        this.goodsname = goodsname;
        this.consumerno = consumerno;
        this.comsumername = comsumername;
        this.num = num;
        this.keyno = keyno;
    }
}