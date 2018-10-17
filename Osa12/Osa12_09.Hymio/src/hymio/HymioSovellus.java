package hymio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class HymioSovellus extends Application {


    public static void main(String[] args) {
        launch(HymioSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        
        BorderPane bp = new BorderPane();
        bp.setCenter(canvas);
        
        gc.fillRect(100, 50, 50, 50);
        gc.fillRect(250, 50, 50, 50);
        gc.fillRect(50, 200, 50, 50);
        gc.fillRect(300, 200, 50, 50);
        gc.fillRect(100, 250, 200, 50);
        
        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();      
    }
}
