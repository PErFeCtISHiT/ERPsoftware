package server.Dataservice.hibernate;

import javax.persistence.*;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 11:44 2017/12/2
 */
@Entity
@Table(name = "SALE", schema = "PIS", catalog = "")
public class SaleEntity {
    private String keyno;
    private Long kind;
    private Long lev;
    private String accoun;
    private String base;
    private String goodsinlist;
    private String goodsoutlist;
    private Long presum;
    private Long cut;
    private Long voucher;
    private Long sumall;
    private String dateandtime;

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "KIND", nullable = true, precision = 0)
    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
        this.kind = kind;
    }

    @Basic
    @Column(name = "LEV", nullable = true, precision = 0)
    public Long getLev() {
        return lev;
    }

    public void setLev(Long lev) {
        this.lev = lev;
    }

    @Basic
    @Column(name = "ACCOUN", nullable = true, length = 20)
    public String getAccoun() {
        return accoun;
    }

    public void setAccoun(String accoun) {
        this.accoun = accoun;
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
    @Column(name = "GOODSINLIST", nullable = true, length = 20)
    public String getGoodsinlist() {
        return goodsinlist;
    }

    public void setGoodsinlist(String goodsinlist) {
        this.goodsinlist = goodsinlist;
    }

    @Basic
    @Column(name = "GOODSOUTLIST", nullable = true, length = 20)
    public String getGoodsoutlist() {
        return goodsoutlist;
    }

    public void setGoodsoutlist(String goodsoutlist) {
        this.goodsoutlist = goodsoutlist;
    }

    @Basic
    @Column(name = "PRESUM", nullable = true, precision = 0)
    public Long getPresum() {
        return presum;
    }

    public void setPresum(Long presum) {
        this.presum = presum;
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
    @Column(name = "SUMALL", nullable = true, precision = 0)
    public Long getSumall() {
        return sumall;
    }

    public void setSumall(Long sumall) {
        this.sumall = sumall;
    }

    @Basic
    @Column(name = "DATEANDTIME", nullable = true, length = 20)
    public String getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(String dateandtime) {
        this.dateandtime = dateandtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleEntity that = (SaleEntity) o;

        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (lev != null ? !lev.equals(that.lev) : that.lev != null) return false;
        if (accoun != null ? !accoun.equals(that.accoun) : that.accoun != null) return false;
        if (base != null ? !base.equals(that.base) : that.base != null) return false;
        if (goodsinlist != null ? !goodsinlist.equals(that.goodsinlist) : that.goodsinlist != null) return false;
        if (goodsoutlist != null ? !goodsoutlist.equals(that.goodsoutlist) : that.goodsoutlist != null) return false;
        if (presum != null ? !presum.equals(that.presum) : that.presum != null) return false;
        if (cut != null ? !cut.equals(that.cut) : that.cut != null) return false;
        if (voucher != null ? !voucher.equals(that.voucher) : that.voucher != null) return false;
        if (sumall != null ? !sumall.equals(that.sumall) : that.sumall != null) return false;
        if (dateandtime != null ? !dateandtime.equals(that.dateandtime) : that.dateandtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyno != null ? keyno.hashCode() : 0;
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        result = 31 * result + (lev != null ? lev.hashCode() : 0);
        result = 31 * result + (accoun != null ? accoun.hashCode() : 0);
        result = 31 * result + (base != null ? base.hashCode() : 0);
        result = 31 * result + (goodsinlist != null ? goodsinlist.hashCode() : 0);
        result = 31 * result + (goodsoutlist != null ? goodsoutlist.hashCode() : 0);
        result = 31 * result + (presum != null ? presum.hashCode() : 0);
        result = 31 * result + (cut != null ? cut.hashCode() : 0);
        result = 31 * result + (voucher != null ? voucher.hashCode() : 0);
        result = 31 * result + (sumall != null ? sumall.hashCode() : 0);
        result = 31 * result + (dateandtime != null ? dateandtime.hashCode() : 0);
        return result;
    }
}
