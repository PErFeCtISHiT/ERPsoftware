package client.BL.Accountant.FinancialCheckSellbl;

import client.BLservice.Accountant.FinancialCheckSellblservice.FinancialCheckSellInterface;
import client.RMI.link;
import client.Vo.goodsOutListVO;
import client.Vo.saleVO;
import server.Po.goodsOutListPO;
import server.Po.salePO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class FinancialCheckSellController implements FinancialCheckSellInterface{

    /**
     *
     * @param detail
     * @return ArrayList<saleVO>
     */
    @Override
    public ArrayList<Sale> search(String detail) throws RemoteException{
        List<salePO> list = link.getRemoteHelper().getSale().findAll(16);
        ArrayList<Sale> salelist = new ArrayList<Sale>();
        //System.out.println(1);
        for (int i=0;i<list.size();i++){
            salePO salepo = list.get(i);
            saleVO salevo = PoToVo(salepo);
            //System.out.println(2);
            String[] str = salevo.getGoodsoutlist().split(",");
            //System.out.println("The size is "+str.length);
            for (int k=0;k<str.length;k++){
                String keyno = str[k];
                List<goodsOutListPO> goodslistpo =link.getRemoteHelper().getgoodsoutList().findbyNO(17,keyno);
                //System.out.println(3);
                //System.out.println(goodslistpo.size());
                for (int j=0; j<goodslistpo.size();j++){
                    //System.out.println("Test");
                    Sale newSale = PoToSale(salepo,goodslistpo.get(j));
                    //System.out.println(newSale.saleTime);
                    salelist.add(newSale);
                }
            }
        }
        return salelist;
    }


    /**
     *
     * @param address
     * @return boolean
     */
    @Override
    public boolean getExcel(String address) {
        return false;
    }

    @Override
    public ArrayList<Sale> show() throws RemoteException{//(List<salePO>)
        List<salePO> list = link.getRemoteHelper().getSale().findAll(16);
        ArrayList<Sale> salelist = new ArrayList<Sale>();
        //System.out.println(1);
        for (int i=0;i<list.size();i++){
            salePO salepo = list.get(i);
            saleVO salevo = PoToVo(salepo);
            //System.out.println(2);
            String[] str = salevo.getGoodsoutlist().split(",");
            //System.out.println("The size is "+str.length);
            for (int k=0;k<str.length;k++){
                String keyno = str[k];
                List<goodsOutListPO> goodslistpo =link.getRemoteHelper().getgoodsoutList().findbyNO(17,keyno);
                //System.out.println(3);
                //System.out.println(goodslistpo.size());
                for (int j=0; j<goodslistpo.size();j++){
                    //System.out.println("Test");
                    Sale newSale = PoToSale(salepo,goodslistpo.get(j));
                    //System.out.println(newSale.saleTime);
                    salelist.add(newSale);
                }
            }
        }
        return salelist;
    }


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

        //System.out.println(sale.saleTime);

        return sale;
    }


    public saleVO PoToVo(salePO po) {
        saleVO sale = new saleVO(po.getKeyno(),po.getKind(),po.getLev(),po.getAccoun(),
                po.getBase(),po.getGoodsinlist(),po.getGoodsoutlist(),po.getPresum(),po.getCut(),
                po.getVoucher(),po.getSumall(),po.getDateandtime());


        return sale;
    }



}
