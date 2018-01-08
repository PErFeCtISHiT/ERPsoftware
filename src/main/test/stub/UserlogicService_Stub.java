package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import logicservice.UserLogicService;
import po.goodsPO;
import po.userPO;

public class UserlogicService_Stub implements UserLogicService{

	@Override
	public ResultMessage signin(long id,String password){
		return null;
	}

	@Override
	public ResultMessage signup(long id,String password,userPO user){
		return null;
	}
}
