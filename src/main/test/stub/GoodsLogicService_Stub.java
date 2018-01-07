package stub;

import java.util.ArrayList;
import dataservice.ResultMessage;

import po.goodsPO;

import logicservice.GoodsLogicService;


public class GoodsLogicService_Stub implements GoodsLogicService{

	@Override
	public ResultMessage addgoods(goodsPO goods){
		return ResultMessage.Success;
	}
	@Override
	public ResultMessage deletegoods(goodsPO goods) {
		return ResultMessage.Success;
	}
	@Override
	public ResultMessage modifygoods(goodsPO goods){ return ResultMessage.Success; }
	@Override
	public ArrayList<goodsPO> Search(String keyword){
		return null;
	}

}
