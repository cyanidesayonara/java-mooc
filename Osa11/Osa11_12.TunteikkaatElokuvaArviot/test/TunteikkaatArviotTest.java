
import arviot.TunteikkaatArviot;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

public class TunteikkaatArviotTest {

    @Test
    @Points("11-12.1")
    public void sanojenLukumaaraLyhyt1() {
        Map<String, Integer> sanojenLukumaarat = new HashMap<>();
        sanojenLukumaarat.put("with", 3);
        sanojenLukumaarat.put("it", 2);
        sanojenLukumaarat.put("not", 1);
        sanojenLukumaarat.put("happy", 0);

        tarkistaLukumaarat("src/arviot-lyhyt-1.txt", sanojenLukumaarat);
    }

    @Test
    @Points("11-12.1")
    public void sanojenLukumaaraLyhyt2() {
        Map<String, Integer> sanojenLukumaarat = new HashMap<>();
        sanojenLukumaarat.put("nothing", 2);
        sanojenLukumaarat.put("movie", 7);
        sanojenLukumaarat.put("best", 2);
        sanojenLukumaarat.put("expect", 1);
        sanojenLukumaarat.put("damme", 0);

        tarkistaLukumaarat("src/arviot-lyhyt-2.txt", sanojenLukumaarat);
    }

    @Test
    @Points("11-12.1")
    public void sanojenLukumaaraPitka() {
        Map<String, Integer> sanojenLukumaarat = new HashMap<>();
        sanojenLukumaarat.put("nothing", 123);
        sanojenLukumaarat.put("best", 159);
        sanojenLukumaarat.put("expect", 22);
        sanojenLukumaarat.put("damme", 2);
        sanojenLukumaarat.put("with", 1132);
        sanojenLukumaarat.put("it", 2402);
        sanojenLukumaarat.put("happy", 17);

        tarkistaLukumaarat("src/arviot.txt", sanojenLukumaarat);
    }

    private void tarkistaLukumaarat(String tiedosto, Map<String, Integer> sanojenLukumaarat) {
        TunteikkaatArviot arviot = new TunteikkaatArviot(lueRivit(tiedosto));

        for (String sana : sanojenLukumaarat.keySet()) {
            int oikeaLkm = sanojenLukumaarat.get(sana);
            int ehdotettuLkm = arviot.sanojenLukumaara(sana);
            assertEquals("Sana '" + sana + "' esiintyy tiedostossa '" + tiedosto + "' " + oikeaLkm + " kertaa. TunteikkaatArviot ehdottaa, että esiintymiä on " + ehdotettuLkm + ".", oikeaLkm, ehdotettuLkm);
        }
    }

    @Test
    @Points("11-12.2")
    public void sananTunneLyhyt1() {
        Map<String, Double> sanojenTunteet = new HashMap<>();
        sanojenTunteet.put("with", 2.333);
        sanojenTunteet.put("it", 3.0);
        sanojenTunteet.put("not", 2.0);
        sanojenTunteet.put("simply", 1.0);
        sanojenTunteet.put("tedious", 0.0);

        tarkistaTunne("src/arviot-lyhyt-1.txt", sanojenTunteet);
    }

    @Test
    @Points("11-12.2")
    public void sananTunneLyhyt2() {
        Map<String, Double> sanojenTunteet = new HashMap<>();
        sanojenTunteet.put("script", 0.0);
        sanojenTunteet.put("satire", 0.0);
        sanojenTunteet.put("has", 2.4);
        sanojenTunteet.put("should", 1.5);
        sanojenTunteet.put("movie", 2.0);

        tarkistaTunne("src/arviot-lyhyt-2.txt", sanojenTunteet);
    }

    @Test
    @Points("11-12.2")
    public void sananTunnePitka() {
        Map<String, Double> sanojenTunteet = new HashMap<>();
        sanojenTunteet.put("movie", 1.82);
        sanojenTunteet.put("satire", 1.55);
        sanojenTunteet.put("has", 2.13);
        sanojenTunteet.put("should", 1.76);
        sanojenTunteet.put("damme", 2.5);
        sanojenTunteet.put("norris", 2.0);

        tarkistaTunne("src/arviot.txt", sanojenTunteet);
    }

    private void tarkistaTunne(String tiedosto, Map<String, Double> sanojenTunteet) {
        TunteikkaatArviot arviot = new TunteikkaatArviot(lueRivit(tiedosto));

        for (String sana : sanojenTunteet.keySet()) {
            double tunne = sanojenTunteet.get(sana);
            double ehdotettu = arviot.sananTunne(sana);
            assertEquals("Sanan '" + sana + "' tunne tiedostosta '" + tiedosto + "' on " + tunne + ". TunteikkaatArviot ehdottaa, että tunne on " + ehdotettu + ".", tunne, ehdotettu, 0.1);
        }
    }

