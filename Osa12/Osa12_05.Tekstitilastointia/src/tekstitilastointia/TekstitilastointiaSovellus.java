package tekstitilastointia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class TekstitilastointiaSovellus extends Application {


    public static void main(String[] args) {
        launch(TekstitilastointiaSovellus.class);
    }
    
    @Override
    public void start(Stage stage) {
        BorderPane bp = new BorderPane();
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().add(new Label("Kirjaimia: 0"));
        hb.getChildren().add(new Label("Sanoja: 0"));
        hb.getChildren().add(new Label("Pisin sana on:"));
        
        bp.setBottom(hb);
        bp.setCenter(new TextArea());
        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }

}
