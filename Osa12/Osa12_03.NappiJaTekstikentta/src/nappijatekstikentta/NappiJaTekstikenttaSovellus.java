package nappijatekstikentta;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.application.Application;


public class NappiJaTekstikenttaSovellus extends Application {


    public static void main(String[] args) {
        launch(NappiJaTekstikenttaSovellus.class);
    }
    
    public void start(Stage stage) {
        Button b = new Button(":)");
        TextField tf = new TextField();
        FlowPane fp = new FlowPane();
        fp.getChildren().add(b);
        fp.getChildren().add(tf);
        Scene scene = new Scene(fp);
        stage.setScene(scene);
        stage.show();
    }

}
