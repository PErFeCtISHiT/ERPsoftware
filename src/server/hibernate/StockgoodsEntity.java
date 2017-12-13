package server.hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 15:25 2017/12/8
 */
@Entity
@Table(name = "STOCKGOODS", schema = "PIS")
public class StockgoodsEntity {
    private String keyno;
    private String goodsno;
    private String goodsname;
    private Double keynum;
    private Double sumall;

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
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
    @Column(name = "KEYNUM", nullable = true, precision = 0)
    public Double getKeynum() {
        return keynum;
    }

    public void setKeynum(Double keynum) {
        this.keynum = keynum;
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
        StockgoodsEntity that = (StockgoodsEntity) o;
        return Objects.equals(keyno, that.keyno) &&
                Objects.equals(goodsno, that.goodsno) &&
                Objects.equals(goodsname, that.goodsname) &&
                Objects.equals(keynum, that.keynum) &&
                Objects.equals(sumall, that.sumall);
    }

    @Override
    public int hashCode() {

        return Objects.hash(keyno, goodsno, goodsname, keynum, sumall);
    }
}
