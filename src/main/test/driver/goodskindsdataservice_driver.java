package driver;

import dataservice.goodsdataservice;
import dataservice.goodskindsdataservice;
import po.goodskindsPO;

public class goodskindsdataservice_driver {


	  public void driver(goodskindsdataservice goodskindsdata) {
		  goodskindsPO po = new goodskindsPO(null, null, 0);
		  String id=po.getNO();
		  
		  goodskindsdata.init();
		  System.out.println("Init succeed !");
		  goodskindsdata.getID();
		  System.out.println("Get ID succeed !");
		  goodskindsdata.insert(po);
		  System.out.println("Insert succeed !");
		  goodskindsdata.delete(po);
		  System.out.println("Delete succeed !");
		  goodskindsdata.modify(po);
		  System.out.println("Modify succeed !");
		  goodskindsdata.end();
		  System.out.println("End succeed !");
		  
	    }
}
