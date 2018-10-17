package borderpane;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class BorderPaneSovellus extends Application {


    public static void main(String[] args) {
        launch(BorderPaneSovellus.class);
    }
    
    @Override
    public void start(Stage stage) {
        BorderPane bp = new BorderPane();
        bp.setTop(new Label("NORTH"));
        bp.setBottom(new Label("SOUTH"));
        bp.setRight(new Label("EAST"));
        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }

}
