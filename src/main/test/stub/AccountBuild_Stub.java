package stub;



import logicservice.AccountBuild;

import dataservice.ResultMessage;

import po.consumerPO;
import po.coPO;
import po.goodsPO;

public class AccountBuild_Stub implements AccountBuild{
	@Override
	public ResultMessage accountbuild(goodsPO goods,consumerPO consumer,coPO co){
		return ResultMessage.Success;
	}
}
