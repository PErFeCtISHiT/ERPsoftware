package stub;

import dataservice.ResultMessage;
import logicservice.Receive;
import po.goodsPO;
import po.userPO;
import po.consumerPO;

public class Receive_Stub implements Receive{

	@Override
	public ResultMessage Receivemake(String a,goodsPO goods,userPO user,consumerPO consumer){
		return null;
	}

	@Override
	public ResultMessage submitReceive(){return null;}
}
