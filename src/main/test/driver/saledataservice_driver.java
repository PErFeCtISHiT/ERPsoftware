package driver;

import dataservice.saledataservice;
import po.salePO;

public class saledataservice_driver {

	public void driver(saledataservice saledata){
		  salePO po = new salePO(null, 0, 0, null, null, null, null, 0, 0, 0, 0);
		  String id=null;
		  
		  saledata.init();
		  System.out.println("Init succeed !");
		  saledata.getID();
		  System.out.println("Get ID succeed !");
		  saledata.insert(po);
		  System.out.println("Insert succeed !");
		  saledata.delete(po);
		  System.out.println("Delete succeed !");
		  saledata.find(id);
		  System.out.println("Find succeed !");
		  saledata.modify(po);
		  System.out.println("Modify succeed !");
		  saledata.end();
		  System.out.println("End succeed !");
	}
}
