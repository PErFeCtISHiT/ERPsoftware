package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import dataservice.goodsdataservice;
import po.goodsPO;

public class goodsdataservice_stub implements goodsdataservice{

	String NO;
	String name;
	String type;
	
	public goodsdataservice_stub(String NO,String name,String type){
		this.NO=NO;
		this.name=name;
		this.type=type;
	}
	public String getNO(){
		return NO;
	}
	public String getName(){
		return name;
	}
	public String getType(){
		return type;
	}
	
	@Override
	public String getID() {
		
		return NO;
	}

	@Override
	public ResultMessage insert(goodsPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}

	@Override
	public ArrayList<goodsPO> find(String id) {
		ArrayList<goodsPO> list= new ArrayList<>();
		goodsPO resultpo=new goodsPO(null, id, id, 0, 0, 0, 0, id, 0, id, 0);
		list.add(resultpo);
		return list;	
	}

	@Override
	public ResultMessage delete(goodsPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}

	}

	@Override
	public ResultMessage modify(goodsPO po) {
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
	public ArrayList<goodsPO> show() {
		ArrayList<goodsPO> list= new ArrayList<>();
		System.out.println("Show succeed !");
		return list;	
	}

}

	