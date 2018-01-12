package test.client.BL.Logbl; 

import client.BL.Logbl.LogController;
import client.RMI.link;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.testng.Assert;
import server.RMIservice.RemoteHelper;

/**
*@author:pis
*@description:
*@date: 21:09 2018/1/7
*/
public class LogControllerTest { 

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
    LogController logController = new LogController();
    Assert.assertEquals(logController.show().size(),89);
} 


} 
