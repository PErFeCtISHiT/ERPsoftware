package test.shared; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.testng.Assert;
import shared.praseDouble;

/**
*@author:pis
*@description:
*@date: 18:33 2018/1/17
*/
public class praseDoubleTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: prase(String str) 
* 
*/ 
@Test
public void testPrase() throws Exception {
    Assert.assertEquals(0.0, praseDouble.prase("abc"));
    Assert.assertEquals(19.9,praseDouble.prase("19.9"));
} 


} 
