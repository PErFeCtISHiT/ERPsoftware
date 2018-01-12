package test.client.BL.LodinblService; 

import client.BL.LodinblService.LoginController;
import client.RMI.link;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.Po.userPO;
import server.RMIservice.RemoteHelper;
import shared.ResultMessage;

/**
*@author:pis
*@description:
*@date: 21:04 2018/1/7
*/
public class LoginControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


/** 
* 
* Method: addUser(userPO user, int type) 
* 
*/ 
@Test
public void testAddUser() throws Exception {
    link.linktoServer();
    new RemoteHelper();
    LoginController loginController = new LoginController();
    userPO userPO = new userPO();
    Assert.assertEquals(loginController.addUser(userPO,15), ResultMessage.Failure);
} 


} 
