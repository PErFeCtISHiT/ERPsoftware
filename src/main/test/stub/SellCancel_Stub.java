package stub;


import dataservice.ResultMessage;
import logicservice.SellCancel;
import po.goodsPO;
import po.userPO;
import po.consumerPO;
public class SellCancel_Stub implements SellCancel{

	@Override
	public ResultMessage SellCancelmake(String a,goodsPO goods,userPO user,consumerPO consumer){
		return null;
	}

	@Override
	public ResultMessage submitSellCancel(){
		return null;
	}
}
