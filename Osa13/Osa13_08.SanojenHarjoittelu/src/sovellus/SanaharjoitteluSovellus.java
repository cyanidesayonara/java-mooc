package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


// END SOLUTION
public class SanaharjoitteluSovellus extends Application {


    public static void main(String[] args) {
        launch(SanaharjoitteluSovellus.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Sanakirja sanakirja = new Sanakirja();
        Syotto syotto = new Syotto(sanakirja);
        Harkka harkka = new Harkka(sanakirja);
        
        BorderPane bp = new BorderPane();
        
        HBox hb = new HBox();
        hb.setPadding(new Insets(20, 20, 20, 20));
        hb.setSpacing(10);
        
        Button lisaa = new Button("Lisää sanoja");
        Button harjoittele = new Button("Harjoittele");
        
        hb.getChildren().addAll(lisaa, harjoittele);        
        bp.setTop(hb);

        lisaa.setOnAction((event) -> bp.setCenter(syotto.getNakyma()));
        harjoittele.setOnAction((event) -> bp.setCenter(harkka.getNakyma()));
        
        bp.setCenter(syotto.getNakyma());
        
        Scene scene = new Scene(bp, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
