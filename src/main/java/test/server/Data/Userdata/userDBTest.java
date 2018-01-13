package test.server.Data.Userdata; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.testng.Assert;
import server.Data.Userdata.userDB;
import server.Po.userPO;
import server.RMIservice.RemoteHelper;

import java.util.ArrayList;
import java.util.List;

/**
*@author:pis
*@description:
*@date: 18:49 2018/1/7
*/
public class userDBTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: login(String username, String password) 
* 
*/ 
@Test
public void testLogin() throws Exception {
    new RemoteHelper();
    userDB userDB = new userDB();
    List t  = new ArrayList();
    Assert.assertEquals(t,userDB.login(null,null));
    userPO userPO = (server.Po.userPO) userDB.login("somnus","pis").get(0);
    Assert.assertEquals(userPO.getKeyname(),"somnus");

} 

/** 
* 
* Method: getpasswordByName(String username) 
* 
*/ 
@Test
public void testGetpasswordByName() throws Exception {
    new RemoteHelper();
    userDB userDB = new userDB();
    Assert.assertEquals("pis",userDB.getpasswordByName("somnus"));

} 

/** 
* 
* Method: getJobByName(String username) 
* 
*/ 
@Test
public void testGetJobByName() throws Exception { 
    new RemoteHelper();
    userDB userDB = new userDB();
    Assert.assertEquals("stockman",userDB.getJobByName("somnus"));
}


} 
