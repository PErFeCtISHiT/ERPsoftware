package server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "STOCKEXCEPTION", schema = "PIS", catalog = "")
public class StockexceptionEntity {
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

    @Basic
    @Column(name = "KIND", nullable = true, precision = 0)
    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
        this.kind = kind;
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
    @Column(name = "ISRED", nullable = true, length = 20)
    public String getIsred() {
        return isred;
    }

    public void setIsred(String isred) {
        this.isred = isred;
    }

    @Basic
    @Column(name = "GOODSNO", nullable = true, length = 20)
    public String getGoodsno() {
        return goodsno;
    }

    public void setGoodsno(String goodsno) {
        this.goodsno = goodsno;
    }

    @Basic
    @Column(name = "GOODSNAME", nullable = true, length = 20)
    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    @Basic
    @Column(name = "NUMINBASE", nullable = true, precision = 0)
    public Long getNuminbase() {
        return numinbase;
    }

    public void setNuminbase(Long numinbase) {
        this.numinbase = numinbase;
    }

    @Basic
    @Column(name = "NUMINSYS", nullable = true, precision = 0)
    public Long getNuminsys() {
        return numinsys;
    }

    public void setNuminsys(Long numinsys) {
        this.numinsys = numinsys;
    }

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockexceptionEntity that = (StockexceptionEntity) o;

        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (oper != null ? !oper.equals(that.oper) : that.oper != null) return false;
        if (ischeck != null ? !ischeck.equals(that.ischeck) : that.ischeck != null) return false;
        if (isred != null ? !isred.equals(that.isred) : that.isred != null) return false;
        if (goodsno != null ? !goodsno.equals(that.goodsno) : that.goodsno != null) return false;
        if (goodsname != null ? !goodsname.equals(that.goodsname) : that.goodsname != null) return false;
        if (numinbase != null ? !numinbase.equals(that.numinbase) : that.numinbase != null) return false;
        if (numinsys != null ? !numinsys.equals(that.numinsys) : that.numinsys != null) return false;
        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kind != null ? kind.hashCode() : 0;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (oper != null ? oper.hashCode() : 0);
        result = 31 * result + (ischeck != null ? ischeck.hashCode() : 0);
        result = 31 * result + (isred != null ? isred.hashCode() : 0);
        result = 31 * result + (goodsno != null ? goodsno.hashCode() : 0);
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (numinbase != null ? numinbase.hashCode() : 0);
        result = 31 * result + (numinsys != null ? numinsys.hashCode() : 0);
        result = 31 * result + (keyno != null ? keyno.hashCode() : 0);
        return result;
    }
}
