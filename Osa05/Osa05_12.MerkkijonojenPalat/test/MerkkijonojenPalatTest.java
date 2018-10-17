
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.*;
import static org.junit.Assert.*;

@Points("05-12")
public class MerkkijonojenPalatTest {

    @Rule
    public MockStdio io = new MockStdio();

    public String sanitize(String s) {
        return s.replaceAll("\r\n", "\n").replaceAll("\r", "\n").replaceAll("\n", " ").replaceAll("  ", " ");
    }

    @Test
    public void eiKaiVirhetta() throws Exception {
        io.setSysIn("Ihme lause?\n");
        try {
            MerkkijonojenPalat.main(new String[0]);
        } catch (Exception e) {
            String v = "\n\npaina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                    + "\"Caused by\"\n"
                    + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville";

            throw new Exception("syötteellä \"Ihme lause?\"" + v, e);
        }
    }

    @Test
    public void testi1() {
        io.setSysIn("Ihme lause?\n");
        MerkkijonojenPalat.main(new String[0]);

        String[] palat = io.getSysOut().split("\\s+");

        List<String> keratyt = Arrays.stream(palat).filter(p -> p.equals("Ihme") || p.equals("lause?")).collect(Collectors.toList());
        assertTrue("Kun syöte on \"Ihme lause?\", tulostuksen pitäisi olla täsmälleen muotoa:\nIhme\nlause?\n\n Nyt tulostus oli:\n" + io.getSysOut(), keratyt.size() == 2);
        assertTrue("Kun syöte on \"Ihme lause?\", tulostuksen pitäisi olla täsmälleen muotoa:\nIhme\nlause?\n\n Nyt tulostus oli:\n" + io.getSysOut(), keratyt.contains("Ihme"));
        assertTrue("Kun syöte on \"Ihme lause?\", tulostuksen pitäisi olla täsmälleen muotoa:\nIhme\nlause?\n\n Nyt tulostus oli:\n" + io.getSysOut(), keratyt.contains("lause?"));
    }

    @Test
    public void testi2() {
        io.setSysIn("Olipa kerran ohjelmointi\n");
        MerkkijonojenPalat.main(new String[0]);

        String[] palat = io.getSysOut().split("\\s+");

        List<String> keratyt = Arrays.stream(palat).filter(p -> p.equals("Olipa") || p.equals("kerran") || p.equals("ohjelmointi")).collect(Collectors.toList());
        assertTrue("Kun syöte on \"Olipa kerran ohjelmointi\", tulostuksen pitäisi olla täsmälleen muotoa:\nOlipa\nkerran\nohjelmointi\n\n Nyt tulostus oli:\n" + io.getSysOut(), keratyt.size() == 3);
        assertTrue("Kun syöte on \"Olipa kerran ohjelmointi\", tulostuksen pitäisi olla täsmälleen muotoa:\nOlipa\nkerran\nohjelmointi\n\n Nyt tulostus oli:\n" + io.getSysOut(), keratyt.contains("Olipa"));
        assertTrue("Kun syöte on \"Olipa kerran ohjelmointi\", tulostuksen pitäisi olla täsmälleen muotoa:\nOlipa\nkerran\nohjelmointi\n\n Nyt tulostus oli:\n" + io.getSysOut(), keratyt.contains("kerran"));
        assertTrue("Kun syöte on \"Olipa kerran ohjelmointi\", tulostuksen pitäisi olla täsmälleen muotoa:\nOlipa\nkerran\nohjelmointi\n\n Nyt tulostus oli:\n" + io.getSysOut(), keratyt.contains("ohjelmointi"));
    }
}
