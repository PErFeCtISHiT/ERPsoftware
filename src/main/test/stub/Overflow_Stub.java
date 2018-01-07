package stub;


import logicservice.Overflow;
import po.goodsPO;
import po.userPO;

public class Overflow_Stub implements Overflow {
	@Override
	public void changegoods(goodsPO goods){}
	@Override
	public boolean OverflowMake(goodsPO goods,int actualNum,int systemNum){
		return false;
	}
}
