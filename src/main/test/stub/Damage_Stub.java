package stub;

import po.goodsPO;

import logicservice.Damage;

public class Damage_Stub implements Damage{
	@Override
	public boolean changegoods(goodsPO goods){
		return true;
	}

	@Override
	public boolean DamageMake(goodsPO goods,int actualNum,int systemNum){
		return true;
	}
}

	