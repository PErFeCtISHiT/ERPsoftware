package server.Dataservice.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "PACK", schema = "PIS", catalog = "")
public class PackEntity {
    private String keyno;
    private String goodsno;
    private String goodsname;
    private Long price;

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "GOODSNO", nullable = true, length = 200)
    public String getGoodsno() {
        return goodsno;
    }

    public void setGoodsno(String goodsno) {
        this.goodsno = goodsno;
    }

    @Basic
    @Column(name = "GOODSNAME", nullable = true, length = 200)
    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    @Basic
    @Column(name = "PRICE", nullable = true, precision = 0)
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackEntity that = (PackEntity) o;

        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (goodsno != null ? !goodsno.equals(that.goodsno) : that.goodsno != null) return false;
        if (goodsname != null ? !goodsname.equals(that.goodsname) : that.goodsname != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyno != null ? keyno.hashCode() : 0;
        result = 31 * result + (goodsno != null ? goodsno.hashCode() : 0);
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
