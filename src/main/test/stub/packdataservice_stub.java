package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import dataservice.packdataservice;
import po.goodsPO;
import po.packPO;

public class packdataservice_stub implements packdataservice{

	String NO;
	double price;
	public packdataservice_stub(String n,double p){
		NO = n;
		price = p;
	}
	public String getNO(){
		return NO;
	}
	public double getPrice(){
		return price;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage insert(packPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	@Override
	public ArrayList<packPO> find(String id) {
		ArrayList<packPO> list= new ArrayList<>();
		packPO resultpo=new packPO(id, price);
		list.add(resultpo);
		return list;	
	}
	@Override
	public ResultMessage delete(packPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	@Override
	public ResultMessage modify(packPO po) {
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
	public ArrayList<packPO> show() {
		ArrayList<packPO> list= new ArrayList<>();
		return list;
	}
}
