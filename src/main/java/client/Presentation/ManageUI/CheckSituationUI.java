package client.Presentation.ManageUI;

import client.RMI.link;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import server.Po.*;
import client.BL.Manager.ManagerCheckSituationService.ManagerCheckSituationController;
import java.rmi.RemoteException;
import java.util.List;

public class CheckSituationUI  {

        final HBox hb = new HBox();

        public HBox start() throws RemoteException {
            TitledPane gridTitlePane = new TitledPane();
            gridTitlePane.setText("详细信息");
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("销售类收入", Double.parseDouble((getSalesIncome()))),
                            new PieChart.Data("商品类收入", Double.parseDouble(getCommodity())),
                            new PieChart.Data("销售支出", Double.parseDouble(getExpenditure())),
                            new PieChart.Data("商品支出", Double.parseDouble(getAllCommodity()))
                    );

            final PieChart chart = new PieChart(pieChartData);
            chart.setTitle("经营情况");

            for (final PieChart.Data data : chart.getData()) {
                data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                        new EventHandler<MouseEvent>() {
                            @Override public void handle(MouseEvent e) {

                                String s =data.getName();
                                switch (s){
                                    case"商品类收入":
                                        gridTitlePane.setVisible(true);
                                        GridPane grid3 = new GridPane();
                                        grid3.setVgap(4);
                                        grid3.setHgap(10);
                                        grid3.setPadding(new Insets(5, 5, 5, 5));
                                        grid3.add(new Label("报溢收入 "), 0, 0);
                                        try {
                                            grid3.add(new Label(getStockOverflow()), 1, 0);
                                        } catch (RemoteException e1) {
                                            e1.printStackTrace();
                                        }
                                        grid3.add(new Label("成本调价"), 0, 1);
                                        try {
                                            grid3.add(new Label(getCost()), 1, 1);
                                        } catch (RemoteException e1) {
                                            e1.printStackTrace();
                                        }
                                        grid3.add(new Label("进货退货差价"), 0, 2);
                                        try {
                                            grid3.add(new Label(getStockDifferBetweenTwice()), 1, 2);
                                        } catch (RemoteException e1) {
                                            e1.printStackTrace();
                                        }
//                                        grid3.add(new Label("未使用的代金券:"), 0, 3);
//                                        grid3.add(new Label("400"), 1, 3);


                                        gridTitlePane.setContent(grid3);
                                        break;
                                    case"销售类收入":

                                        gridTitlePane.setVisible(false);
                                        break;
                                    case"销售支出":
                                        gridTitlePane.setVisible(false);
                                        break;
                                    case"商品支出":
                                        gridTitlePane.setVisible(true);
                                        GridPane grid5 = new GridPane();
                                        grid5.setVgap(4);
                                        grid5.setHgap(10);
                                        grid5.setPadding(new Insets(5, 5, 5, 5));
                                        grid5.add(new Label("商品报损 "), 0, 0);
                                        try {
                                            grid5.add(new Label(getReportedLoss()), 1, 0);
                                        } catch (RemoteException e1) {
                                            e1.printStackTrace();
                                        }
                                        grid5.add(new Label("商品支出"), 0, 1);
                                        try {
                                            grid5.add(new Label(getAllCommodity()), 1, 1);
                                        } catch (RemoteException e1) {
                                            e1.printStackTrace();
                                        }
                                        gridTitlePane.setContent(grid5);
                                        break;

                                }

                            }
                        });
            }



            GridPane grid = new GridPane();
            grid.setVgap(4);
            grid.setHgap(10);
            grid.setPadding(new Insets(5, 5, 5, 5));
            grid.add(new Label("折让后总收入 "), 0, 0);
            grid.add(new Label(getCut()), 0, 1);
            grid.add(new Label("折让后总支出"), 1, 0);
            grid.add(new Label(getAfterCut()), 1, 1);
            grid.add(new Label("利润"), 2, 0);
            grid.add(new Label(getProfit()), 2, 1);
            grid.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(grid);
            hb.setSpacing(3);
            hb.setAlignment(Pos.CENTER);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(hb);
            HBox hb =new HBox();
            VBox vb1 =new VBox();
            vb1.getChildren().addAll(chart,vbox);
            hb.getChildren().addAll(vb1,gridTitlePane);
            return hb;
        }

 //   }

    /**
     *   String getSalesIncome() throws RemoteException;   //销售收入
     String getStockOverflow() throws RemoteException;    //报溢收入
     String getCost() throws RemoteException;   //成本调价
     String getStockDifferBetweenTwice() throws RemoteException;
     String getCommodity() throws RemoteException;    //商品类收入
     String getCut() throws RemoteException;     //折让后总收入
     String getAfterCut() throws RemoteException;    //销售支出
     String getReportedLoss() throws RemoteException;   //商品报损支出
     String getGoodsGiven() throws RemoteException;   //商品增送支出
     String getAllCommodity() throws RemoteException;    //商品类支出
     String getExpenditure() throws RemoteException;   //折让后总支出
     String getProfit() throws RemoteException;   //利润
     * @return
     * @throws RemoteException
     */

    String getSalesIncome() throws RemoteException {
        double result=0;
        List a=link.getRemoteHelper().getSelloutBill().findAll(4);
        int length=a.size();

        for(int i=0;i<length;i++){
            selloutPO sellout=(selloutPO)link.getRemoteHelper().getSelloutBill().findAll(4).get(i);
            result=result+sellout.getFinalsum();
        }

        String re=String.valueOf(result);
        return re;
    }

    String getStockOverflow() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getStockOverflowBill().findAll(7);
        int length=a.size();

        for(int i=0;i<length;i++){
            stockexceptionPO stock=(stockexceptionPO)link.getRemoteHelper().getStockOverflowBill().findAll(7) .get(i);
            double l=Math.abs(stock.getNuminsys()-stock.getNuminbase());
            String name=stock.getGoodsno();
            result=result+l*1;
        }

        String re=String.valueOf(result);
        return re;
    }

    String getCost() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getGoods().findAll(0);
        int length=a.size();

        for(int i=0;i<length;i++){
            goodsPO good=(goodsPO)link.getRemoteHelper().getGoods().findAll(0).get(i);
            double plusprice=Math.abs(good.getReceprice()-good.getInprice());
            double num=good.getNum();

            result=result+num*plusprice;
        }

        String re=String.valueOf(result);
        return re;
    }

    String getStockDifferBetweenTwice() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getBuyinBill().findAll(3);
        int length=a.size();

        double b1=0;
        double b2=0;
        for(int i=0;i<length;i++){
            buyinPO buyin=(buyinPO)link.getRemoteHelper().getBuyinBill().findAll(3).get(i);
            if(buyin.getKind()==0){
                b1=b1+buyin.getSumall();
            }else{
                b2=b2+buyin.getSumall();
            }

            result=result+Math.abs(b1-b2);
        }

        String re=String.valueOf(result);
        return re;
    }

    String getCommodity() throws RemoteException{
        double result=Double.parseDouble(getStockOverflow())+Double.parseDouble(getCost())+Double.parseDouble(getStockDifferBetweenTwice());
        return String.valueOf(result);
    }

    String getCut() throws RemoteException{
        double result=Double.parseDouble(getCommodity())+Double.parseDouble(getSalesIncome());
        return String.valueOf(result);
    }

    String getExpenditure() throws RemoteException {
        double result=0;
        List a=link.getRemoteHelper().getBuyinBill().findAll(3);
        int length=a.size();

        for(int i=0;i<length;i++){
            buyinPO buyin=(buyinPO) link.getRemoteHelper().getBuyinBill().findAll(3).get(i);
            result=result+buyin.getSumall();
        }

        String re=String.valueOf(result);
        return re;
    }

    String getReportedLoss() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getStockOverflowBill().findAll(7);
        int length=a.size();

        for(int i=0;i<length;i++){
            stockexceptionPO stock=(stockexceptionPO)link.getRemoteHelper().getStockOverflowBill().findAll(7) .get(i);
            double l=Math.abs(stock.getNuminsys()-stock.getNuminbase());
            String name=stock.getGoodsno();
            result=result+l*10;
        }

        String re=String.valueOf(result);
        return re;
    }

    String getGoodsGiven() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getGiftBill().findAll(6);
        int length=a.size();

        for(int i=0;i<length;i++){
            giftPO gift=(giftPO)link.getRemoteHelper().getGiftBill().findAll(6).get(i);
            double l=gift.getNum();
            String name=gift.getGoodsno();
            goodsPO good=(goodsPO)link.getRemoteHelper().getGoods().findbyNO(0,name).get(0);
            double price=good.getOutprice();

            result=result+l*price;
        }

        String re=String.valueOf(result);
        return re;
    }

    String getAllCommodity() throws RemoteException{
        double result=Double.parseDouble((getReportedLoss()))+Double.parseDouble(getGoodsGiven());
        return String.valueOf(result);
    }

    String getAfterCut() throws RemoteException {
        double result=Double.parseDouble(getAllCommodity())+Double.parseDouble(getExpenditure());
        return String.valueOf(result);
    }

    String getProfit() throws RemoteException {
        double result=Double.parseDouble(getCut())-Double.parseDouble(getAfterCut());
        return String.valueOf(result);
    }
}
