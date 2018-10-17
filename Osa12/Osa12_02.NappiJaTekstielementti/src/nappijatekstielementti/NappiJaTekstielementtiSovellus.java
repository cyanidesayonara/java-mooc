package nappijatekstielementti;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class NappiJaTekstielementtiSovellus extends Application {


    public static void main(String[] args) {
        launch(NappiJaTekstielementtiSovellus.class);
    }
    
    @Override
    public void start(Stage stage) {
        Button b = new Button("Click me!");
        Label l = new Label("Hello world!");
        FlowPane fp = new FlowPane();
        fp.getChildren().add(b);
        fp.getChildren().add(l);
        Scene scene = new Scene(fp);
        stage.setScene(scene);
        stage.show();
    }

}
