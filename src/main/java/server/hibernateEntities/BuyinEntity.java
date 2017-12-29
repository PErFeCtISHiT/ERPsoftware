package server.hibernateEntities;

import javax.persistence.*;

@Entity
@Table(name = "BUYIN", schema = "PIS")
public class BuyinEntity {
    private Double kind;
    private String keyno;
    private String note;
    private String oper;
    private Double ischeck;
    private Double isred;
    private String provider;
    private String base;
    private String goodsoutlist;
    private Double sumall;
    private Double isDraft;
    @Basic
    @Column(name = "ISDRAFT", nullable = true, precision = 0)
    public Double getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Double isDraft) {
        this.isDraft = isDraft;
    }
    @Basic
    @Column(name = "KIND", nullable = true, precision = 0)
    public Double getKind() {
        return kind;
    }

    public void setKind(Double kind) {
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
    @Column(name = "NOTE", nullable = true, length = 2000)
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
    public Double getIscheck() {
        return ischeck;
    }

    public void setIscheck(Double ischeck) {
        this.ischeck = ischeck;
    }

    @Basic
    @Column(name = "ISRED", nullable = true, precision = 0)
    public Double getIsred() {
        return isred;
    }

    public void setIsred(Double isred) {
        this.isred = isred;
    }

    @Basic
    @Column(name = "PROVIDER", nullable = true, length = 20)
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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
    @Column(name = "GOODSOUTLIST", nullable = true, length = 2000)
    public String getGoodsoutlist() {
        return goodsoutlist;
    }

    public void setGoodsoutlist(String goodsoutlist) {
        this.goodsoutlist = goodsoutlist;
    }

    @Basic
    @Column(name = "SUMALL", nullable = true, precision = 0)
    public Double getSumall() {
        return sumall;
    }

    public void setSumall(Double sumall) {
        this.sumall = sumall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuyinEntity that = (BuyinEntity) o;

        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (oper != null ? !oper.equals(that.oper) : that.oper != null) return false;
        if (ischeck != null ? !ischeck.equals(that.ischeck) : that.ischeck != null) return false;
        if (isred != null ? !isred.equals(that.isred) : that.isred != null) return false;
        if (provider != null ? !provider.equals(that.provider) : that.provider != null) return false;
        if (base != null ? !base.equals(that.base) : that.base != null) return false;
        if (goodsoutlist != null ? !goodsoutlist.equals(that.goodsoutlist) : that.goodsoutlist != null) return false;
        return sumall != null ? sumall.equals(that.sumall) : that.sumall == null;
    }

    @Override
    public int hashCode() {
        int result = kind != null ? kind.hashCode() : 0;
        result = 31 * result + (keyno != null ? keyno.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (oper != null ? oper.hashCode() : 0);
        result = 31 * result + (ischeck != null ? ischeck.hashCode() : 0);
        result = 31 * result + (isred != null ? isred.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (base != null ? base.hashCode() : 0);
        result = 31 * result + (goodsoutlist != null ? goodsoutlist.hashCode() : 0);
        result = 31 * result + (sumall != null ? sumall.hashCode() : 0);
        return result;
    }
}
