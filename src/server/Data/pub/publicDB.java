package server.Data.pub;

import server.Data.tools.hibtools;
import server.Dataservice.pubservice.pub;
import shared.ResultMessage;
import shared.copyclass;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 13:53 2017/11/26
 */
public class publicDB implements pub {
    hibtools hib = new hibtools();
    Object obj = new Object();

    @Override
    public ResultMessage addObject(Object object) {
        copyclass.copy(object,obj);
        return hib.Save(obj);
    }

    @Override
    public ResultMessage deleteObject(Object object) {
        copyclass.copy(object,obj);
        return hib.Delete(obj);
    }

    @Override
    public ResultMessage modifyObject(Object object) {
        copyclass.copy(object,obj);
        return hib.Modify(obj);
    }
}
