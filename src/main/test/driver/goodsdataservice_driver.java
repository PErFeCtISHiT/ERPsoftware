package driver;
import dataservice.goodsdataservice;
import po.goodsPO;
public class goodsdataservice_driver {

  public void driver(goodsdataservice goodsdata) {
	  goodsPO po = new goodsPO(null, null, null, 0, 0, 0, 0, null, 0, null, 0);
	  String id=po.getNO();
	  
	  goodsdata.init();
	  System.out.println("Init succeed !");
	  goodsdata.getID();
	  System.out.println("Get ID succeed !");
	  goodsdata.insert(po);
	  System.out.println("Insert succeed !");
	  goodsdata.delete(po);
	  System.out.println("Delete succeed !");
	  goodsdata.find(id);
	  System.out.println("Find succeed !");
	  goodsdata.modify(po);
	  System.out.println("Modify succeed !");
	  goodsdata.end();
	  System.out.println("End succeed !");
	  
    }
}
