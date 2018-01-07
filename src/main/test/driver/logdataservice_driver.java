package driver;

import dataservice.logdataservice;
import po.logPO;

public class logdataservice_driver {

	public void driver(logdataservice logdata){
		  logPO po = new logPO("","","","","","","");
		  String id=null;
		  
		  logdata.init();
		  System.out.println("Init succeed !");
		  logdata.getID();
		  System.out.println("Get ID succeed !");
		  logdata.insert(po);
		  System.out.println("Insert succeed !");
		  logdata.delete(po);
		  System.out.println("Delete succeed !");
		  logdata.find(id);
		  System.out.println("Find succeed !");
		  logdata.modify(po);
		  System.out.println("Modify succeed !");
		  logdata.end();
		  System.out.println("End succeed !");
	}
}