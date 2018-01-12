package test.shared; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.testng.Assert;
import shared.checkInTime;

/**
*@author:pis
*@description:
*@date: 18:37 2018/1/7
*/
public class checkInTimeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: checkIsInTime(String beginTime, String endTime, String id) 
* 
*/ 
@Test
public void testCheckIsInTime() throws Exception {
    Assert.assertEquals(java.util.Optional.of(false), java.util.Optional.of(checkInTime.checkIsInTime("20180107", "20180106", "YH-20180108-00008")));
    Assert.assertEquals(java.util.Optional.of(true), java.util.Optional.of(checkInTime.checkIsInTime("20180107", "20180109", "YH-20180108-00008")));
} 


} 
