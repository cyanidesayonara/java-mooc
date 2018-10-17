
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("06-16")
public class KaikkiPINKooditTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void tulostuksessa10000Rivia() throws Throwable {
        KaikkiPINKoodit.main(new String[]{});
        assertTrue("Odotettiin, että tulostuksessa on 10000 riviä. Nyt niitä oli " + io.getSysOut().split("\n").length, io.getSysOut().split("\n").length == 10000);
    }

    @Test
    public void ensimmainenRivi0000() throws Throwable {
        KaikkiPINKoodit.main(new String[]{});
        assertTrue("Odotettiin, että ensimmäinen rivi on \"0000\". Nyt ensimmäinen rivi oli \"" + io.getSysOut().split("\n")[0] + "\".", io.getSysOut().split("\n")[0].trim().equals("0000"));
    }

    @Test
    public void viimeinenRivi9999() throws Throwable {
        KaikkiPINKoodit.main(new String[]{});
        int riveja = io.getSysOut().split("\n").length;
        assertTrue("Odotettiin, että viimeinen rivi on \"9999\". Nyt viimeinen rivi oli \"" + io.getSysOut().split("\n")[riveja - 1] + "\".", io.getSysOut().split("\n")[riveja - 1].trim().equals("9999"));
    }

}
