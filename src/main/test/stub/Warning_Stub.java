package stub;


import logicservice.Warning;
import po.goodsPO;
import dataservice.ResultMessage;

public class Warning_Stub implements Warning{

	@Override
	public ResultMessage warning(){
		return null;
	}

	@Override
	public ResultMessage warningMake(goodsPO goods,int WarningNum){
		return null;
	}
}
