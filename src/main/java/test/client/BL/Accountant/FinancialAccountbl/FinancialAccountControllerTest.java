package test.client.BL.Accountant.FinancialAccountbl; 

import client.BL.Accountant.FinancialAccountbl.FinancialAccountController;
import client.RMI.link;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.Po.coPO;
import server.RMIservice.RemoteHelper;

/**
*@author:pis
*@description:
*@date: 20:48 2018/1/7
*/
public class FinancialAccountControllerTest { 

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
    FinancialAccountController financialAccountController = new FinancialAccountController();
    coPO coPO = financialAccountController.show().get(0);
    Assert.assertEquals("工商银行1",coPO.getKeyname());
} 


} 
