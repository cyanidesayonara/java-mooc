
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.*;
import static org.junit.Assert.*;

@Points("05-13.1 05-13.2")
public class PeltipoliisitTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void eiKaiVirhetta() throws Exception {
        io.setSysIn("HA-123;132\n\n");
        try {
            Peltipoliisit.main(new String[0]);
        } catch (Exception e) {
            String v = "\n\npaina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                    + "\"Caused by\"\n"
                    + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville";

            throw new Exception("syötteellä \"HA-123;132\"" + v, e);
        }
    }

    @Test
    public void suurinTesti1() {
        String syote = "HA-123;132\n\n";
        io.setSysIn(syote);
        Peltipoliisit.main(new String[0]);

        String[] rivit = io.getSysOut().split("\n");

        List<String> keratyt = Arrays.stream(rivit).filter(p -> p.contains("Suurin")).collect(Collectors.toList());
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"Suurin\" on 1.\nNyt rivejä oli " + keratyt.size() + ".", keratyt.size() == 1);
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Suurin: HA-123, 132\". Nyt rivi oli\n " + keratyt.get(0), keratyt.get(0).contains("Suurin: HA-123, 132"));
    }

    @Test
    public void suurinTesti2() {
        String syote = "HA-123;132\nHUH-1;5\nHEH-321;152\n\n";
        io.setSysIn(syote);
        Peltipoliisit.main(new String[0]);

        String[] rivit = io.getSysOut().split("\n");

        List<String> keratyt = Arrays.stream(rivit).filter(p -> p.contains("Suurin")).collect(Collectors.toList());
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"Suurin\" on 1.\nNyt rivejä oli " + keratyt.size() + ".", keratyt.size() == 1);
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Suurin: HEH-321, 152\". Nyt rivi oli\n " + keratyt.get(0), keratyt.get(0).contains("Suurin: HEH-321, 152"));
    }

    @Test
    public void pieninTesti1() {
        String syote = "HA-123;132\n\n";
        io.setSysIn(syote);
        Peltipoliisit.main(new String[0]);

        String[] rivit = io.getSysOut().split("\n");

        List<String> keratyt = Arrays.stream(rivit).filter(p -> p.contains("Pienin")).collect(Collectors.toList());
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"Pienin\" on 1.\nNyt rivejä oli " + keratyt.size() + ".", keratyt.size() == 1);
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Pienin: HA-123, 132\". Nyt rivi oli\n " + keratyt.get(0), keratyt.get(0).contains("Pienin: HA-123, 132"));
    }

    @Test
    public void pieninTesti2() {
        String syote = "HA-123;132\nHUH-1;5\nHEH-321;152\n\n";
        io.setSysIn(syote);
        Peltipoliisit.main(new String[0]);

        String[] rivit = io.getSysOut().split("\n");

        List<String> keratyt = Arrays.stream(rivit).filter(p -> p.contains("Pienin")).collect(Collectors.toList());
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"Pienin\" on 1.\nNyt rivejä oli " + keratyt.size() + ".", keratyt.size() == 1);
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Pienin: HUH-1, 5\". Nyt rivi oli\n " + keratyt.get(0), keratyt.get(0).contains("Pienin: HUH-1, 5"));
    }

    @Test
    public void keskiarvoTest1() {
        String syote = "HA-123;132\n\n";
        io.setSysIn(syote);
        Peltipoliisit.main(new String[0]);

        String[] rivit = io.getSysOut().split("\n");

        List<String> keratyt = Arrays.stream(rivit).filter(p -> p.contains("Keskiarvo")).collect(Collectors.toList());
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"Keskiarvo\" on 1.\nNyt rivejä oli " + keratyt.size() + ".", keratyt.size() == 1);
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Keskiarvo: 132.0\". Nyt rivi oli\n " + keratyt.get(0), keratyt.get(0).contains("Keskiarvo: 132.0"));
    }

    @Test
    public void keskiarvoTest2() {
        String syote = "HA-123;132\nHUH-1;5\nHEH-321;152\n\n";
        io.setSysIn(syote);
        Peltipoliisit.main(new String[0]);

        String[] rivit = io.getSysOut().split("\n");

        List<String> keratyt = Arrays.stream(rivit).filter(p -> p.contains("Keskiarvo")).collect(Collectors.toList());
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"Keskiarvo\" on 1.\nNyt rivejä oli " + keratyt.size() + ".", keratyt.size() == 1);
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Keskiarvo: 96.33333333333333\". Nyt rivi oli\n " + keratyt.get(0), keratyt.get(0).contains("Keskiarvo: 96.333"));
    }

}
