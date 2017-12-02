package server.Dataservice.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "SELLOUT", schema = "PIS", catalog = "")
public class SelloutEntity {
    private Long kind;
    private String keyno;
    private String note;
    private String oper;
    private Long ischeck;
    private Long isred;
    private String consumer;
    private String server;
    private String base;
    private String goodsoutlist;
    private Long sumall;
    private Long cut;
    private Long voucher;
    private Long finalsum;

    @Basic
    @Column(name = "KIND", nullable = true, precision = 0)
    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
        this.kind = kind;
    }

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "NOTE", nullable = true, length = 20)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "OPER", nullable = true, length = 20)
    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    @Basic
    @Column(name = "ISCHECK", nullable = true, precision = 0)
    public Long getIscheck() {
        return ischeck;
    }

    public void setIscheck(Long ischeck) {
        this.ischeck = ischeck;
    }

    @Basic
    @Column(name = "ISRED", nullable = true, precision = 0)
    public Long getIsred() {
        return isred;
    }

    public void setIsred(Long isred) {
        this.isred = isred;
    }

    @Basic
    @Column(name = "CONSUMER", nullable = true, length = 20)
    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @Basic
    @Column(name = "SERVER", nullable = true, length = 20)
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Basic
    @Column(name = "BASE", nullable = true, length = 20)
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Basic
    @Column(name = "GOODSOUTLIST", nullable = true, length = 200)
    public String getGoodsoutlist() {
        return goodsoutlist;
    }

    public void setGoodsoutlist(String goodsoutlist) {
        this.goodsoutlist = goodsoutlist;
    }

    @Basic
    @Column(name = "SUMALL", nullable = true, precision = 0)
    public Long getSumall() {
        return sumall;
    }

    public void setSumall(Long sumall) {
        this.sumall = sumall;
    }

    @Basic
    @Column(name = "CUT", nullable = true, precision = 0)
    public Long getCut() {
        return cut;
    }

    public void setCut(Long cut) {
        this.cut = cut;
    }

    @Basic
    @Column(name = "VOUCHER", nullable = true, precision = 0)
    public Long getVoucher() {
        return voucher;
    }

    public void setVoucher(Long voucher) {
        this.voucher = voucher;
    }

    @Basic
    @Column(name = "FINALSUM", nullable = true, precision = 0)
    public Long getFinalsum() {
        return finalsum;
    }

    public void setFinalsum(Long finalsum) {
        this.finalsum = finalsum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelloutEntity that = (SelloutEntity) o;

        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (oper != null ? !oper.equals(that.oper) : that.oper != null) return false;
        if (ischeck != null ? !ischeck.equals(that.ischeck) : that.ischeck != null) return false;
        if (isred != null ? !isred.equals(that.isred) : that.isred != null) return false;
        if (consumer != null ? !consumer.equals(that.consumer) : that.consumer != null) return false;
        if (server != null ? !server.equals(that.server) : that.server != null) return false;
        if (base != null ? !base.equals(that.base) : that.base != null) return false;
        if (goodsoutlist != null ? !goodsoutlist.equals(that.goodsoutlist) : that.goodsoutlist != null) return false;
        if (sumall != null ? !sumall.equals(that.sumall) : that.sumall != null) return false;
        if (cut != null ? !cut.equals(that.cut) : that.cut != null) return false;
        if (voucher != null ? !voucher.equals(that.voucher) : that.voucher != null) return false;
        if (finalsum != null ? !finalsum.equals(that.finalsum) : that.finalsum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kind != null ? kind.hashCode() : 0;
        result = 31 * result + (keyno != null ? keyno.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (oper != null ? oper.hashCode() : 0);
        result = 31 * result + (ischeck != null ? ischeck.hashCode() : 0);
        result = 31 * result + (isred != null ? isred.hashCode() : 0);
        result = 31 * result + (consumer != null ? consumer.hashCode() : 0);
        result = 31 * result + (server != null ? server.hashCode() : 0);
        result = 31 * result + (base != null ? base.hashCode() : 0);
        result = 31 * result + (goodsoutlist != null ? goodsoutlist.hashCode() : 0);
        result = 31 * result + (sumall != null ? sumall.hashCode() : 0);
        result = 31 * result + (cut != null ? cut.hashCode() : 0);
        result = 31 * result + (voucher != null ? voucher.hashCode() : 0);
        result = 31 * result + (finalsum != null ? finalsum.hashCode() : 0);
        return result;
    }
}
