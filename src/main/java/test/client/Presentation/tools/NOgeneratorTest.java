package test.client.Presentation.tools; 

import client.Presentation.tools.NOgenerator;
import client.RMI.RemoteHelper;
import client.RMI.link;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.testng.Assert;

/**
*@author:pis
*@description:
*@date: 20:36 2018/1/7
*/
public class NOgeneratorTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: generate(int type) 
* 
*/ 
@Test
public void testGenerate() throws Exception {
    link.linktoServer();
    new server.RMIservice.RemoteHelper();
    Assert.assertEquals("20180112-00013",NOgenerator.generate(0));
} 




} 
