package client.BL.Accountant.FinancialBuildAccountbl.Mock;

import client.BL.Accountant.FinancialBuildAccountbl.FinancialBuildController;
import client.Vo.coVO;
import client.Vo.consumerVO;
import client.Vo.goodsVO;
import shared.ResultMessage;

import java.util.ArrayList;

public class FinancialBuildControllerMock extends FinancialBuildController {

    public ResultMessage accountbuild(ArrayList<goodsVO> goods,
                                      ArrayList<consumerVO>consumer,
                                      ArrayList<coVO> Account){
        return null;
    }

    public ResultMessage getPast(ArrayList<goodsVO> goods,
                                  ArrayList<consumerVO>consumer,
                                  ArrayList<coVO> Account){
        return null;
    }
}
