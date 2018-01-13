package client.Presentation.ManageUI;
import client.RMI.link;
import client.Vo.selloutVO;
import com.sun.org.apache.regexp.internal.RE;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import org.bytedeco.javacpp.presets.opencv_core;
import server.Po.stockexceptionPO;
import server.Po.selloutPO;
import server.Po.goodsPO;
import server.Po.buyinPO;
import server.Po.giftPO;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.List;

public class CheckSituationUI  {

//    final HBox hb = new HBox();
    //public HBox start() {
//        GridPane pane=new GridPane();
//
//        Button search=new Button("搜索");
//
//        DatePicker checkin=new DatePicker();
//        DatePicker checkout=new DatePicker();
//
//        pane.add(checkin,1,0);
//        pane.add(checkout,2,0);
//        pane.add(search,3,0);
//
//        search.setOnAction((ActionEvent e)->{
//            Label shourulei=new Label("收入类");
//            pane.add(shourulei,1,1);
//
//            Text zheranghoushouru=new Text();
//            try {
//                zheranghoushouru.setText("折让后总收入："+getzherang());
//            } catch (RemoteException e1) {
//                e1.printStackTrace();
//            }
//            pane.add(zheranghoushouru,2,2);
//
//            Text xiaoshoushouru=new Text();
//            try {
//                xiaoshoushouru.setText("销售收入："+getxiaoshou());
//            } catch (RemoteException e1) {
//                e1.printStackTrace();
//            }
//            pane.add(xiaoshoushouru,3,2);
//
//            Text shangpinleishuru=new Text();
//            shangpinleishuru.setText("商品收入：");
//            pane.add(shangpinleishuru,4,2);
//
//            Text chengbentiaojia=new Text();
//            chengbentiaojia.setText("成本调价：");
//            pane.add(chengbentiaojia,5,2);
//
//            Text jintuihuochajia=new Text();
//            jintuihuochajia.setText("进退货差价：");
//            pane.add(jintuihuochajia,6,2);
//
//            Label zhichulei=new Label("支出类");
//            pane.add(zhichulei,1,3);
//
//            Text xiaoshouzhichu=new Text();
//            xiaoshouzhichu.setText("销售支出：");
//            pane.add(xiaoshouzhichu,2,4);
//
//            Text shangpinzhichu=new Text();
//            shangpinzhichu.setText("商品支出：");
//            pane.add(shangpinzhichu,3,4);
//
//            Text shangpinbaosun=new Text("商品报损：");
//            shangpinbaosun.setText("商品报损：");
//            pane.add(shangpinbaosun,4,4);
//
//            Text shangpinzengchu=new Text();
//            shangpinzengchu.setText("商品赠出：");
//            pane.add(shangpinzengchu,5,4);
//
//        });
//
//        hb.getChildren().add(pane);
//        return hb;
        final HBox hb = new HBox();

        public HBox start() throws RemoteException {
            TitledPane gridTitlePane = new TitledPane();
            gridTitlePane.setText("详细信息");
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("销售类收入", Double.parseDouble(getxiaoshou())),
                            new PieChart.Data("商品类收入", Double.parseDouble(getshangpin())),
                            new PieChart.Data("销售支出", Double.parseDouble(getxiaoshouzhichu())),
                            new PieChart.Data("商品支出", Double.parseDouble(getshangpinzhichu()))
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
                                            grid3.add(new Label(getbaoyi()), 1, 0);
                                        } catch (RemoteException e1) {
                                            e1.printStackTrace();
                                        }
                                        grid3.add(new Label("成本调价"), 0, 1);
                                        try {
                                            grid3.add(new Label(getchengben()), 1, 1);
                                        } catch (RemoteException e1) {
                                            e1.printStackTrace();
                                        }
                                        grid3.add(new Label("进货退货差价"), 0, 2);
                                        try {
                                            grid3.add(new Label(getjinhuo()), 1, 2);
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
                                            grid5.add(new Label(getbaosun()), 1, 0);
                                        } catch (RemoteException e1) {
                                            e1.printStackTrace();
                                        }
                                        grid5.add(new Label("商品支出"), 0, 1);
                                        try {
                                            grid5.add(new Label(getshangpinzhichu()), 1, 1);
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
            grid.add(new Label(getzherang()), 0, 1);
            grid.add(new Label("折让后总支出"), 1, 0);
            grid.add(new Label(getzhichu()), 1, 1);
            grid.add(new Label("利润"), 2, 0);
            grid.add(new Label("400"), 2, 1);
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



    String getxiaoshou() throws RemoteException {
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

    String getbaoyi() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getStockOverflowBill().findAll(7);
        int length=a.size();

        for(int i=0;i<length;i++){
            stockexceptionPO stock=(stockexceptionPO)link.getRemoteHelper().getStockOverflowBill().findAll(7) .get(i);
            double l=Math.abs(stock.getNuminsys()-stock.getNuminbase());
            String name=stock.getGoodsno();
 //           goodsPO good=(goodsPO)link.getRemoteHelper().getGoods().findbyNO(0,name).get(0);
 //           double price=good.getOutprice();

//            result=result+l*price;
            result=result+l*1;
        }

        String re=String.valueOf(result);
        return re;
    }

    String getchengben() throws RemoteException{
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

    String getjinhuo() throws RemoteException{
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

    String getshangpin() throws RemoteException{
        double result=Double.parseDouble(getbaoyi())+Double.parseDouble(getchengben())+Double.parseDouble(getjinhuo());
        return String.valueOf(result);
    }

    String getzherang() throws RemoteException{
        double result=Double.parseDouble(getshangpin())+Double.parseDouble(getxiaoshou());
        return String.valueOf(result);
    }

    String getxiaoshouzhichu() throws RemoteException {
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

    String getbaosun() throws RemoteException{
        double result=0;
        List a=link.getRemoteHelper().getStockOverflowBill().findAll(7);
        int length=a.size();

        for(int i=0;i<length;i++){
            stockexceptionPO stock=(stockexceptionPO)link.getRemoteHelper().getStockOverflowBill().findAll(7) .get(i);
            double l=Math.abs(stock.getNuminsys()-stock.getNuminbase());
            String name=stock.getGoodsno();
//            goodsPO good=(goodsPO)link.getRemoteHelper().getGoods().findbyNO(0,name).get(0);
//            double price=good.getOutprice();

            result=result+l*10;
        }

        String re=String.valueOf(result);
        return re;
    }

    String getzengchu() throws RemoteException{
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

    String getshangpinzhichu() throws RemoteException{
        double result=Double.parseDouble(getbaosun())+Double.parseDouble(getzengchu());
        return String.valueOf(result);
    }

    String getzhichu() throws RemoteException {
        double result=Double.parseDouble(getshangpinzhichu())+Double.parseDouble(getxiaoshouzhichu());
        return String.valueOf(result);
    }

    String getlirui() throws RemoteException {
        double result=Double.parseDouble(getzherang())-Double.parseDouble(getzhichu());
        return String.valueOf(result);
    }
}
