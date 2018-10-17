
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlaseerausOnEpatoivoista extends Application {

    @Override
    public void start(Stage stage) {

        // luodaan ulkoasu ja määritetään käyttöliittymän komponenttien asettelu
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        // luodaan tekstikenttien tekstit
        Label vieraitaTeksti = new Label(" Vieraita: ");
        
        // luodaan kentät, joihin käyttäjä voi syöttää tekstiä
        TextField vieraitaKentta = new TextField("0");
        vieraitaKentta.setId("vieraita");

        // rumahkoa copy-paste -koodausta
        vieraitaKentta.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                vieraitaKentta.setText(new Integer(newValue.replaceAll("[^\\d]", "")).toString());
            }
        });

        Label vaihtoehdotTeksti = new Label(" Plaseerausvaihtoehtoja: ");
        // luodaan kenttä, johon laskutulos lopulta asetetaan
        Label vaihtoehtojaArvoTeksti = new Label("");
        vaihtoehtojaArvoTeksti.setId("vaihtoehtoja");

        // luodaan nappi, jota painamalla laskutoimitus tehdään
        Button btn = new Button();
        btn.setId("nappi");
        btn.setText(" Epätoivoista? ");
        btn.setOnAction((e) -> {
            // haetaan tekstikenttien sisältämät arvot ja muunnetaan ne luvuiksi

            int vieraita = Integer.parseInt(vieraitaKentta.getText());
            // long-tyyppiseen muuttujaan mahtuu hieman isompia lukuja kuin
            // int-tyyppiseen muuttujaan

            long vaihtoehtoja= 1;
            int i = 1;
            
            while (i < vieraita) {
                i++;
                vaihtoehtoja *= i; 
            }

            vaihtoehtojaArvoTeksti.setText(" " + vaihtoehtoja);
        });

        // lisätään luodut elementit käyttöliittymään
        root.add(vieraitaTeksti, 0, 0);
        root.add(vieraitaKentta, 2, 0);
        root.add(vaihtoehdotTeksti, 0, 1);
        root.add(vaihtoehtojaArvoTeksti, 2, 1);

        root.add(btn, 2, 2);

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
