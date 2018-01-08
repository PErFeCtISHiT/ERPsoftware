package stub;

import java.util.ArrayList;

import dataservice.ResultMessage;
import dataservice.saledataservice;
import po.goodsOutListPO;
import po.goodsPO;
import po.salePO;

public class saledataservice_stub implements saledataservice{

	String NO;
	int kind;
	int level;
	String account;
	String base;
	goodsOutListPO goodslist;
	goodsOutListPO goodsoutlist;
	double sum;
	double cut;
	double voucher;
	double finalsum;
	public saledataservice_stub(String n1,int k,int l,String a,String b,goodsOutListPO g1,goodsOutListPO g2,double s,double c,double v,double f){
		NO = n1;
		kind = k;
		level = l;
		account = a;
		base = b;
		goodslist = g1;
		goodsoutlist = g2;
		sum = s;
		cut = c;
		voucher = v;
		finalsum = f;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage insert(salePO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	
	
	
	@Override
	public ArrayList<salePO> find(String id) {
		ArrayList<salePO> list= new ArrayList<>();
		salePO resultpo=new salePO(id, kind, kind, id, id, goodslist, goodslist, cut, cut, cut, cut);
		list.add(resultpo);
		return list;	
	}
	@Override
	public ResultMessage delete(salePO po) {
		if (po!=null){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Fail;
		}	
	}
	@Override
	public ResultMessage modify(salePO po) {
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
	public ArrayList<salePO> show() {
		ArrayList<salePO> list= new ArrayList<>();
		return list;	
	}
}
