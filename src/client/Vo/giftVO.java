package client.Vo;
import java.io.Serializable;
public class giftVO implements Serializable {
    private Double kind;
    private String note;
    private String oper;
    private Double ischeck;
    private Double isred;
    private String goodsno;
    private String goodsname;
    private String consumerno;
    private String comsumername;
    private Double num;
    private String keyno;

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

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    public giftVO(Double kind, String note, String oper, Double ischeck, Double isred, String goodsno, String goodsname, String consumerno, String comsumername, Double num, String keyno) {

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