package client.BLservice.Saleman.GoodsOutListManageblservice;

import client.RMI.link;
import shared.ResultMessage;
import client.Vo.goodsOutListVO;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/14.
 */
public interface GoodsOutListManageblservice {
    List findbyNo(String no) throws RemoteException;
    ResultMessage addObject(goodsOutListVO vo) throws RemoteException;
    ResultMessage deleteObject(goodsOutListVO vo) throws RemoteException;
    ResultMessage exToExcel(String path) throws IOException;
    List findAll() throws RemoteException;
    ResultMessage modifyObject(goodsOutListVO vo) throws RemoteException;
}
