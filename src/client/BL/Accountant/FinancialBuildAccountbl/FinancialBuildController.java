package client.BL.Accountant.FinancialBuildAccountbl;

import client.BLservice.Accountant.FinancialBuildAccountblservice.FinancialBuildAccountInterface;
import client.Vo.coVO;
import client.Vo.consumerVO;
import client.Vo.goodsVO;
import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.util.ArrayList;

public class FinancialBuildController implements FinancialBuildAccountInterface{


    @Override
    public ResultMessage accountbuild(ArrayList<goodsVO> goods, ArrayList<goodskindsVO> goodskinds, ArrayList<consumerVO> consumer, ArrayList<coVO> Account) {
        return null;
    }

    @Override
    public ResultMessage getPast(ArrayList<goodsVO> goods,
                                 ArrayList<consumerVO>consumer,
                                 ArrayList<coVO> Account){
        return null;
    }
}
