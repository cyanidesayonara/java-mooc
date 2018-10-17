
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class YhdistinTest extends ApplicationTest {

    static {
        if (Boolean.getBoolean("SERVER")) {

            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("glass.platform", "Monocle");
            System.setProperty("monocle.platform", "Headless");
            System.setProperty("java.awt.headless", "false");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        new KuvaSovellus().start(stage);
    }

    @Test
    @Points("06-19.1")
    public void tummimmanYhdistysToimii() {

        WritableImage kuva = yhdistaKuvat("tummin", "black.png", "ilta-small.jpg", "white.png");
        WritableImage alkup = yhdistaKuvat("tummin", "black.png");
        assertTrue("Kun kuvia yhdistetään, yhdistetyn kuvan leveyden ja korkeuden tulee olla sama kuin yhdistettävillä kuvilla.", 100 == (int) kuva.getWidth() && 67 == (int) kuva.getHeight());

        int leveys = (int) kuva.getWidth();
        int korkeus = (int) kuva.getHeight();

        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int testX = rnd.nextInt(leveys);
            int testY = rnd.nextInt(korkeus);

            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on tummin, nyt punainen väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getRed(), kuva.getPixelReader().getColor(testX, testY).getRed(), 0.0001);
            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on tummin, nyt vihreä väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getGreen(), kuva.getPixelReader().getColor(testX, testY).getGreen(), 0.0001);
            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on tummin, nyt sininen väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getBlue(), kuva.getPixelReader().getColor(testX, testY).getBlue(), 0.0001);
        }
    }

    @Test
    @Points("06-19.2")
    public void mediaaniToimiiOsaYksi() {

        WritableImage kuva = yhdistaKuvat("mediaani", "white.png", "black.png", "black.png");
        WritableImage alkup = yhdistaKuvat("mediaani", "black.png");
        assertTrue("Kun kuvia yhdistetään, yhdistetyn kuvan leveyden ja korkeuden tulee olla sama kuin yhdistettävillä kuvilla.", 100 == (int) kuva.getWidth() && 67 == (int) kuva.getHeight());

        int leveys = (int) kuva.getWidth();
        int korkeus = (int) kuva.getHeight();

        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int testX = rnd.nextInt(leveys);
            int testY = rnd.nextInt(korkeus);

            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on mediaani, nyt punainen väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getRed(), kuva.getPixelReader().getColor(testX, testY).getRed(), 0.0001);
            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on mediaani, nyt vihreä väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getGreen(), kuva.getPixelReader().getColor(testX, testY).getGreen(), 0.0001);
            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on mediaani, nyt sininen väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getBlue(), kuva.getPixelReader().getColor(testX, testY).getBlue(), 0.0001);
        }
    }

    @Test
    @Points("06-19.2")
    public void mediaaniToimiiOsaKaksi() {

        WritableImage kuva = yhdistaKuvat("mediaani", "white.png", "white.png", "black.png", "black.png", "white.png");
        WritableImage alkup = yhdistaKuvat("mediaani", "white.png");
        assertTrue("Kun kuvia yhdistetään, yhdistetyn kuvan leveyden ja korkeuden tulee olla sama kuin yhdistettävillä kuvilla.", 100 == (int) kuva.getWidth() && 67 == (int) kuva.getHeight());

        int leveys = (int) kuva.getWidth();
        int korkeus = (int) kuva.getHeight();

        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int testX = rnd.nextInt(leveys);
            int testY = rnd.nextInt(korkeus);

            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on mediaani, nyt punainen väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getRed(), kuva.getPixelReader().getColor(testX, testY).getRed(), 0.0001);
            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on mediaani, nyt vihreä väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getGreen(), kuva.getPixelReader().getColor(testX, testY).getGreen(), 0.0001);
            assertEquals("Yhdistathan kuvien väriarvot oikein kun yhdistimen tyyppi on mediaani, nyt sininen väri ei ollut oikein asetettuna yhdistetyssä kuvassa.", alkup.getPixelReader().getColor(testX, testY).getBlue(), kuva.getPixelReader().getColor(testX, testY).getBlue(), 0.0001);
        }
    }

    private WritableImage yhdistaKuvat(String yhdistinTyyppi, String... kuvapolut) {
        Yhdistin yhdistin = new Yhdistin();

        ArrayList<Image> kuvat = Arrays.stream(kuvapolut)
                .map(tiedosto -> new Image("file:" + tiedosto))
                .collect(Collectors.toCollection(ArrayList::new));

        if (yhdistinTyyppi.equals("tummin")) {
            return yhdistin.tummin(kuvat);
        }

        if (yhdistinTyyppi.equals("mediaani")) {
            return yhdistin.mediaani(kuvat);
        }

        return null;
    }

}
