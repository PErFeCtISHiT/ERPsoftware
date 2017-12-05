package server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "GOODSOUTLIST", schema = "PIS")
public class GoodsoutlistEntity {
    private String keyno;
    private String goodsno;
    private String goodsname;
    private String keymodel;
    private Double num;
    private Double price;
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
    @Column(name = "KEYMODEL", nullable = true, length = 20)
    public String getKeymodel() {
        return keymodel;
    }

    public void setKeymodel(String keymodel) {
        this.keymodel = keymodel;
    }

    @Basic
    @Column(name = "NUM", nullable = true, precision = 0)
    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    @Basic
    @Column(name = "PRICE", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

        GoodsoutlistEntity that = (GoodsoutlistEntity) o;

        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (goodsno != null ? !goodsno.equals(that.goodsno) : that.goodsno != null) return false;
        if (goodsname != null ? !goodsname.equals(that.goodsname) : that.goodsname != null) return false;
        if (keymodel != null ? !keymodel.equals(that.keymodel) : that.keymodel != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (sumall != null ? !sumall.equals(that.sumall) : that.sumall != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyno != null ? keyno.hashCode() : 0;
        result = 31 * result + (goodsno != null ? goodsno.hashCode() : 0);
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (keymodel != null ? keymodel.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sumall != null ? sumall.hashCode() : 0);
        return result;
    }
}
