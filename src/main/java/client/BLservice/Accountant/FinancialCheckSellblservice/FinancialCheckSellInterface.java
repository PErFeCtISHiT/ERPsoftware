package client.BLservice.Accountant.FinancialCheckSellblservice;

import client.BL.Accountant.FinancialCheckSellbl.Sale;
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

public interface FinancialCheckSellInterface {

    /**
     * 搜索销售明细
     *
     * @param detail
     * @return ArrayList<saleVO>
     */
    public List<Sale> search(String detail) throws RemoteException;
    /**
     * 导出销售明细
     *
     * @param type
     * @param address
     * @return
     */
    public ResultMessage getExcel(int type, String address) throws RemoteException, IOException, InterruptedException;
    /**
     * 展示销售明细
     *
     * @return
     * @throws RemoteException
     */
    public ArrayList<Sale> show() throws RemoteException;
    /**
     * PO转换
     *
     * @param po
     * @param goodslist
     * @return
     */
    public Sale PoToSale(salePO po, goodsOutListPO goodslist) throws RemoteException;
    /**
     * 类型转换
     *
     * @param po
     * @return
     */
    public saleVO PoToVo(salePO po) throws RemoteException;

}
