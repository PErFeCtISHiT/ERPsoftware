package stub;

import server.Dataservice.Codataservice.Coaccount;
import shared.ResultMessage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class codataservice_stub implements Coaccount{
	private String account;
	private double money;
	public codataservice_stub(String a,double m){
		account = a;
		money = m;
	}
	public String getAccount(){
		return account;
	}
	public double getMoney(){
		return money;
	}


	@Override
	public List findAccount(String keyword) throws RemoteException {
        return null;
	}

	@Override
	public ResultMessage addObject(Object object, int type) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteObject(Object object, int type) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage modifyObject(Object object, int type) throws RemoteException {
		return null;
	}

	@Override
	public List findAll(int type) throws RemoteException {
		return null;
	}

	@Override
	public List findbyNO(int type, String no) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage exportToExcel(int type, String path) throws RemoteException, IOException, InterruptedException {
		return null;
	}
}
