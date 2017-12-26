package client.BL.Accountant.FinancialBuildAccountbl;

import java.util.ArrayList;

/**
 * AccountBuild 领域对象
 * 包含：年份，账户列表，客户列表，商品列表
 */
public class AccountBuild {

    private String year;

    private ArrayList<AccountBuild_account> accountlist;

    private ArrayList<AccountBuild_consumer> consumerlist;

    private ArrayList<AccountBuild_good> goodslist;

    AccountBuild(String year, ArrayList<AccountBuild_account> accountlist, ArrayList<AccountBuild_consumer> consumerlist, ArrayList<AccountBuild_good> goodslist) {
        this.year = year;
        this.accountlist = accountlist;
        this.consumerlist = consumerlist;
        this.goodslist = goodslist;

    }


    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<AccountBuild_account> getAccountlist() {
        return this.accountlist;
    }

    public void setAccountlist(ArrayList<AccountBuild_account> accountlist) {
        this.accountlist = accountlist;
    }

    public ArrayList<AccountBuild_consumer> getConsumerlist() {
        return this.consumerlist;
    }

    public void setConsumerlist(ArrayList<AccountBuild_consumer> consumerlist) {
        this.consumerlist = consumerlist;
    }

    public ArrayList<AccountBuild_good> getGoodslist() {
        return this.goodslist;
    }

    public void setGoodslist(ArrayList<AccountBuild_good> goodslist) {
        this.goodslist = goodslist;
    }

}
