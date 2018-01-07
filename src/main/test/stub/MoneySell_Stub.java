package stub;

import dataservice.ResultMessage;
import logicservice.MoneySell;
import po.goodsPO;
import po.userPO;
import po.consumerPO;

public class MoneySell_Stub implements MoneySell{
	@Override
	public ResultMessage moneySellmake(String a,goodsPO goods,userPO user,consumerPO consumer){
		return null;
	}
	@Override
	public ResultMessage submitMoneySell(){return null;}
}
