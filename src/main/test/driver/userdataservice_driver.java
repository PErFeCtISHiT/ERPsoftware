package driver;


import dataservice.userdataservice;
import po.userPO;

public class userdataservice_driver {

	public void driver(userdataservice userdata){
		  userPO po = new userPO("","",0,"","","","","",0,0);
		  String id=null;
		  
		  userdata.init();
		  System.out.println("Init succeed !");
		  userdata.getID();
		  System.out.println("Get ID succeed !");
		  userdata.insert(po);
		  System.out.println("Insert succeed !");
		  userdata.delete(po);
		  System.out.println("Delete succeed !");
		  userdata.find(id);
		  System.out.println("Find succeed !");
		  userdata.modify(po);
		  System.out.println("Modify succeed !");
		  userdata.end();
		  System.out.println("End succeed !");
	}
}