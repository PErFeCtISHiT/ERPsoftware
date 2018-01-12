package test.server.Data.tools; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.Data.tools.hibtools;
import server.Po.userPO;
import server.hibernateEntities.UseEntity;
import shared.ResultMessage;

/**
*@author:pis
*@description:
*@date: 19:18 2018/1/7
*/
public class hibtoolsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: Save(Object o) 
* 
*/ 
@Test
public void testSave() throws Exception {
    hibtools hibtools = new hibtools();
    UseEntity useEntity = new UseEntity();
    Assert.assertEquals(ResultMessage.Failure,hibtools.Save(useEntity));
} 

/** 
* 
* Method: Delete(Object o) 
* 
*/ 
@Test
public void testDelete() throws Exception {
    hibtools hibtools = new hibtools();
    UseEntity useEntity = new UseEntity();
    Assert.assertEquals(ResultMessage.Success,hibtools.Delete(useEntity));
} 

/** 
* 
* Method: Modify(Object o) 
* 
*/ 
@Test
public void testModify() throws Exception {
    hibtools hibtools = new hibtools();
    UseEntity useEntity = new UseEntity();
    Assert.assertEquals(ResultMessage.Failure,hibtools.Modify(useEntity));
} 


} 
