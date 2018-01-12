package test.client.BL.Stockman.StockmanStockGlancebl; 

import client.BL.Stockman.StockmanStockGlancebl.stockGlanceController;
import client.RMI.link;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.RMIservice.RemoteHelper;

import java.time.LocalDate;

/**
*@author:pis
*@description:
*@date: 21:24 2018/1/7
*/
public class stockGlanceControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: stockglance(LocalDate from, LocalDate to) 
* 
*/ 
@Test
public void testStockglance() throws Exception {
    link.linktoServer();
    new RemoteHelper();
    stockGlanceController stockGlanceController = new stockGlanceController();
    LocalDate localDate = null;
    int size = stockGlanceController.stockglance(localDate,localDate).size();
    Assert.assertEquals(0,size);

} 



} 
