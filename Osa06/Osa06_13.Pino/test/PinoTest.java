
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import org.junit.*;
import static org.junit.Assert.*;

@Points("06-13")
public class PinoTest {

    @Test
    public void kasvataMetodiKasvattaaPinonKokoaViidella() throws Throwable {
        Pino p = new Pino();
        String[] taulukko = p.getTaulukko();
        p.kasvata();
        assertTrue("Metodikutsun kasvata pitäisi kasvattaa pinon taulukon kokoa viidellä.", taulukko.length + 5 == p.getTaulukko().length);
    }

    @Test
    public void kasvataMetodiKopioiVanhatArvotUuteenTaulukkoon() throws Throwable {
        kasvataMetodiKasvattaaPinonKokoaViidella();

        Pino p = new Pino();
        p.lisaa(UUID.randomUUID().toString());
        p.lisaa(UUID.randomUUID().toString());
        String[] taulukko = p.getTaulukko();
        p.kasvata();
        String[] uusitaulukko = p.getTaulukko();
        
        assertNotSame("Kasvattamisen jälkeen taulukon pitäisi muuttua.", taulukko, uusitaulukko);

        for (int i = 0; i < taulukko.length; i++) {
            assertTrue("Metodikutsun kasvata tulee kopioida vanhan taulukon arvot uuteen.", Objects.equals(taulukko[i], uusitaulukko[i]));
        }
    }

    @Test
    public void pinoaVoiKasvattaaUseampaanKertaan() throws Throwable {
        Pino p = new Pino();
        String[] taulukko = p.getTaulukko();
        p.kasvata();
        p.kasvata();
        p.kasvata();
        assertTrue("Kun metodia kasvata kutsutaan kolmesti, pinon taulukon koon pitäisi olla kasvanut viidellätoista.", taulukko.length + 15 == p.getTaulukko().length);
    }

    @Test(timeout = 250)
    public void lisaysJaPoistoTest() throws Throwable {
        int montako = new Random().nextInt(50) + 50;

        ArrayList<String> lista = new ArrayList<>();
        Pino p = new Pino();

        while (lista.size() < montako) {
            String uusi = UUID.randomUUID().toString();
            lista.add(uusi);
            try {
                p.lisaa(uusi);
            } catch (Throwable t) {
                fail("Virhe kun pinoon lisättiin " + lista.size() + ". arvoa. Kokeile mitä käy kun lisäät pinoon " + lista.size() + " eri arvoa. Virhe: " + t.getMessage());
            }
        }

        while (lista.size() > 0) {
            try {
                lista.remove(p.poista());
            } catch (Throwable t) {
                fail("Kun pinoon oli ensin lisätty " + montako + " arvoa, ja sitten poistettu " + (montako-lista.size()) + " arvoa, tapahtui virhe. Kokeile mitä käy kun toistat virheen käsin. Virhe: " + t.getMessage());
            }
        }
    }
}
