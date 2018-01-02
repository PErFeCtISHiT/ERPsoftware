package client.Presentation.GuideUI;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


/**
 * Created by Leonarda on 2018/1/1.
 */
public class GuideUI {
    public HBox start(){
        HBox resultBox=new HBox();
        GridPane gridPane=new GridPane();

        Button setB=new Button();
        setB.setGraphic(new ImageView(new Image("set.png")));
        setB.setStyle("-fx-font-family: sans-serif;-fx-font: 100;-fx-border-color: transparent");
        setB.setMinSize(100,100);
        Text set=new Text("公司设置");

        setB.setOnAction((ActionEvent e)->{

        });

        Button buyinB=new Button();
        buyinB.setGraphic(new ImageView(new Image("set.png")));
        buyinB.setStyle("-fx-font-family: sans-serif;-fx-font: 100;-fx-border-color: transparent");
        buyinB.setMinSize(100,100);
        Text buyin=new Text("进（退）货帮助");

        buyinB.setOnAction((ActionEvent e)->{

        });

        Button manageB=new Button();
        manageB.setGraphic(new ImageView(new Image("set.png")));
        manageB.setStyle("-fx-font-family: sans-serif;-fx-font: 100;-fx-border-color: transparent");
        manageB.setMinSize(100,100);
        Text manage=new Text("管理帮助");

        manageB.setOnAction((ActionEvent e)->{

        });


        Button checkB=new Button();
        checkB.setGraphic(new ImageView(new Image("set.png")));
        checkB.setStyle("-fx-font-family: sans-serif;-fx-font: 100;-fx-border-color: transparent");
        checkB.setMinSize(100,100);
        Text check=new Text("查看帮助");

        checkB.setOnAction((ActionEvent e)->{

        });


        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(setB,0,0);
        gridPane.add(set,0,1);
        gridPane.add(buyinB,1,0);
        gridPane.add(buyin,1,1);
        gridPane.add(manageB,2,0);
        gridPane.add(manage,2,1);
        gridPane.add(checkB,3,0);
        gridPane.add(check,3,1);

        resultBox.getChildren().add(gridPane);
        return resultBox;
    }
}