    @Test
    @Points("11-12.2")
    public void sananTunneMerkkijonona() {
        Map<String, String> sanojenTunteet = new HashMap<>();
        sanojenTunteet.put("movie", "negatiivinen");
        sanojenTunteet.put("satire", "negatiivinen");
        sanojenTunteet.put("has", "positiivinen");
        sanojenTunteet.put("should", "negatiivinen");
        sanojenTunteet.put("damme", "positiivinen");
        sanojenTunteet.put("norris", "neutraali");

        String tiedosto = "src/arviot.txt";
        TunteikkaatArviot arviot = new TunteikkaatArviot(lueRivit(tiedosto));

        for (String sana : sanojenTunteet.keySet()) {
            String tunne = sanojenTunteet.get(sana);
            String ehdotettu = arviot.sananTunneMerkkijonona(sana);
            assertEquals("Sanan '" + sana + "' tunne tiedostosta '" + tiedosto + "' on " + tunne + ". TunteikkaatArviot ehdottaa, että tunne on " + ehdotettu + ".", tunne, ehdotettu);
        }
    }

    @Test
    @Points("11-12.3")
    public void lauseenTunneLyhyt1() {
        Map<String, Double> lauseidenTunteet = new HashMap<>();
        lauseidenTunteet.put("unfocused tedious cinema", 0.0);
        lauseidenTunteet.put("immensely enjoyable experience", 2.6666);
        lauseidenTunteet.put("great job", 2.0);
        lauseidenTunteet.put("one of the best war movies ever", 1.91666);

        tarkistaLauseenTunne("src/arviot-lyhyt-1.txt", lauseidenTunteet);
    }

    @Test
    @Points("11-12.3")
    public void lauseenTunneLyhyt2() {
        Map<String, Double> lauseidenTunteet = new HashMap<>();
        lauseidenTunteet.put("unfocused tedious cinema", 2.0);
        lauseidenTunteet.put("immensely enjoyable experience", 2.0);
        lauseidenTunteet.put("great job", 2.0);
        lauseidenTunteet.put("decent material", 1.0);
        lauseidenTunteet.put("one of the best war movies ever", 2.96);

        tarkistaLauseenTunne("src/arviot-lyhyt-2.txt", lauseidenTunteet);
    }

    @Test
    @Points("11-12.3")
    public void lauseenTunnePitka() {
        Map<String, Double> lauseidenTunteet = new HashMap<>();
        lauseidenTunteet.put("chuck norris and van damme doing their best", 2.22);
        lauseidenTunteet.put("loved every minute of the movie", 2.24);
        lauseidenTunteet.put("a weak script with a boring finale", 1.75);
        lauseidenTunteet.put("wanted to poke out my eyeballs", 1.86);

        tarkistaLauseenTunne("src/arviot.txt", lauseidenTunteet);
    }

    @Test
    @Points("11-12.3")
    public void lauseenTunneMerkkijonona1() {
        Map<String, String> lauseidenTunteet = new HashMap<>();
        lauseidenTunteet.put("unfocused tedious cinema", "neutraali");
        lauseidenTunteet.put("immensely enjoyable experience", "neutraali");
        lauseidenTunteet.put("great job", "neutraali");
        lauseidenTunteet.put("decent material", "negatiivinen");
        lauseidenTunteet.put("one of the best war movies ever", "positiivinen");

        String tiedosto = "src/arviot-lyhyt-2.txt";

        TunteikkaatArviot arviot = new TunteikkaatArviot(lueRivit(tiedosto));
        for (String lause : lauseidenTunteet.keySet()) {
            String tunne = lauseidenTunteet.get(lause);
            String ehdotettu = arviot.lauseenTunneMerkkijonona(lause);
            assertEquals("Lauseen '" + lause + "' tunne tiedostosta '" + tiedosto + "' on " + tunne + ".\nTunteikkaatArviot ehdottaa, että tunne on " + ehdotettu + ".", tunne, ehdotettu);
        }
    }

    private void tarkistaLauseenTunne(String tiedosto, Map<String, Double> lauseidenTunteet) {
        TunteikkaatArviot arviot = new TunteikkaatArviot(lueRivit(tiedosto));

        for (String lause : lauseidenTunteet.keySet()) {
            double tunne = lauseidenTunteet.get(lause);
            double ehdotettu = arviot.lauseenTunne(lause);
            assertEquals("Lauseen '" + lause + "' tunne tiedostosta '" + tiedosto + "' on " + tunne + ".\nTunteikkaatArviot ehdottaa, että tunne on " + ehdotettu + ".", tunne, ehdotettu, 0.1);
        }
    }

    private static List<String> lueRivit(String tiedosto) {
        List<String> rivit = new ArrayList<>();

        // avataan resurssi
        try (Scanner lukija = new Scanner(new File(tiedosto))) {

            // käsitellään resurssia
            while (lukija.hasNextLine()) {
                rivit.add(lukija.nextLine());
            }

        } catch (Exception e) {
            // käsitellään mahdollinen poikkeus
            System.out.println("Virhe: " + e.getMessage());
        }

        return rivit;
    }
}
