package client.BL.Accountant.FinancialCheckSellbl;

import client.BLservice.Accountant.FinancialCheckSellblservice.FinancialCheckSellInterface;
import client.RMI.link;
import client.Vo.goodsOutListVO;
import client.Vo.saleVO;
import server.Po.goodsOutListPO;
import server.Po.salePO;
import shared.ResultMessage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author: yotta
 * @description: controller for 销售明细
 * @date: modify in 18:20 2017/12/24
 */


public class FinancialCheckSellController implements FinancialCheckSellInterface{

    /**
     * 搜索销售明细
     *
     * @param detail
     * @return ArrayList<saleVO>
     */
    @Override
    public ArrayList<Sale> search(String detail) throws RemoteException{
        List<salePO> list = link.getRemoteHelper().getSale().findAll(16);
        ArrayList<Sale> salelist = new ArrayList<Sale>();
        for (int i=0;i<list.size();i++){
            salePO salepo = list.get(i);
            saleVO salevo = PoToVo(salepo);

            String[] str = salevo.getGoodsoutlist().split(",");
            for (int k=0;k<str.length;k++){
                String keyno = str[k];
                List<goodsOutListPO> goodslistpo =link.getRemoteHelper().getgoodsoutList().findbyNO(17,keyno);

                for (int j=0; j<goodslistpo.size();j++){
                    Sale newSale = PoToSale(salepo,goodslistpo.get(j));
                    salelist.add(newSale);
                }
            }
        }
        return salelist;
    }


    /**
     * 导出销售明细
     *
     * @param type
     * @param address
     * @return
     */
    @Override
    public ResultMessage getExcel(int type, String address) throws RemoteException, IOException, InterruptedException {
        return link.getRemoteHelper().getSale().exportToExcel(type,address);
    }

    /**
     * 展示销售明细
     *
     * @return
     * @throws RemoteException
     */

    @Override
    public ArrayList<Sale> show() throws RemoteException{//(List<salePO>)
        List<salePO> list = link.getRemoteHelper().getSale().findAll(16);
        ArrayList<Sale> salelist = new ArrayList<Sale>();
        for (int i=0;i<list.size();i++){
            salePO salepo = list.get(i);
            saleVO salevo = PoToVo(salepo);
            String[] str = salevo.getGoodsoutlist().split(",");
            for (int k=0;k<str.length;k++){
                String keyno = str[k];
                List<goodsOutListPO> goodslistpo =link.getRemoteHelper().getgoodsoutList().findbyNO(17,keyno);
                for (int j=0; j<goodslistpo.size();j++){
                    Sale newSale = PoToSale(salepo,goodslistpo.get(j));
                    salelist.add(newSale);
                }
            }
        }
        return salelist;
    }


    /**
     * PO转换
     *
     * @param po
     * @param goodslist
     * @return
     */

    @Override
    public Sale PoToSale(salePO po, goodsOutListPO goodslist) {
        String saleTime = po.getDateandtime();
        String goodsName =goodslist.getGoodsname();
        String goodsType =goodslist.getKeymodel();
        double Num = goodslist.getNum();
        String goodsNum =String.valueOf(goodslist.getNum());
        double Price = goodslist.getPrice();
        String goodsPrice = String.valueOf(goodslist.getPrice());
        String totalSum = String.valueOf(Num*Price);

        String consumer ="";
        String base =po.getBase();
        String operater= "";
        Sale sale= new Sale(saleTime,goodsName,goodsType,goodsNum,goodsPrice,totalSum,consumer,base,operater);
        return sale;
    }

    /**
     * 类型转换
     *
     * @param po
     * @return
     */
    public saleVO PoToVo(salePO po) {
        saleVO sale = new saleVO(po.getKeyno(),po.getKind(),po.getLev(),po.getAccoun(),
                po.getBase(),po.getGoodsinlist(),po.getGoodsoutlist(),po.getPresum(),po.getCut(),
                po.getVoucher(),po.getSumall(),po.getDateandtime());


        return sale;
    }



}
