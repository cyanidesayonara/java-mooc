
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KiviPaperiSakset extends Application {

    @Override
    public void start(Stage stage) {

        // luodaan ulkoasu ja määritetään käyttöliittymän komponenttien asettelu
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        Aly hoi = new Aly();
        
        // luodaan nappi, jota painamalla laskutoimitus tehdään
        ArrayList<String> voittoHistoria = new ArrayList<>();
        Label voitotLkm = new Label("Voitot: 0");
        Label haviotLkm = new Label("Häviöt: 0");

        Button kiviNappi = new Button("Kivi");
        Button saksetNappi = new Button("Sakset");
        Button paperiNappi = new Button("Paperi");

        kiviNappi.setOnAction((e) -> {
            // aly pelaa jotain
            String alynSiirto = hoi.pelaa();
            
            // pelaaja pelasi kiven
            if(alynSiirto.equals("Paperi")) {
                // voitto!
                voittoHistoria.add("V");
            } else if (alynSiirto.equals("Sakset")) {
                voittoHistoria.add("H");
            }
            
            // muistetaan pelaajan siirto
            hoi.muista("Kivi");
            System.out.println("Sinä pelasit: Kivi");
            
            // päivitetään pelitilanne
            int voitot = 0;
            int haviot = 0;
            int laskuri = 0;
            while (laskuri < voittoHistoria.size()) {
                if(voittoHistoria.get(laskuri).equals("V")) {
                    voitot++;
                } else {
                    haviot++;
                }
                
                laskuri++;
            }
            
            voitotLkm.setText("Voitot: " + voitot);
            haviotLkm.setText("Häviöt: " + haviot);
        });

        saksetNappi.setOnAction((e) -> {
            // aly pelaa jotain
            String alynSiirto = hoi.pelaa();
            
            // pelaaja pelasi sakset
            if(alynSiirto.equals("Kivi")) {
                voittoHistoria.add("V");
            } else if (alynSiirto.equals("Paperi")) {
                voittoHistoria.add("H");
            }
            
            // muistetaan pelaajan siirto
            hoi.muista("Sakset");
            System.out.println("Sinä pelasit: Sakset");
            
            // päivitetään pelitilanne
            int voitot = 0;
            int haviot = 0;
            int laskuri = 0;
            while (laskuri < voittoHistoria.size()) {
                if(voittoHistoria.get(laskuri).equals("V")) {
                    voitot++;
                } else {
                    haviot++;
                }
                
                laskuri++;
            }
            
            voitotLkm.setText("Voitot: " + voitot);
            haviotLkm.setText("Häviöt: " + haviot);
        });

        paperiNappi.setOnAction((e) -> {
            // aly pelaa jotain
            String alynSiirto = hoi.pelaa();
            
            // pelaaja pelasi paperin
            if(alynSiirto.equals("Sakset")) {
                voittoHistoria.add("V");
            } else if (alynSiirto.equals("Kivi")) {
                voittoHistoria.add("H");
            }
            
            // muistetaan pelaajan siirto
            hoi.muista("Paperi");
            System.out.println("Sinä pelasit: Paperi");
            
            // päivitetään pelitilanne
            int voitot = 0;
            int haviot = 0;
            int laskuri = 0;
            while (laskuri < voittoHistoria.size()) {
                if(voittoHistoria.get(laskuri).equals("V")) {
                    voitot++;
                } else {
                    haviot++;
                }
                
                laskuri++;
            }
            
            voitotLkm.setText("Voitot: " + voitot);
            haviotLkm.setText("Häviöt: " + haviot);
        });

        root.add(voitotLkm, 0, 0);
        root.add(haviotLkm, 0, 1);
        
        root.add(kiviNappi, 0, 2);
        root.add(saksetNappi, 0, 3);
        root.add(paperiNappi, 0, 4);

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
