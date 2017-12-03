package client.Presentation.ManageUI;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CheckSituationUI extends Application {


    private final TableView<Situation> table = new TableView<>();
    private final ObservableList<Situation> data =
            FXCollections.observableArrayList(
                    new Situation("1", "2", "3","4", "5", "7","8","9","12","13","14")
                    );
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("经营情况表");
        stage.setWidth(1250);
        stage.setHeight(850);
        final Label label = new Label("经营情况列表");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);


        TableColumn<CheckSituationUI.Situation, String> Col1 =
                new TableColumn<>("销售收入");
        TableColumn<CheckSituationUI.Situation, String> Col2 =
                new TableColumn<>("商品报溢收入");
        TableColumn<CheckSituationUI.Situation, String> Col3 =
                new TableColumn<>("成本调整收入");
        TableColumn<CheckSituationUI.Situation, String> Col4 =
                new TableColumn<>("进退货差价收入");
        TableColumn<CheckSituationUI.Situation, String> Col5 =
                new TableColumn<>("代金券与实际收款差额收入");
        TableColumn<CheckSituationUI.Situation, String> Col6 =
                new TableColumn<>("商品报损支出");
        TableColumn<CheckSituationUI.Situation, String> Col7=
                new TableColumn<>("商品赠送支出");

        Col1.setMinWidth(100);
        Col1.setCellValueFactory(
        param -> param.getValue().saleMoney);

        Col2.setMinWidth(100);
        Col2.setCellValueFactory(
                param -> param.getValue().baoyiMoney);

        Col3.setMinWidth(100);
        Col3.setCellValueFactory(
                param -> param.getValue().chengbentiaozhengMoney);

        Col4.setMinWidth(100);
        Col4.setCellValueFactory(
                param -> param.getValue().jintuihuochajiaMoney);

        Col5.setMinWidth(100);
        Col5.setCellValueFactory(
                param -> param.getValue().daijinquanandchaeMoney);

        Col6.setMinWidth(100);
        Col6.setCellValueFactory(
                param -> param.getValue().commodityloss);

        Col7.setMinWidth(100);
        Col7.setCellValueFactory(
                param -> param.getValue().commoditygiven);




        table.setItems(data);
        table.getColumns().addAll(Col1,Col2,Col3,Col4,Col5,Col6,Col7);


        final Button DetailButton = new Button("查看详细信息");
        DetailButton.setOnAction((ActionEvent e) -> {


        });
        final Button OutputButton = new Button("导出表格");
        OutputButton.setOnAction((ActionEvent e) -> {


        });

        hb.getChildren().addAll(DetailButton,OutputButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Situation {

        private final SimpleStringProperty saleMoney;
        private final SimpleStringProperty baoyiMoney;
        private final SimpleStringProperty chengbentiaozhengMoney;
        private final SimpleStringProperty jintuihuochajiaMoney;
        private final SimpleStringProperty daijinquanandchaeMoney;

        private final SimpleStringProperty commodityloss;
        private final SimpleStringProperty commoditygiven;

        private final SimpleStringProperty takeinwithcut;
        private final SimpleStringProperty cut;
        private final SimpleStringProperty pay;
        private final SimpleStringProperty profit;


        private Situation(String saleMoney,String baoyiMoney,String chengbentiaozhengMoney,String jintuihuochajiaMoney,String daijinquandchaeMoney,String
                          commodityloss,String commoditygiven,String takeinwithcut,String cut,String pay,String profit){
            this.saleMoney =new SimpleStringProperty(saleMoney);
            this.baoyiMoney =new SimpleStringProperty(baoyiMoney);
            this.chengbentiaozhengMoney =new SimpleStringProperty(chengbentiaozhengMoney);
            this.jintuihuochajiaMoney =new SimpleStringProperty(jintuihuochajiaMoney);
            this.daijinquanandchaeMoney =new SimpleStringProperty(daijinquandchaeMoney);
            this.commoditygiven =new SimpleStringProperty(commoditygiven);
            this.commodityloss =new SimpleStringProperty(commodityloss);
            this.takeinwithcut =new SimpleStringProperty(takeinwithcut);
            this.cut =new SimpleStringProperty(cut);
            this.pay =new SimpleStringProperty(pay);
            this.profit =new SimpleStringProperty(profit);
        }

        public String getSaleMoney() {
            return saleMoney.get();
        }
        public void setSaleMoney(String salemoney){
            saleMoney.set(salemoney);
        }


        public String getBaoyiMoney() {
            return baoyiMoney.get();
        }
        public void setBaoyiMoney(String baoyimoney ){
            baoyiMoney.set(baoyimoney);

        }


        public String getChengbentiaozhengMoney() {
            return chengbentiaozhengMoney.get();
        }
        public void setChengbentiaozhengMoney(String chengbentiaozhengmoney ){
            chengbentiaozhengMoney.set(chengbentiaozhengmoney);

        }


        public String getJintuihuochajiaMoney() {
            return jintuihuochajiaMoney.get();
        }
        public void setJintuihuochajiaMoney(String jintuihuochajiamoney ){
            jintuihuochajiaMoney.set(jintuihuochajiamoney);

        }


        public String getDaijinquanandchaeMoney() {
            return daijinquanandchaeMoney.get();
        }

        public void  setDaijinquanandchaeMoney(String daijinquanandchaemoney){
            daijinquanandchaeMoney.set(daijinquanandchaemoney);
        }

        public String getCommodityloss() {
            return commodityloss.get();
        }
        public void setCommodityloss(String commodityloss){
            commoditygiven.set(commodityloss);
        }


        public String getCommoditygiven() {
            return commoditygiven.get();
        }

        public void setCommoditygiven(String commoditygiven){
            commodityloss.set(commoditygiven);

        }



        public String getTakeinwithcut() {
            return takeinwithcut.get();
        }

        public void setTakeinwithcut(String Takeinwithcut){
            takeinwithcut.set(Takeinwithcut);

        }


        public String getCut() {
            return cut.get();
        }

        public void setCut(String Cut){
            cut.set(Cut);
        }

        public String getPay() {
            return pay.get();
        }

        public void setPay(String Pay){
            pay.set(Pay);
        }
        public String getProfit() {
            return profit.get();
        }

        public void setProfit(String Profit){
            profit.set(Profit);
        }


    }

}
