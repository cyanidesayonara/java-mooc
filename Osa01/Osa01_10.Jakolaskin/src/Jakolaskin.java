
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Jakolaskin extends Application {

    @Override
    public void start(Stage stage) {

        // luodaan ulkoasu ja määritetään käyttöliittymän komponenttien asettelu
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        // luodaan tekstikenttien tekstit
        Label luku1Teksti = new Label(" Luku 1:");
        Label luku2Teksti = new Label(" Luku 2:");
        
        // luodaan kentät, joihin käyttäjä voi syöttää tekstiä
        TextField luku1Kentta = new TextField("0");
        luku1Kentta.setId("luku1");
        TextField luku2Kentta = new TextField("0");
        luku2Kentta.setId("luku2");
        
        // rumahkoa copy-paste -koodausta
        luku1Kentta.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                luku1Kentta.setText(new Integer(newValue.replaceAll("[^\\d]", "")).toString());
            }
        });
        luku2Kentta.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                luku2Kentta.setText(new Integer(newValue.replaceAll("[^\\d]", "")).toString());
            }
        });

        // luodaan kenttä, johon laskutulos lopulta asetetaan
        Label osamaaraTeksti = new Label("");
        osamaaraTeksti.setId("osamaara");

        // luodaan nappi, jota painamalla laskutoimitus tehdään
        Button btn = new Button();
        btn.setId("nappi");
        btn.setText(" / ");
        btn.setOnAction((e) -> {
            // haetaan tekstikenttien sisältämät arvot ja muunnetaan ne luvuiksi

            double luku1 = Integer.parseInt(luku1Kentta.getText());
            double luku2 = Integer.parseInt(luku2Kentta.getText());
            
            if(luku2 == 0) {
                return;
            }

            // tehdään jakolasku
            double osamaara = luku1 / luku2;

            // asetetaan teksti laskutuloksen näyttävään kenttään
            osamaaraTeksti.setText(luku1 + " / " + luku2 + " = " + osamaara);
        });

        // lisätään luodut elementit käyttöliittymään
        root.add(luku1Teksti, 0, 0);
        root.add(luku1Kentta, 2, 0);
        root.add(luku2Teksti, 0, 1);
        root.add(luku2Kentta, 2, 1);

        root.add(btn, 0, 2);
        root.add(osamaaraTeksti, 2, 2);

        // näytetään ohjelma
        Scene scene = new Scene(root);

        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
