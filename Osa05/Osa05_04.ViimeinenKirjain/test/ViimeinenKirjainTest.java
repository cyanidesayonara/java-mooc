
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("05-04")
public class ViimeinenKirjainTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void mainToimii() {
        io.setSysIn("Pekka");
        ViimeinenKirjain.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Pekka\" ohjelmasi pitäisi tulostaa Viimeinen kirjain: a", io.getSysOut().trim().endsWith("a"));
    }

    @Test
    public void mainToimii2() {
        io.setSysIn("Ohjelmointiako");
        ViimeinenKirjain.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Ohjelmointiako\" ohjelmasi pitäisi tulostaa Viimeinen kirjain: o", io.getSysOut().trim().endsWith("o"));
    }
}
