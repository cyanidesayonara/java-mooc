
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;

@Points("05-02")
public class NimenPituusTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void mainToimii() {
        io.setSysIn("Pekka\n");
        NimenPituus.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Pekka\" ohjelmasi pitäisi tulostaa 5", io.getSysOut().contains("5") && !io.getSysOut().contains("9"));
    }

    @Test
    public void mainToimii2() {
        io.setSysIn("Elizabeth\n");
        NimenPituus.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Elizabeth\" ohjelmasi pitäisi tulostaa 9", io.getSysOut().contains("9") && !io.getSysOut().contains("5"));
    }

}
