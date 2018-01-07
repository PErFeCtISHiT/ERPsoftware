package stub;


import logicservice.Payment;
import dataservice.ResultMessage;
import po.consumerPO;
import po.goodsPO;
import po.userPO;

public class Payment_Stub implements Payment{
	@Override
	public ResultMessage paymentmake(String a,goodsPO goods,userPO user,consumerPO consumer){
		return null;
	}
	@Override
	public ResultMessage submitPayment(){
		return null;
	}
}
