package stub;

import po.billPO;

import dataservice.ResultMessage;

import logicservice.Examine;

public class Examine_Stub implements Examine{

	@Override
	public ResultMessage examine(billPO bill){
		return ResultMessage.Success;
	}

}