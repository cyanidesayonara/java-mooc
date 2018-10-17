package sovellus;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class KirjoitusharjoitteluSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        Sanasto sanasto = new Sanasto();
        Kirjoitusnopeudet kirjoitusnopeudet = new Kirjoitusnopeudet();

        BorderPane borderPane = new BorderPane();

        // sanat vasemmalle laidalle
        Kyselynakyma kyselynakyma = new Kyselynakyma(sanasto);

        // kaavio oikealle laidalle
        Tilastonakyma tilastonakyma = new Tilastonakyma(kirjoitusnopeudet);

        borderPane.setLeft(kyselynakyma.getNakyma());
        borderPane.setRight(tilastonakyma.getNakyma());

        Scene nakyma = new Scene(borderPane);

        List<Long> kirjoitusajat = new ArrayList<>();

        kyselynakyma.getSyoteKentta().setOnKeyReleased((event) -> {
            kyselynakyma.varitaSyoteKentta();
            // 1. tilastoidaan kirjoitusnopeutta
            long aika = System.nanoTime();
            kirjoitusajat.add(aika / 1_000_000);
            
            // 2. onko kirjoitettu sana oikein
            String syotettava = kyselynakyma.syotettavaSana().getText();
            if (syotettava.equals(kyselynakyma.getSyoteKentta().getText())) {
                double kirjoitusnopeus = kirjoitusajat.get(kirjoitusajat.size() - 1) - kirjoitusajat.get(0);
                kirjoitusnopeudet.lisaa(syotettava, kirjoitusnopeus);
                kirjoitusajat.clear();
                borderPane.setLeft(kyselynakyma.getNakyma());
                tilastonakyma.paivita();
                return;
            }
        });

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(KirjoitusharjoitteluSovellus.class);
    }
    
    public static String toteutettuOminaisuus() {
        return "(1) Kirjoitusajan tallennus oli väärässä paikassa; "
                + "Kaksikirjamiselta sanalta tallentui vain yksi aika, "
                + "joten aikojen vertailun tulos sanalle 'up' oli aina 0.\n"
                + "(2) Lisäsin listan, joka näyttää seuraavat sanat. "
                + "Kirjoittaminen on sujuvampaa kun näkee pari sanaa eteenpäin.\n"
                + "(3) TextField vaihtaa väriä kun kirjoittaa väärän kirjaimen.\n"
                + "(4) Ohjelma hakee paremman sanalistan netistä. Tilasto näyttää "
                + "viimeiset 10 sanaa järjestyksessä.";
    }

}
