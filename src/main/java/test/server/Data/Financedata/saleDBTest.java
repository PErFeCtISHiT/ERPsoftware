package test.server.Data.Financedata;

import client.Vo.saleVO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.Data.Financedata.saleDB;

/**
 * @author:pis
 * @description:
 * @date: 20:06 2018/1/7
 */
public class saleDBTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findbySaleVO(saleVO saleVO)
     */
    @Test
    public void testFindbySaleVO() throws Exception {
        saleDB saleDB = new saleDB();
        saleVO saleVO = new saleVO();
        Assert.assertEquals(null, null);
    }

    /**
     * Method: search(String detail)
     */
    @Test
    public void testSearch() throws Exception {
        saleDB saleDB = new saleDB();
        saleVO saleVO = new saleVO();
        Assert.assertEquals(null, null);
    }


} 
