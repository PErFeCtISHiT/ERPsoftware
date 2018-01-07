package stub;

import java.util.ArrayList;

import dataservice_stub.consumerdataservice_stub;
import logicservice.Client;

import dataservice.ResultMessage;
import dataservice.consumerdataservice;
import po.consumerPO;

public class Client_Stub implements Client{

	@Override
	public ResultMessage addClient(consumerPO consumer) {
		String no=consumer.getNO();
		int kind=consumer.getKind();
		int level=consumer.getLevel();
		String name=consumer.getName();
		String tel=consumer.getTel();
		String mail=consumer.getMail();
		String email=consumer.getEmail();
		double capacity=consumer.getCapacity();
		double receive=consumer.getReceive();
		double pay=consumer.getPay();
		String server=consumer.getServer();
		String account=consumer.getAccout();
		consumerdataservice consumerdata=new consumerdataservice_stub(no,kind,level,name,tel,mail,email,capacity,receive,pay,server,account);
		return consumerdata.insert(consumer);
	}

	@Override
	public ArrayList<consumerPO> Search(String keyword) {
		return null;
	}

	@Override
	public ResultMessage deleteClient(consumerPO consumer) {
		String no=consumer.getNO();
		int kind=consumer.getKind();
		int level=consumer.getLevel();
		String name=consumer.getName();
		String tel=consumer.getTel();
		String mail=consumer.getMail();
		String email=consumer.getEmail();
		double capacity=consumer.getCapacity();
		double receive=consumer.getReceive();
		double pay=consumer.getPay();
		String server=consumer.getServer();
		String account=consumer.getAccout();
		consumerdataservice consumerdata=new consumerdataservice_stub(no,kind,level,name,tel,mail,email,capacity,receive,pay,server,account);
		return consumerdata.delete(consumer);
	}

	@Override
	public ResultMessage modifyClient(consumerPO consumer) {
		String no=consumer.getNO();
		int kind=consumer.getKind();
		int level=consumer.getLevel();
		String name=consumer.getName();
		String tel=consumer.getTel();
		String mail=consumer.getMail();
		String email=consumer.getEmail();
		double capacity=consumer.getCapacity();
		double receive=consumer.getReceive();
		double pay=consumer.getPay();
		String server=consumer.getServer();
		String account=consumer.getAccout();
		consumerdataservice consumerdata=new consumerdataservice_stub(no,kind,level,name,tel,mail,email,capacity,receive,pay,server,account);
		return consumerdata.modify(consumer);
	}
	
}
