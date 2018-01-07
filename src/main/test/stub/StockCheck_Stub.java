package stub;

import logicservice.StockCheck;

public class StockCheck_Stub implements StockCheck{

	@Override
	public void stockcheck(){};

	@Override
	public boolean getexcel(){
		return false;
	};
}
