package stub;

import dataservice.ResultMessage;

import logicservice.GoodskindsLogicService;

import po.goodskindsPO;

public class GoodskindsLogicService_Stub implements GoodskindsLogicService{

	@Override
	public ResultMessage addgoodskinds(goodskindsPO kind) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deletegoodskinds(goodskindsPO kind) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage modifygoodskinds(goodskindsPO kind) {
		return ResultMessage.Success;
	}

}
