package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import logicservice.Stockin;
import po.goodsPO;
import po.userPO;
import po.consumerPO;

public class Stockin_Stub implements Stockin{

	@Override
	public ResultMessage stockinmake(String a,goodsPO goods,userPO user,consumerPO consumer){
		return null;
	}

	@Override
	public ResultMessage submit(){
		return null;
	};
}
