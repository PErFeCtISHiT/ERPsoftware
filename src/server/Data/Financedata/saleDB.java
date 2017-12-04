package server.Data.Financedata;

import client.Vo.saleVO;
import server.Data.pub.publicDB;
import server.Data.tools.hibtools;
import server.Dataservice.Financedataservice.sale;
import server.Dataservice.pubservice.pub;
import server.Po.goodsOutListPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 21:25 2017/12/3
 */
public class saleDB extends publicDB implements sale {
    publicDB publicDB = new publicDB();
    public List findbySaleVO(saleVO saleVO) throws RemoteException {
        String[] str;
        List<goodsOutListPO> ret = new ArrayList<>();
        if(saleVO.getKind() == 0){//入库类sale
            str = saleVO.getGoodsoutlist().split(",");

        }
        else//出库类sale
            str = saleVO.getGoodsoutlist().split(",");
        for(String s : str){
            List temp = publicDB.findbyNO(17,s);
            if(!temp.isEmpty())
                ret.add((goodsOutListPO) temp.get(0));
        }
        return ret;
    }
}
