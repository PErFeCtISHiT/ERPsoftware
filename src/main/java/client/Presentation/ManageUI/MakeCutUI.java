package client.Presentation.ManageUI;

import client.BL.Accountant.FinancialCashbl.FinancialCash;
import client.BL.Accountant.FinancialReceivebl.MoneyList;
import client.BL.Manager.ManagerCheckProcessService.Billgotten;
import client.BL.Manager.ManagerMakeCutService.*;
import client.RMI.link;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import client.BL.Manager.ManagerMakeCutService.Pack;
import client.BL.Manager.ManagerMakeCutService.Cut;
import javafx.util.Callback;
import server.Po.cutPO;
import server.Po.packPO;
import shared.ResultMessage;
import client.Presentation.NOgenerator.NOgenerator;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MakeCutUI {

    private final TableView<Cut> table = new TableView<>();
    private final TableView<Pack>packtable =new TableView<>();
    public CutController cutController =new CutController();
    public PackController packController =new PackController();
    public final TextField money =new TextField("");
    public final TextField packbein =new TextField("");
    public final TextField rate =new TextField("");
    public final TextField goodid =new TextField("");
    public int searchcode =-1;
    public int vipleast =-1;
    public String TimeBegin ="";
    public String TimeEnd ="";
    public String CutId ="";
    public Double level =0.0;
    public Double cut =0.0;
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;
    public  final Button summit=new Button("提交");


    private final ObservableList<Cut> data =
            FXCollections.observableArrayList(
            );
    private final ObservableList<Pack> packdata =
            FXCollections.observableArrayList(
            );

    final HBox hb = new HBox();
    final VBox vb2 =new VBox();
    final HBox finalhb =new HBox();


    public HBox start() {
        Locale.setDefault(Locale.CHINA);



        //促销策略策略
        final ChoiceBox choiceBoxforthree= new ChoiceBox(FXCollections.observableArrayList("赠品","折扣","折扣包","代金券"));

        choiceBoxforthree.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
            searchcode =newv.intValue();
            if(searchcode==0){
                money.setVisible(false);
                packbein.setVisible(false);
                rate.setVisible(false);
            }else if(searchcode ==1){
                rate.setVisible(true);
                money.setVisible(false);
                packbein.setVisible(false);
            }else if(searchcode==2){
                rate.setVisible(false);
                money.setVisible(false);
                packbein.setVisible(true);
            }else{
                rate.setVisible(false);
                money.setVisible(true);
                packbein.setVisible(false);
            }

        });

        //vip等级
        final ChoiceBox VIPChose= new ChoiceBox(FXCollections.observableArrayList("1","2","3","4","5"));
        VIPChose.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
            vipleast =newv.intValue()+1;
            level =(double)vipleast;

        });




        //促销策略列表
        final Label label = new Label("促销策略列表");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);

        //促销包列表
        final Label packlabel =new Label("促销包列表");
        packlabel.setFont(new Font("Arial", 20));
        packtable.setEditable(true);

        TableColumn<Cut, String> vipCol =
                new TableColumn<>("VIP最低等级");
        TableColumn<Cut, String> strategyCol =
                new TableColumn<>("促销策略");
        TableColumn<Cut, String> commodityCol =
                new TableColumn<>("促销商品编号");
        TableColumn<Cut, String> begintimeCol =
                new TableColumn<>("开始时间");
        TableColumn<Cut, String> endtimeCol =
                new TableColumn<>("结束时间");
        TableColumn<Cut, String> packinCol =
                new TableColumn<>("从属特价包");



        vipCol.setMinWidth(100);
        vipCol.setCellValueFactory(
                param -> param.getValue().vip);

        strategyCol.setMinWidth(100);
        strategyCol.setCellValueFactory(
                param -> param.getValue().strategy);

        commodityCol.setMinWidth(100);
        commodityCol.setCellValueFactory(
                param -> param.getValue().commodity);

        begintimeCol.setMinWidth(100);
        begintimeCol.setCellValueFactory(
                param -> param.getValue().begintime);

        endtimeCol.setMinWidth(100);
        endtimeCol.setCellValueFactory(
                param -> param.getValue().endtime);

        packinCol.setMinWidth(100);
        packinCol.setCellValueFactory(
                param -> param.getValue().packin);
        table.setItems(data);
        table.getColumns().addAll(vipCol,strategyCol,commodityCol,begintimeCol,endtimeCol,packinCol);


        //设置包列表

        TableColumn<Pack, String> PackID =
                new TableColumn<>("特价包编号");
        TableColumn<Pack, String> PackRateCol =
                new TableColumn<>("特价包折扣");
        PackID.setMinWidth(100);
        PackRateCol.setMinWidth(100);
        PackID.setCellValueFactory(
                param -> param.getValue().Id);
        PackRateCol.setCellValueFactory(
                param -> param.getValue().CutRate);
        packtable.setItems(packdata);
        packtable.getColumns().addAll(PackID,PackRateCol);






        try {
            List<cutPO> list =cutController.showcutPO();
            for (int i=0;i<list.size();i++){
                data.add(new Cut(list.get(i).getLev().toString(),getCutType(list.get(i).getCut()),list.get(i).getKeyno(),"20170202","20170303",list.get(i).getPackno())
                );
            }}catch (RemoteException e){
            e.printStackTrace();
        }

        try {
            List<packPO> list1 =packController.showpackPO();
            for (int i=0;i<list1.size();i++){
                packdata.add(new Pack(list1.get(i).getKeyno(),list1.get(i).getPrice().toString()));

            }}catch (RemoteException e){
            e.printStackTrace();
        }


        final Button button1 = new Button("添加");
        button1.setOnAction((ActionEvent e) -> {


        });

        //促销开始时间和结束时间的选择
        VBox vbox1 = new VBox(20);
        vbox1.setStyle("-fx-padding: 10;");


        VBox vbox2 = new VBox(20);
        vbox2.setStyle("-fx-padding: 10;");




        checkInDatePicker = new DatePicker();
        checkOutDatePicker = new DatePicker();
        checkOutDatePicker.setValue(LocalDate.now());
        checkInDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isBefore(
                                        checkInDatePicker.getValue().plusDays(1))
                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        checkOutDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));



        //add listener
        checkInDatePicker.setOnAction((ActionEvent e) -> {
            TimeBegin =checkInDatePicker.getValue().toString();
            TimeBegin =TimeBegin.substring(0,4)+TimeBegin.substring(5,7)+TimeBegin.substring(8,10);
            System.out.println(TimeBegin);



        });
        checkOutDatePicker.setOnAction((ActionEvent e) -> {
            TimeEnd =checkOutDatePicker.getValue().toString();
            TimeEnd =TimeEnd.substring(0,4)+TimeEnd.substring(5,7)+TimeEnd.substring(8,10);



        });



        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label checkInlabel = new Label("开始时间");
        gridPane.add(checkInlabel, 0, 0);
        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(checkInDatePicker, 1, 0);
        Label checkOutlabel = new Label("结束时间");
        gridPane.add(checkOutlabel, 0, 1);
        GridPane.setHalignment(checkOutlabel, HPos.LEFT);
        gridPane.add(checkOutDatePicker, 1, 1);
        Label choices = new Label("促销策略选择");
        gridPane.add(choices, 2, 0);
        GridPane.setHalignment(choices, HPos.LEFT);
        gridPane.add( choiceBoxforthree, 2, 1);
        Label vip = new Label("VIP最低等级");
        gridPane.add(vip, 3, 0);
        GridPane.setHalignment(vip, HPos.LEFT);
        gridPane.add(VIPChose, 3, 1);
        Label id = new Label("商品编号");
        gridPane.add(id, 4, 0);
        GridPane.setHalignment(id, HPos.LEFT);
        gridPane.add( goodid, 4, 1);
        vbox1.getChildren().add(gridPane);

        hb.setSpacing(3);
        GridPane gridPane2 = new GridPane();
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);

        Label moneyreduced = new Label("代金券金额");
        gridPane2.add(moneyreduced, 0, 0);

        gridPane2.add(money, 1, 0);
        Label cutrate = new Label("折扣");
        gridPane2.add(cutrate, 0, 1);

        gridPane2.add(rate, 1, 1);
        Label packbelong = new Label("所属折扣包");
        gridPane2.add(packbelong, 0, 2);

        gridPane2.add(packbein, 1, 2);
        vbox2.getChildren().addAll(gridPane2);

        //parse rate if the rate is legal
        if(rate.getText().equals("")){}else{
        cut =Double.parseDouble(rate.getText());}



        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        vb2.getChildren().addAll(packlabel,packtable);
        finalhb.getChildren().addAll(vbox,vb2);

        final VBox finalvb =new VBox();
        finalvb.getChildren().addAll(finalhb,vbox1,vbox2,summit);
        HBox hb =new HBox();
        hb.getChildren().addAll(finalvb);

        summit.setOnAction((ActionEvent e) -> {
            if (true)
            {
                try {
                    CutId =NOgenerator.generate(12);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                } catch (IntrospectionException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }

                //开始时间 结束时间 促销策略 是否从属特价包（如果从属 则为特价包id 否则 则为无）商品id //附属信息 加入数据库内 rate money 赠品 价格为0
                if(searchcode==0){
                    Cut cut1 =new Cut(vipleast+"","赠品",goodid.getText(),TimeBegin,TimeEnd,"无");

                    //cutPO po =new cutPO(CutId,level,cut,0.0,0.0,"",TimeBegin,TimeEnd);
                    data.add(cut1);
            }else if(searchcode ==1){
                    Cut cut2 =new Cut(vipleast+"","折扣",goodid.getText(),TimeBegin,TimeEnd,"无");
                    //cutPO po =new cutPO(CutId,level,cut,1.0,0.0,"",TimeBegin,TimeEnd);

                    data.add(cut2);
                }else if(searchcode ==2){
                    Cut cut3 =new Cut(vipleast+"","折扣包",goodid.getText(),TimeBegin,TimeEnd,packbein.getText());
                    //cutPO po =new cutPO(CutId,level,cut,2.0,0.0,packbelong.getText(),TimeBegin,TimeEnd);

                    data.add(cut3);
                }else{
                    Cut cut4 =new Cut(vipleast+"","代金券",goodid.getText(),TimeBegin,TimeEnd,"无");
                    //cutPO po =new cutPO(CutId,level,cut,3.0,money.getText(),"",TimeBegin,TimeEnd);

                    data.add(cut4);
                }
                packbein.clear();
                money.clear();
                goodid.clear();
                rate.clear();


            }
        });



return hb;

}
public String getCutType(double cut){
        if(cut==0){
            return"赠品";
        }
        else if(cut==1){
            return"折让";
        }
        else{
            return"代金券";
        }
}
}
