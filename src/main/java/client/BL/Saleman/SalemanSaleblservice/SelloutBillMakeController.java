package client.BL.Saleman.SalemanSaleblservice;

import client.BLservice.Saleman.SalemanSaleblservice.SelloutMakeInterface;
import client.RMI.link;
import client.Vo.selloutVO;
import server.Po.selloutPO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonarda on 2017/12/3.
 */
public class SelloutBillMakeController implements SelloutMakeInterface {

    @Override
    public List findselloutBill(String keyword) {
        return null;
    }

    @Override
    public List show() throws RemoteException{
        List<selloutPO> list=link.getRemoteHelper().getSelloutBill().findAll(4);
        List<selloutVO> resultList=new ArrayList<>();
        for(selloutPO po:list){
            selloutVO vo=new selloutVO(
                    po.getKind(),
                    po.getKeyno(),
                    po.getNote(),
                    po.getOper(),
                    po.getIscheck(),
                    po.getIsred(),
                    po.getConsumer(),
                    po.getServer(),
                    po.getBase(),
                    po.getGoodsoutlist(),
                    po.getSumall(),
                    po.getCut(),
                    po.getVoucher(),
                    po.getFinalsum(),
                    po.getIsDraft()
            );
            resultList.add(vo);
        }
        return resultList;
    }

    @Override
    public ResultMessage addselloutBill(selloutVO vo) throws RemoteException {
        return link.getRemoteHelper().getSelloutBill().addObject(vo, 4);
    }

    @Override
    public ResultMessage deleteselloutBill(selloutVO vo) throws RemoteException {
        return link.getRemoteHelper().getSelloutBill().deleteObject(vo, 4);
    }

    @Override
    public ResultMessage modifyselloutBill(selloutVO vo) throws RemoteException {
        return link.getRemoteHelper().getSelloutBill().modifyObject(vo, 4);
    }

    @Override
    public SelloutBill VoTosellout(selloutVO vo) {
        return new SelloutBill(String.valueOf(vo.getKind()),vo.getKeyno(),vo.getNote(),vo.getOper(),String.valueOf(vo.getIscheck()),String.valueOf(vo.getIsred()),vo.getConsumer(),vo.getServer(),vo.getBase(),vo.getGoodsoutlist(),String.valueOf(vo.getSumall()),String.valueOf(vo.getCut()),String.valueOf(vo.getVoucher()),String.valueOf(vo.getFinalsum()),String.valueOf(vo.getIsDraft()));
    }

    @Override
    public selloutVO selloutToVo(SelloutBill sellout) {
        return new selloutVO(
                Double.parseDouble(sellout.getSelloutkinds()),
                sellout.getSelloutID(),
                sellout.getSelloutTip(),
                sellout.getSelloutOperater(),
                Double.parseDouble(sellout.getSelloutisCheck()),
                Double.parseDouble(sellout.getSelloutisred()),
                sellout.getSelloutConsumer(),
                sellout.getSelloutServer(),
                sellout.getSelloutWarehouse(),
                sellout.getSelloutGoodslist(),
                Double.parseDouble(sellout.getSelloutBeforeMoney()),
                Double.parseDouble(sellout.getSelloutDiscount()),
                Double.parseDouble(sellout.getSelloutCard()),
                Double.parseDouble(sellout.getSelloutSum()),
                Double.parseDouble(sellout.getSelloutisDraft())
                );
    }
}
