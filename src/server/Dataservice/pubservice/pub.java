package server.Dataservice.pubservice;

import shared.ResultMessage;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 13:55 2017/11/26
 */
public interface pub {
    ResultMessage addObject(Object object,int type) ;
    ResultMessage deleteObject(Object object,int type);
    ResultMessage modifyObject(Object object,int type) ;
}
