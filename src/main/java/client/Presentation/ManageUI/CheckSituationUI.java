package client.Presentation.ManageUI;

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


public class CheckSituationUI  {


    final HBox hb = new HBox();

    public HBox start() {
        TitledPane gridTitlePane = new TitledPane();
        gridTitlePane.setText("详细信息");
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("销售类收入", 13),
                        new PieChart.Data("商品类收入", 25),
                        new PieChart.Data("销售支出", 10),
                        new PieChart.Data("商品支出", 22)
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
                                        grid3.add(new Label("400"), 1, 0);
                                        grid3.add(new Label("成本调价"), 0, 1);
                                        grid3.add(new Label("400"), 1, 1);
                                        grid3.add(new Label("进货退货差价"), 0, 2);
                                        grid3.add(new Label("400"), 1, 2);
                                        grid3.add(new Label("未使用的代金券:"), 0, 3);
                                        grid3.add(new Label("400"), 1, 3);


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
                                    grid5.add(new Label("400"), 1, 0);
                                    grid5.add(new Label("商品支出"), 0, 1);
                                    grid5.add(new Label("400"), 1, 1);
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
        grid.add(new Label("400"), 0, 1);
        grid.add(new Label("折让后总支出"), 1, 0);
        grid.add(new Label("400"), 1, 1);
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



}
