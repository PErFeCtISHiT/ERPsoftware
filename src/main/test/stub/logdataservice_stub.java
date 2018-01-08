package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import dataservice.logdataservice;
import po.goodsPO;
import po.logPO;

public class logdataservice_stub implements logdataservice{

	String NO;
	String date;
	String job;
	String userNO;
	String billNO;
	String operaterNO;
	String note;
	
	public logdataservice_stub(String n1,String d,String j,String u,String b,String o,String n2){
		NO = n1;
		date = d;
		job = j;
		userNO = u;
		billNO = b;
		operaterNO = o;
		note = n2;
	}
	public String getNO(){
		return NO;
	}	
	public String getDate(){
		return date;
	}	
	public String getJob(){
		return job;
	}	
	public String getUserNO(){
		return userNO;
	}
	public String getBillNO(){
		return billNO;
	}
	public String getOperaterNO(){
		return operaterNO;
	}
	public String getNote(){
		return note;
	}
	
	
	
	
	@Override
	public String getID() {
		
		return NO;
	}

	@Override
	public ResultMessage insert(logPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}

	@Override
	public ArrayList<logPO> find(String id) {
		ArrayList<logPO> list= new ArrayList<>();
		logPO resultpo=new logPO(NO,date,job,userNO,billNO,operaterNO,note);
		list.add(resultpo);
		return list;	
	}

	@Override
	public ResultMessage delete(logPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}

	@Override
	public ResultMessage modify(logPO po) {
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
	public ArrayList<logPO> show() {
		ArrayList<logPO> list= new ArrayList<>();
		return list;
	}

	

}