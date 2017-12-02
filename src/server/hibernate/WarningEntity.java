package server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "WARNING", schema = "PIS", catalog = "")
public class WarningEntity {
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
    @Column(name = "NUM", nullable = true, precision = 0)
    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Basic
    @Column(name = "WARNINGNUM", nullable = true, precision = 0)
    public Long getWarningnum() {
        return warningnum;
    }

    public void setWarningnum(Long warningnum) {
        this.warningnum = warningnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarningEntity that = (WarningEntity) o;

        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (oper != null ? !oper.equals(that.oper) : that.oper != null) return false;
        if (ischeck != null ? !ischeck.equals(that.ischeck) : that.ischeck != null) return false;
        if (isred != null ? !isred.equals(that.isred) : that.isred != null) return false;
        if (goodsno != null ? !goodsno.equals(that.goodsno) : that.goodsno != null) return false;
        if (goodsname != null ? !goodsname.equals(that.goodsname) : that.goodsname != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;
        if (warningnum != null ? !warningnum.equals(that.warningnum) : that.warningnum != null) return false;

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
        result = 31 * result + (goodsno != null ? goodsno.hashCode() : 0);
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (warningnum != null ? warningnum.hashCode() : 0);
        return result;
    }
}
