package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import logicservice.PresentMake;
import po.goodsPO;


public class PresentMake_Stub implements PresentMake{

	@Override
	public boolean PresentAdd(goodsPO goods){
		return false;
	}

	@Override
	public boolean PresentDelete(goodsPO goods){
		return false;
	}

	@Override
	public goodsPO PresentModify(goodsPO goods){
		return null;
	}

	@Override
	public ResultMessage submitPresentMake(ArrayList<goodsPO> goodsList){
		return null;
	}
}
