package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VitsiSovellus extends Application {


    public static void main(String[] args) {
        launch(VitsiSovellus.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderpane = new BorderPane();
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);
        
        Button b1 = new Button("Vitsi");
        Button b2 = new Button("Vastaus");
        Button b3 = new Button("Selitys");
        
        b1.setPrefWidth(60);
        b2.setPrefWidth(60);
        b3.setPrefWidth(60);
        
        vbox.getChildren().addAll(b1, b2, b3);
        
        StackPane vits = luoNakyma("What do you call a bear with no teeth?");
        StackPane vast = luoNakyma("A gummy bear.");
        StackPane seli = luoNakyma("This joke is funny because the word 'gummy' "
                + "has a \ndouble meaning, implying both that the bear in \nquestion (1) "
                + "has no teeth, only gums, and (2) is in fact \nnot a real bear at all; "
                + "instead the term 'gummy bear' \nrefers to a popular gelatin-based, "
                + "bear-shaped candy.");
                
        b1.setOnAction((event) -> borderpane.setCenter(vits));
        b2.setOnAction((event) -> borderpane.setCenter(vast));
        b3.setOnAction((event) -> borderpane.setCenter(seli));
        
        borderpane.setLeft(vbox);
        borderpane.setCenter(vits);
        
        Scene scene = new Scene(borderpane);
        
        stage.setScene(scene);
        stage.show();
    }
    
    private StackPane luoNakyma(String x) {
        StackPane sp = new StackPane();
        sp.setPrefSize(340, 100);
        sp.getChildren().add(new Label(x));
        sp.setAlignment(Pos.CENTER);
        return sp;
    }
}
