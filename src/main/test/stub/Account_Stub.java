package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import dataservice_stub.codataservice_stub;
import logicservice.Account;
import dataservice.codataservice;
import po.coPO;

public class Account_Stub implements Account{

	@Override
	public ResultMessage addaccount(coPO co) {
		String account=co.getAccount();
		double money=co.getMoney();
		codataservice service=new codataservice_stub(account,money);
		return service.insert(co);
	}

	@Override
	public ResultMessage deleteaccount(coPO co) {
		String account=co.getAccount();
		double money=co.getMoney();
		codataservice service=new codataservice_stub(account,money);
		return service.delete(co);
	}

	@Override
	public ArrayList<coPO> Search(String keyword) {
		return null;
	}

	@Override
	public ResultMessage modifyaccount(coPO co) {
		String account=co.getAccount();
		double money=co.getMoney();
		codataservice service=new codataservice_stub(account,money);
		return service.modify(co);
	}
}
