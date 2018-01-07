package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import dataservice.goodskindsdataservice;
import po.goodskindsPO;

public class goodskindsdataservice_stub implements goodskindsdataservice{

	String NO;
	String name;
	int father;
	public goodskindsdataservice_stub(String n1,String n2,int f){
		NO = n1;
		name = n2;
		father = f;
	}
	public String getNO(){
		return NO;
	}
	public String getName(){
		return name;
	}
	public int getFather(){
		return father;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage insert(goodskindsPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	@Override
	public ResultMessage delete(goodskindsPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	@Override
	public ResultMessage modify(goodskindsPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<goodskindsPO> show() {
		ArrayList<goodskindsPO> list= new ArrayList<>();
		return list;
	}
}
