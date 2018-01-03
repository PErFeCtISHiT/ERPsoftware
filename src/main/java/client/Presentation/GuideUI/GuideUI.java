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
        setB.setStyle("-fx-font-family: sans-serif;-fx-font: 100;-fx-border-color: transparent;-fx-background-color: transparent");
        setB.setMinSize(100,100);
        Text set=new Text("          公司设置帮助");

        setB.setOnAction((ActionEvent e)->{
        });

        Button buyinB=new Button();
        buyinB.setGraphic(new ImageView(new Image("set.png")));
        buyinB.setStyle("-fx-font-family: sans-serif;-fx-font: 100;-fx-border-color: transparent;-fx-background-color: transparent");
        buyinB.setMinSize(100,100);
        Text buyin=new Text("     进（退）货帮助");

        buyinB.setOnAction((ActionEvent e)->{

        });

        Button manageB=new Button();
        manageB.setGraphic(new ImageView(new Image("set.png")));
        manageB.setStyle("-fx-font-family: sans-serif;-fx-font: 100;-fx-border-color: transparent;-fx-background-color: transparent");
        manageB.setMinSize(100,100);
        Text manage=new Text("          管理帮助");

        manageB.setOnAction((ActionEvent e)->{

        });


        Button checkB=new Button();
        checkB.setGraphic(new ImageView(new Image("set.png")));
        checkB.setStyle("-fx-font-family: sans-serif;-fx-font: 100;-fx-border-color: transparent;-fx-background-color: transparent");
        checkB.setMinSize(100,100);
        Text check=new Text("          查看帮助");

        checkB.setOnAction((ActionEvent e)->{

        });


        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(setB,25,20);
        gridPane.add(set,25,21);
        gridPane.add(buyinB,26,20);
        gridPane.add(buyin,26,21);
        gridPane.add(manageB,27,20);
        gridPane.add(manage,27,21);
        gridPane.add(checkB,28,20);
        gridPane.add(check,28,21);

        resultBox.getChildren().add(gridPane);
        return resultBox;
    }
}
