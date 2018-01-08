package stub;

import logicservice.StockinCancel;
import dataservice.ResultMessage;
import po.goodsPO;
import po.userPO;
import po.consumerPO;

public class StockinCancel_Stub implements StockinCancel{

	@Override
	public ResultMessage stockinCancelmake(String a,goodsPO goods,userPO user,consumerPO consumer){
		return null;
	}

	@Override
	public ResultMessage submit(){
		return null;
	}
}
