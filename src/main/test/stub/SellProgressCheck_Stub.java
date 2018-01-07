package stub;

import logicservice.SellProgressCheck;
import po.goodsPO;
import po.userPO;

public class SellProgressCheck_Stub implements SellProgressCheck{

	@Override
	public void check(){}

	@Override
	public boolean getexcel(){
		return false;
	}
}
