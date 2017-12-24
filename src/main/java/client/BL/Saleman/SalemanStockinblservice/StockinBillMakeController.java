package client.BL.Saleman.SalemanStockinblservice;

import client.BLservice.Saleman.SalemanStockinblservice.StockinMakeInterface;
import client.RMI.link;
import client.Vo.buyinVO;
import shared.ResultMessage;
import server.Po.buyinPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/3.
 */
public class StockinBillMakeController implements StockinMakeInterface {
    @Override
    public List findBuyinBill(String keyword) {

        return null;
    }

    @Override
    public List show() throws RemoteException {
        List<buyinPO> list=link.getRemoteHelper().getBuyinBill().findAll(3);
        List<buyinVO> resultList=new ArrayList<>();
        for(buyinPO po:list){
            buyinVO vo=new buyinVO(
                    po.getKind(),
                    po.getKeyno(),
                    po.getNote(),
                    po.getOper(),
                    po.getIscheck(),
                    po.getIsred(),
                    po.getProvider(),
                    po.getBase(),
                    po.getGoodsoutlist(),
                    po.getSumall(),
                    po.getIsDraft()
            );
            resultList.add(vo);
        }
        return resultList;
    }

    @Override
    public ResultMessage addBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().addObject(vo,3);//???????????????
    }

    @Override
    public ResultMessage deleteBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().deleteObject(vo,3);
    }

    @Override
    public ResultMessage modifyBuyinBill(buyinVO vo) throws RemoteException {
        return link.getRemoteHelper().getBuyinBill().modifyObject(vo,3);
    }

    @Override
    public buyinVO billtovo(StockinBill bill) {
        return new buyinVO(Double.parseDouble(bill.getBuyinKind()),bill.getBuyinID(),bill.getBuyinTips(),bill.getBuyinOperater(),Double.parseDouble(bill.getBuyinisCheck()),Double.parseDouble(bill.getBuyinisRed()),bill.getBuyinOffer(),bill.getBuyinStoreHouse(),bill.getBuyinGoodsList(),Double.parseDouble(bill.getBuyinSum()),Double.parseDouble(bill.getBuyinisDraft()));
    }

    @Override
    public StockinBill votoBill(buyinVO vo) {
        return new StockinBill(String.valueOf(vo.getKind()),vo.getKeyno(),vo.getNote(),vo.getOper(), String.valueOf(vo.getIscheck()),String.valueOf(vo.getIsred()),vo.getProvider(),vo.getBase(),vo.getGoodsoutlist(),String.valueOf(vo.getSumall()),String.valueOf(vo.getIsDraft()));
    }

}
