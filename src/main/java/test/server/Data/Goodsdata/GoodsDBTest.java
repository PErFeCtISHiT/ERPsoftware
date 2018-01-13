package test.server.Data.Goodsdata; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.Data.Goodsdata.GoodsDB;
import server.Data.Goodsdata.GoodsKindsDB;
import server.Po.goodsPO;
import server.Po.goodskindsPO;
import server.RMIservice.RemoteHelper;

/**
*@author:pis
*@description:
*@date: 19:52 2018/1/7
*/
public class GoodsDBTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: goodsFindGoodsByKeyword(String keyword) 
* 
*/ 
@Test
public void testGoodsFindGoodsByKeyword() throws Exception {
    new RemoteHelper();
    GoodsDB goodsKindsDB = new GoodsDB();
    goodsPO goodsPO = (server.Po.goodsPO) goodsKindsDB.goodsFindGoodsByKeyword("f").get(0);
    Assert.assertEquals("yyf",goodsPO.getKeyname());
} 

/** 
* 
* Method: goodsFindByKind(String kind) 
* 
*/ 
@Test
public void testGoodsFindByKind() throws Exception {
    new RemoteHelper();
    GoodsDB goodsKindsDB = new GoodsDB();
    goodsPO goodsPO = (server.Po.goodsPO) goodsKindsDB.goodsFindByKind("地灯").get(0);
    Assert.assertEquals("Nico",goodsPO.getKeyname());
} 


} 
