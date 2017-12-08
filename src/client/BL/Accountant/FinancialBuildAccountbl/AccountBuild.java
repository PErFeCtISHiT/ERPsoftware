package client.BL.Accountant.FinancialBuildAccountbl;

import java.util.ArrayList;

public class AccountBuild {

    String year;

    ArrayList<AccountBuild_account> accountlist ;

    ArrayList<AccountBuild_consumer> consumerlist ;

    ArrayList<AccountBuild_good> goodslist ;

    public ArrayList<AccountBuild_account> getAccountlist() {
        return this.accountlist;
    }

    public void setAccountlist(ArrayList<AccountBuild_account> accountlist) {
        this.accountlist = accountlist;
    }

    public ArrayList<AccountBuild_consumer> getConsumerlist(){
        return this.consumerlist;
    }

    public void setConsumerlist(ArrayList<AccountBuild_consumer> consumerlist) {
        this.consumerlist = consumerlist;
    }

    public ArrayList<AccountBuild_good> getGoodslist(){
        return this.goodslist;
    }

    public void setGoodslist(ArrayList<AccountBuild_good> goodslist) {
        this.goodslist= goodslist;
    }

}
