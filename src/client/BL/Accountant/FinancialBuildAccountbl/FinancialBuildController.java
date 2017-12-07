package client.BL.Accountant.FinancialBuildAccountbl;

import client.BLservice.Accountant.FinancialBuildAccountblservice.FinancialBuildAccountInterface;
import client.Vo.coVO;
import client.Vo.consumerVO;
import client.Vo.goodsVO;
import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FinancialBuildController implements FinancialBuildAccountInterface{

    /**
     *
     * @return ResultMessage
     */
    @Override
    public void accountbuild() throws RemoteException{

    }

    /**
     *
     * @return ResultMessage
     */

    @Override
    public void getPast(String year) throws RemoteException{

    }


}


/**
 * 银行账户信息——>界面可以显示
 * 客户信息——>界面可以显示
 * 商品信息——>界面可以显示
 *
 *当前用户（郭丰睿）要早点干呀！！！
 *
 * 期初建账类
 * 包含
 * 商品信息
 * 客户信息
 * 银行账户信息
 * 当前用户信息
 *
 *
 * 方法包含：
 * 提交期初建账类
 *
 *
 *
 */
