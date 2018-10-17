package sovellus;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TervehtijaSovellus extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label ohje = new Label("Kirjoita nimesi ja aloita.");
        Button b = new Button("Aloita");
        TextField tf = new TextField();
        GridPane gp = new GridPane();
        gp.add(ohje, 0, 0);
        gp.add(tf, 0, 1);
        gp.add(b, 0, 2);
        
        gp.setPrefSize(300, 180);
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(20, 20, 20, 20));
        
        Scene eka = new Scene(gp);

        Label terve = new Label();
        
        StackPane sp = new StackPane();
        sp.setPrefSize(300, 180);
        sp.getChildren().add(terve);
        sp.setAlignment(Pos.CENTER);
        
        Scene toka = new Scene(sp);
        
        b.setOnAction((event) -> {
            terve.setText("Tervetuloa " + tf.getText() + "!");
            stage.setScene(toka);
        });
        
        stage.setScene(eka);
        stage.show();
    }
}
