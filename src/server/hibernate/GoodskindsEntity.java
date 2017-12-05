package server.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "GOODSKINDS", schema = "PIS")
public class GoodskindsEntity {
    private String keyno;
    private String keyname;
    private String father;
    private String son;

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "KEYNAME", nullable = true, length = 20)
    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    @Basic
    @Column(name = "FATHER", nullable = true, length = 20)
    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Basic
    @Column(name = "SON", nullable = true, length = 2000)
    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodskindsEntity that = (GoodskindsEntity) o;

        if (keyno != null ? !keyno.equals(that.keyno) : that.keyno != null) return false;
        if (keyname != null ? !keyname.equals(that.keyname) : that.keyname != null) return false;
        if (father != null ? !father.equals(that.father) : that.father != null) return false;
        if (son != null ? !son.equals(that.son) : that.son != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = keyno != null ? keyno.hashCode() : 0;
        result = 31 * result + (keyname != null ? keyname.hashCode() : 0);
        result = 31 * result + (father != null ? father.hashCode() : 0);
        result = 31 * result + (son != null ? son.hashCode() : 0);
        return result;
    }
}
