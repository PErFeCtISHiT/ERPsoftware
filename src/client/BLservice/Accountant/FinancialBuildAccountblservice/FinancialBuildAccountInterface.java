package client.BLservice.Accountant.FinancialBuildAccountblservice;

import client.Vo.coVO;
import client.Vo.consumerVO;
import client.Vo.goodsVO;
import client.Vo.goodskindsVO;
import shared.ResultMessage;

import java.util.ArrayList;

public interface FinancialBuildAccountInterface {


    public ResultMessage accountbuild(ArrayList<goodsVO> goods,
                                      ArrayList<goodskindsVO> goodskinds,
                                      ArrayList<consumerVO> consumer,
                                      ArrayList<coVO> Account);

    public ResultMessage getPast(ArrayList<goodsVO> goods,
                                  ArrayList<consumerVO>consumer,
                                  ArrayList<coVO> Account);

}
