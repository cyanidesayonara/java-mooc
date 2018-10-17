package tekstitilastointia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.Arrays;

public class TekstitilastointiaSovellus extends Application {
   

    public static void main(String[] args) {
        launch(TekstitilastointiaSovellus.class);
    }
    
    @Override
    public void start(Stage stage) {
        
        BorderPane bp = new BorderPane();
        HBox hb = new HBox();
        hb.setSpacing(10);
        
        Label l1 = new Label("Kirjaimia: " + 0);
        Label l2 = new Label("Sanoja: " + 0);
        Label l3 = new Label("Pisin sana on: ");  
        
        hb.getChildren().addAll(l1, l2, l3);
        bp.setBottom(hb);
        
        TextArea textarea = new TextArea();
        textarea.textProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
            int merkkeja = uusiArvo.length();
            String[] palat = uusiArvo.split(" ");
            int sanoja = palat.length;
            String pisin = Arrays.stream(palat)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            l1.setText("Kirjaimia: " + merkkeja);
            l2.setText("Sanoja: " + sanoja);
            l3.setText("Pisin sana on: " + pisin);
        });   
        
        bp.setCenter(textarea);
        
        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }

}
