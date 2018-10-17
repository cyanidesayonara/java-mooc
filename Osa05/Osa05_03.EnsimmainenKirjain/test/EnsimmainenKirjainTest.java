
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("05-03")
public class EnsimmainenKirjainTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void mainToimii() {
        io.setSysIn("Pekka");
        EnsimmainenKirjain.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Pekka\" ohjelmasi pitäisi tulostaa Ensimmäinen kirjain: P",
                io.getSysOut().trim().endsWith("P"));

    }

    @Test
    public void mainToimii2() {
        io.setSysIn("Ohjelmointi on kivaa!!!");
        EnsimmainenKirjain.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Ohjelmointi on kivaa!!!\" ohjelmasi pitäisi tulostaa Ensimmäinen kirjain: O",
                io.getSysOut().trim().endsWith("O"));

    }
}
