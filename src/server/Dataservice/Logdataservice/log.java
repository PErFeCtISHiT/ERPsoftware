package server.Dataservice.Logdataservice;

import server.Dataservice.pubservice.pub;
import server.Po.logPO;
import shared.ResultMessage;

import java.sql.Time;
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
    List<String> logstockGlance(String from,String to);
}
