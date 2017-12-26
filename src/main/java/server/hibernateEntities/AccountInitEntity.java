package server.hibernateEntities;

import javax.persistence.*;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 23:38 2017/12/9
 */
@Entity
@Table(name = "ACCOUNTINIT", schema = "PIS")
public class AccountInitEntity {
    private String keyno;
    private String keyyear;
    private String accountlist;
    private String consumerlist;
    private String goodslist;

    @Id
    @Column(name = "KEYNO", nullable = false, length = 20)
    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    @Basic
    @Column(name = "KEYYEAR", nullable = true, length = 20)
    public String getKeyyear() {
        return keyyear;
    }

    public void setKeyyear(String keyyear) {
        this.keyyear = keyyear;
    }

    @Basic
    @Column(name = "ACCOUNTLIST", nullable = true, length = 2000)
    public String getAccountlist() {
        return accountlist;
    }

    public void setAccountlist(String accountlist) {
        this.accountlist = accountlist;
    }

    @Basic
    @Column(name = "CONSUMERLIST", nullable = true, length = 2000)
    public String getConsumerlist() {
        return consumerlist;
    }

    public void setConsumerlist(String consumerlist) {
        this.consumerlist = consumerlist;
    }

    @Basic
    @Column(name = "GOODSLIST", nullable = true, length = 2000)
    public String getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(String goodslist) {
        this.goodslist = goodslist;
    }


    @Override
    public int hashCode() {
        int result = keyno != null ? keyno.hashCode() : 0;
        result = 31 * result + (keyyear != null ? keyyear.hashCode() : 0);
        result = 31 * result + (accountlist != null ? accountlist.hashCode() : 0);
        result = 31 * result + (consumerlist != null ? consumerlist.hashCode() : 0);
        result = 31 * result + (goodslist != null ? goodslist.hashCode() : 0);
        return result;
    }
}
