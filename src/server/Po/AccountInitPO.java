package server.Po;

import java.io.Serializable;

public class AccountInitPO implements Serializable{
    private String keyno;
    private String keyyear;
    private String accountlist;
    private String consumerlist;
    private String goodslist;

    public String getKeyno() {
        return keyno;
    }

    public void setKeyno(String keyno) {
        this.keyno = keyno;
    }

    public String getKeyyear() {
        return keyyear;
    }

    public void setKeyyear(String keyyear) {
        this.keyyear = keyyear;
    }

    public String getAccountlist() {
        return accountlist;
    }

    public void setAccountlist(String accountlist) {
        this.accountlist = accountlist;
    }

    public String getConsumerlist() {
        return consumerlist;
    }

    public void setConsumerlist(String consumerlist) {
        this.consumerlist = consumerlist;
    }

    public String getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(String goodslist) {
        this.goodslist = goodslist;
    }
}
