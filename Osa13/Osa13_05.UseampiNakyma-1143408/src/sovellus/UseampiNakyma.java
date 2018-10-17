package sovellus;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UseampiNakyma extends Application {
    private List<Scene> nakymat = new ArrayList();
    
    public static void main(String[] args) {
        launch(UseampiNakyma.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        bp.setTop(new Label("Eka näkymä!"));
        Button b1 = new Button("Tokaan näkymään!");
        bp.setCenter(b1);
        Scene eka = new Scene(bp);
        
        VBox vb = new VBox();
        Button b2 = new Button("Kolmanteen näkymään!");
        vb.getChildren().addAll(b2, new Label("Toka näkymä!"));
        Scene toka = new Scene(vb);
        
        GridPane gp = new GridPane();
        gp.add(new Label("Kolmas näkymä!"), 0, 0);
        Button b3 = new Button("Ekaan näkymään!");
        gp.add(b3, 1, 1);
        Scene kolmas = new Scene(gp);
        
        b1.setOnAction((event) -> {
            stage.setScene(toka);
        });
        
        b2.setOnAction((event) -> {
            stage.setScene(kolmas);
        });
        
        b3.setOnAction((event) -> {
            stage.setScene(eka);
        });
        
        stage.setScene(eka);
        stage.show();
    }

}
