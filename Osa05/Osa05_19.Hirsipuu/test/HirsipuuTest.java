
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Points("05-19")
public class HirsipuuTest {

    @Rule
    public MockStdio io = new MockStdio();

    private String merkit = "abcdefghijklmnopqrstuvxyz";

    @Test
    public void peliVoitto() {
        String syote = "abcdefg\na\nb\nc\nd\ne\nf\ng\n";
        io.setSysIn(syote);
        Hirsipuu.main(new String[]{});

        String out = io.getSysOut();
        assertTrue("Kun syöte oli:\n" + syote + "\nOdotettiin että tulostuksessa olisi merkkijono \"Voitit!\". Tulostus oli:\n" + out, out.contains("Voitit!"));
        assertFalse("Kun syöte oli:\n" + syote + "\nOdotettiin että tulostuksessa ei olisi merkkijonoa \"Hävisit!\". Tulostus oli:\n" + out, out.contains("visit!"));
    }

    @Test
    public void peliVoittoSatunnainen() {
        Random rnd = new Random();
        int luku = rnd.nextInt(6);

        String sana = merkit.substring(luku, luku + 6);
        int indeksi = 0;
        String syote = "";
        while (indeksi < sana.length()) {
            syote += sana.charAt(indeksi) + "\n";
            indeksi++;
        }

        String input = sana + "\n" + syote;
        io.setSysIn(input);
        Hirsipuu.main(new String[]{});

        String out = io.getSysOut();
        assertTrue("Kun syöte oli:\n" + input + "\nOdotettiin että tulostuksessa olisi merkkijono \"Voitit!\". Tulostus oli:\n" + out, out.contains("Voitit!"));
        assertFalse("Kun syöte oli:\n" + input + "\nOdotettiin että tulostuksessa ei olisi merkkijonoa \"Hävisit!\". Tulostus oli:\n" + out, out.contains("visit!"));
    }

    @Test
    public void peliHavio() {
        String syote = "abcdefg\na\nb\nc\nd\ne\nf\nh\ni\nj\nk\nm\nn\no\np\nq\n";
        io.setSysIn(syote);
        Hirsipuu.main(new String[]{});

        String out = io.getSysOut();
        assertFalse("Kun syöte oli:\n" + syote + "\nOdotettiin että tulostuksessa ei olisi merkkijonoa \"Voitit!\". Tulostus oli:\n" + out, out.contains("Voitit!"));
        assertTrue("Kun syöte oli:\n" + syote + "\nOdotettiin että tulostuksessa olisi merkkijono \"Hävisit!\". Tulostus oli:\n" + out, out.contains("visit!"));
    }
}
