
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

@Points("07-04")
public class DebuggailuaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void tulostusYhteenSarakkeeseen1() {
        suorita("ok\n1\n", "o", "k");
    }

    @Test
    public void tulostusYhteenSarakkeeseen2() {
        suorita("testi\n1\n", "t", "e", "s", "t", "i");
    }

    @Test
    public void tulostusKahteenSarakkeeseen1() {
        suorita("ok\n2\n", "o", " k");
    }

    @Test
    public void tulostusKahteenSarakkeeseen2() {
        suorita("testi\n2\n", "t", " e", "s", " t", "i");
    }

    @Test
    public void tulostusKolmeenSarakkeeseen1() {
        suorita("ok\n3\n", "o", " k");
    }

    @Test
    public void tulostusKolmeenSarakkeeseen2() {
        suorita("testi\n3\n", "t", " e", "  s", "t", " i");
    }

    @Test
    public void tulostusKolmeenViiteenSarakkeeseen() {
        suorita("helloworld\n5\n", "h", " e", "  l", "   l", "    o", "w", " o", "  r", "   l", "    d");
    }

    public void suorita(String syote, String... odotetutRivit) {
        io.setSysIn(syote);
        Debuggailua.main(new String[]{});
        String output = io.getSysOut();
        String[] rivit = output.split("\n");

        assertTrue("Odotettiin, että tulostuksessa on vähintään " + odotetutRivit.length + " riviä, nyt niitä oli " + rivit.length + ".", odotetutRivit.length <= rivit.length);

        List<String> rivitListalla = Arrays.asList(rivit);

        for (String rivi : odotetutRivit) {
            assertTrue("Kun syöte on\n" + syote + "\n, pitäisi tulostuksessa olla rivi:\n" + rivi, rivitListalla.contains(rivi));
        }
    }
}
