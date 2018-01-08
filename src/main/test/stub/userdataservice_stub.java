package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import dataservice.userdataservice;
import po.goodsPO;
import po.userPO;

public class userdataservice_stub implements userdataservice{

	String NO;
	String job;
	int level;
	String name;
	String tel;
	String mail;
	String email;
	String add;
	double year;
	double password;
	public userdataservice_stub(String n1,String j,int l,String n2,String t,String m,String e,String a,double y,double p){
		NO = n1;
		job = j;
		level = l;
		name = n2;
		tel = t;
		mail = m;
		email = e;
		add = a;
		year = y;
		password = p;
	}
	public String getNO(){
		return NO;
	}
	public String getJob(){
		return job;
	}
	public int getLevel(){
		return level;
	}
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
	public String getMail(){
		return mail;
	}
	public String getEmail(){
		return email;
	}
	public String getAdd(){
		return add;
	}
	public double getYear(){
		return year;
	}
	public double getPassword(){
		return password;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage insert(userPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	@Override
	public ArrayList<userPO> find(String id) {
		ArrayList<userPO> list= new ArrayList<>();
		userPO resultpo=new userPO(id, id, level, id, id, id, id, id, password, password);
		list.add(resultpo);
		return list;
	}
	@Override
	public ResultMessage delete(userPO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	@Override
	public ResultMessage modify(userPO po) {
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
	public ArrayList<userPO> show() {
		ArrayList<userPO> list= new ArrayList<>();	
		return list;
	}
}
