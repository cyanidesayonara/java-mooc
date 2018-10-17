package ilmoitin;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class IlmoitinSovellus extends Application {


    public static void main(String[] args) {
        launch(IlmoitinSovellus.class);
    }
    
    public void start(Stage stage) {
        TextField tf = new TextField();
        Button b = new Button("Päivitä");
        Label l = new Label();
        
        b.setOnAction((event) -> l.setText(tf.getText()));
        
        VBox vb = new VBox();
        vb.getChildren().addAll(tf, b, l);
        
        Scene scene = new Scene(vb);
        stage.setScene(scene);
        stage.show();
    }

}
