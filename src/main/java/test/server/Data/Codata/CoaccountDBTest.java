package test.server.Data.Codata; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.Data.Codata.CoaccountDB;
import server.Po.coPO;
import server.RMIservice.RemoteHelper;

/**
*@author:pis
*@description:
*@date: 20:24 2018/1/7
*/
public class CoaccountDBTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findAccount(String keyword) 
* 
*/ 
@Test
public void testFindAccount() throws Exception {
    new RemoteHelper();
    CoaccountDB coaccountDB = new CoaccountDB();
    coPO coPO = (server.Po.coPO) coaccountDB.findAccount("招商").get(0);
    Assert.assertEquals("招商银行",coPO.getKeyname());
} 


} 
