package test.server.Data.Financedata; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import server.Data.Financedata.accountInitDB;
import server.RMIservice.RemoteHelper;

/**
*@author:pis
*@description:
*@date: 19:59 2018/1/7
*/
public class accountInitDBTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getPastAccount(String year)
     */
    @Test
    public void testGetPastAccount() throws Exception {
        new RemoteHelper();
        accountInitDB accountInitDB = new accountInitDB();
        Assert.assertEquals(0, accountInitDB.getPastAccount("1000").size());
    }

    /**
     * Method: getPastConsumer(String year)
     */
    @Test
    public void testGetPastConsumer() throws Exception {
        new RemoteHelper();
        accountInitDB accountInitDB = new accountInitDB();
        Assert.assertEquals(0, accountInitDB.getPastConsumer("1000").size());
    }

    /**
     * Method: getPastGoods(String year)
     */
    @Test
    public void testGetPastGoods() throws Exception {
        new RemoteHelper();
        accountInitDB accountInitDB = new accountInitDB();
        Assert.assertEquals(0, accountInitDB.getPastGoods("1000").size());
    }
}


