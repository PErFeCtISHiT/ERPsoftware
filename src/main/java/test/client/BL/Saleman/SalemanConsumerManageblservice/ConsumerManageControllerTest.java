package test.client.BL.Saleman.SalemanConsumerManageblservice; 

import client.BL.Saleman.SalemanConsumerManageblservice.ConsumerManageController;
import client.RMI.link;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.RMIservice.RemoteHelper;

/**
*@author:pis
*@description:
*@date: 21:19 2018/1/7
*/
public class ConsumerManageControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 



/** 
* 
* Method: show() 
* 
*/ 
@Test
public void testShow() throws Exception {
    link.linktoServer();
    new RemoteHelper();
    ConsumerManageController consumerManageController = new ConsumerManageController();
    Assert.assertEquals(2,consumerManageController.show().size());
} 


} 
