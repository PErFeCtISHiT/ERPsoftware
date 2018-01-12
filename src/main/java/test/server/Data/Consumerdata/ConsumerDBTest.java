package test.server.Data.Consumerdata; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.testng.Assert;
import server.Data.Consumerdata.ConsumerDB;
import server.Po.consumerPO;
import server.RMIservice.RemoteHelper;

/**
*@author:pis
*@description:
*@date: 20:18 2018/1/7
*/
public class ConsumerDBTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findConsumer(String keyword) 
* 
*/ 
@Test
public void testFindConsumer() throws Exception { 
    new RemoteHelper();
    ConsumerDB consumerDB = new ConsumerDB();
    consumerPO consumerPO = (server.Po.consumerPO) consumerDB.findConsumer("22").get(0);
    Assert.assertEquals("consumer3",consumerPO.getKeyno());

} 


} 
