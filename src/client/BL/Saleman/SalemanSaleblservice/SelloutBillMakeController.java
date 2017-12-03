package client.BL.Saleman.SalemanSaleblservice;

import client.BLservice.Saleman.SalemanSaleblservice.SelloutMakeInterface;
import client.RMI.link;
import client.Vo.selloutVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Leonarda on 2017/12/3.
 */
public class SelloutBillMakeController implements SelloutMakeInterface {

    @Override
    public ArrayList<selloutVO> findselloutBill(String keyword) {
        return null;
    }

    @Override
    public ArrayList<selloutVO> show() {
        return null;
    }

    @Override
    public ResultMessage addselloutBill(selloutVO vo) throws RemoteException {
        return link.getRemoteHelper().getSelloutBill().addObject(vo, 10);
    }

    @Override
    public ResultMessage deleteselloutBill(selloutVO vo) throws RemoteException {
        return link.getRemoteHelper().getSelloutBill().deleteObject(vo, 10);
    }

    @Override
    public ResultMessage modifyselloutBill(selloutVO vo) throws RemoteException {
        return link.getRemoteHelper().getSelloutBill().modifyObject(vo, 10);
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

        return new SelloutBill(keyno,consumer,server,oper,base,goodsoutlist,sumall,cut,voucher,finalsum,note);
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

        return new selloutVO(Long.parseLong(kind),keyno,note,oper,Long.parseLong(ischeck),Long.parseLong(isred),consumer,server,base,goodsoutlist,Long.parseLong(sumall),Long.parseLong(cut),Long.parseLong(voucher),Long.parseLong(finalsum));
    }
}
