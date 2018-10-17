
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

@Points("06-11")
public class LukujenKasvattajaTest {

    @Test
    public void tarkistaKasvatus() {
        int[] taulukoidenPituudet = {1, 2, 3, 4, 5, 10, 20, 100};

        Random random = new Random();
        for (int i = 0; i < taulukoidenPituudet.length; i++) {
            int pituus = taulukoidenPituudet[i];
            int[] taulukko = new int[pituus];
            for (int j = 0; j < taulukko.length; j++) {
                taulukko[j] = random.nextInt(150);
            }

            tarkistaTaulukko(taulukko);
        }
    }

    private void tarkistaTaulukko(int[] taulukko) {
        int[] alkuperainen = Arrays.copyOf(taulukko, taulukko.length);

        int paljollakoKasvatetaan = new Random().nextInt(10);
        new LukujenKasvattaja().kasvata(taulukko, paljollakoKasvatetaan);

        for (int i = 0; i < taulukko.length; i++) {
            assertTrue("Kun taulukon arvoja kasvatetaan luvulla " + paljollakoKasvatetaan + ", taulukon jokaisen arvon pitäisi muuttua.\nAlkuperäinen taulukko oli: " + Arrays.toString(alkuperainen) + "\nKasvatuksen jälkeen: " + Arrays.toString(taulukko), taulukko[i] == alkuperainen[i] + paljollakoKasvatetaan);
        }
    }
}
