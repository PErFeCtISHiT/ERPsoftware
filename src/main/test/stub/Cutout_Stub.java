package stub;

import po.selloutPO;

import logicservice.Cutout;

public class Cutout_Stub implements Cutout{

	@Override
	public selloutPO Cutoutmake(selloutPO sellout){
		return sellout;
	}
}
