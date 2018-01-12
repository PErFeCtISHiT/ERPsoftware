package test.server.Data.Goodsdata; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.Data.Goodsdata.GoodsKindsDB;
import server.Po.goodskindsPO;
import server.RMIservice.RemoteHelper;

/**
*@author:pis
*@description:
*@date: 19:39 2018/1/7
*/
public class GoodsKindsDBTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: goodsKindsFindByKeyWord(String keyword) 
* 
*/ 
@Test
public void testGoodsKindsFindByKeyWord() throws Exception {
    new RemoteHelper();
    GoodsKindsDB goodsKindsDB = new GoodsKindsDB();
    goodskindsPO goodskindsPO = (server.Po.goodskindsPO) goodsKindsDB.goodsKindsFindByKeyWord("A").get(0);
    Assert.assertEquals("吊灯A",goodskindsPO.getKeyname());
} 


} 
