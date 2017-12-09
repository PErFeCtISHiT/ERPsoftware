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
    public List<selloutPO> findselloutBill(String keyword) {
        return null;
    }

    @Override
    public List<selloutPO> show() throws RemoteException{

        return link.getRemoteHelper().getSelloutBill().findAll(4);
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
        String kind=String.valueOf(vo.getKind());
        String keyno=vo.getKeyno();
        String note=vo.getNote();
        String oper=vo.getOper();
        String ischeck=String.valueOf(vo.getIscheck());
        String isred=String.valueOf(vo.getIsred());
        String consumer=vo.getConsumer();
        String server=vo.getServer();
        String base=vo.getBase();
        String goodsoutlist=vo.getGoodsoutlist();
        String sumall=String.valueOf(vo.getSumall());
        String cut=String.valueOf(vo.getCut());
        String voucher=String.valueOf(vo.getVoucher());
        String finalsum=String.valueOf(vo.getFinalsum());

        return new SelloutBill(keyno,consumer,server,oper,base,goodsoutlist,sumall,cut,voucher,finalsum,note,kind);
    }

    @Override
    public selloutVO selloutToVo(SelloutBill sellout) {
        String kind="0";
        String keyno=sellout.getSelloutID();
        String note=sellout.getSelloutTip();
        String oper=sellout.getSelloutOperater();
        String ischeck="0";
        String isred="1";
        String consumer=sellout.getSelloutConsumer();
        String server=sellout.getSelloutServer();
        String base=sellout.getSelloutWarehouse();
        String goodsoutlist=sellout.getSelloutGoodslist();
        String sumall=sellout.getSelloutBeforeMoney();
        String cut=sellout.getSelloutDiscount();
        String voucher=sellout.getSelloutCard();
        String finalsum=sellout.getSelloutSum();

        return new selloutVO(Double.parseDouble(kind),keyno,note,oper,Double.parseDouble(ischeck),Double.parseDouble(isred),consumer,server,base,goodsoutlist,Double.parseDouble(sumall),Double.parseDouble(cut),Double.parseDouble(voucher),Double.parseDouble(finalsum));
    }
}
