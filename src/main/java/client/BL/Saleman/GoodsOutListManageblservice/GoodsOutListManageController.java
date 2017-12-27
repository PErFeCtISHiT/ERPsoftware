package client.BL.Saleman.GoodsOutListManageblservice;

import client.BLservice.Saleman.GoodsOutListManageblservice.GoodsOutListManageblservice;
import client.RMI.link;
import client.Vo.goodsOutListVO;
import shared.ResultMessage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/14.
 */
public class GoodsOutListManageController implements GoodsOutListManageblservice{
    @Override
    public List findAll() throws RemoteException {
        return link.getRemoteHelper().getgoodsoutList().findAll(17);
    }

    @Override
    public List findbyNo(String no) throws RemoteException {
        return link.getRemoteHelper().getgoodsoutList().findbyNO(17,no);
    }

    @Override
    public ResultMessage addObject(goodsOutListVO vo) throws RemoteException {
        return link.getRemoteHelper().getgoodsoutList().addObject(vo,17);
    }

    @Override
    public ResultMessage deleteObject(goodsOutListVO vo) throws RemoteException {
        return link.getRemoteHelper().getgoodsoutList().deleteObject(vo,17);
    }

    @Override
    public ResultMessage exToExcel(String path) throws IOException, InterruptedException {
        return link.getRemoteHelper().getgoodsoutList().exportToExcel(17,path);
    }

    @Override
    public ResultMessage modifyObject(goodsOutListVO vo) throws RemoteException {
        return link.getRemoteHelper().getgoodsoutList().modifyObject(vo,17);
    }

}
