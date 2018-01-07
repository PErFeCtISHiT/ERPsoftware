package server.Dataservice.Logdataservice;

import server.Dataservice.Pubservice.pub;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 13:12 2017/11/26
 */

public interface log extends pub {

    /**
    *@author:pis
    *@description: 日期样例：2008-01-01 00:00:00  小时值必须介于 1 和 12 之间
    *@date: 14:16 2017/11/26
    */
    List logstockGlance(String from,String to)throws RemoteException;
    List showbillDetail(String from,String to, String name,String consumer,String operator,String base)throws RemoteException;

}
