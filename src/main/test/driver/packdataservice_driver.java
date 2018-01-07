package driver;

import dataservice.packdataservice;
import po.packPO;

public class packdataservice_driver {

	public void driver(packdataservice packdata){
		  packPO po = new packPO(null, 0);
		  String id=null;
		  
		  packdata.init();
		  System.out.println("Init succeed !");
		  packdata.getID();
		  System.out.println("Get ID succeed !");
		  packdata.insert(po);
		  System.out.println("Insert succeed !");
		  packdata.delete(po);
		  System.out.println("Delete succeed !");
		  packdata.find(id);
		  System.out.println("Find succeed !");
		  packdata.modify(po);
		  System.out.println("Modify succeed !");
		  packdata.end();
		  System.out.println("End succeed !");
	}
}