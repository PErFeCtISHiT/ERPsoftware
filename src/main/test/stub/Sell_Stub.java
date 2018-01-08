package stub;

import dataservice.ResultMessage;
import logicservice.Sell;
import po.goodsPO;
import po.userPO;
import po.consumerPO;
import po.cutPO;

public class Sell_Stub implements Sell{

	@Override
	public ResultMessage Sellmake(String a,goodsPO goods,userPO user,consumerPO consumer){
		return null;
	}

	@Override
	public int cut(cutPO cutNum){return 0;}

	@Override
	public ResultMessage submitSell(){
		return null;
	}
}
