
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.*;
import static org.junit.Assert.*;

@Points("05-15")
public class FillarointiaBaanallaOsa2Test {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void eiKaiVirhetta() throws Exception {
        io.setSysIn("2014\ntammi\n");
        try {
            FillarointiaBaanallaOsa2.main(new String[0]);
        } catch (Exception e) {
            String v = "\n\npaina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                    + "\"Caused by\"\n"
                    + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville";

            throw new Exception("syötteellä:\n2014\ntammi\n" + v, e);
        }
    }

    @Test
    public void maalis2014Test() {
        String syote = "2014\nmaalis\n";
        io.setSysIn(syote);
        FillarointiaBaanallaOsa2.main(new String[0]);

        String[] rivit = io.getSysOut().split("\n");

        List<String> tunnissa = Arrays.stream(rivit).filter(p -> p.contains("tunnissa: ")).collect(Collectors.toList());
        List<String> paivassa = Arrays.stream(rivit).filter(p -> p.contains("iv")).collect(Collectors.toList());
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"tunnissa\" on 1.\nNyt rivejä oli " + tunnissa.size() + ".", tunnissa.size() == 1);
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"päivässä\" on 1.\nNyt rivejä oli " + paivassa.size() + ".", paivassa.size() == 1);

        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Pyöräilijöitä keskimäärin tunnissa: 46.43817204301075\". Nyt rivi oli\n " + tunnissa.get(0), tunnissa.get(0).contains("tunnissa: 46.4"));
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Pyöräilijöitä keskimäärin päivässä: 1114.516129032258\". Nyt rivi oli\n " + paivassa.get(0), paivassa.get(0).contains(": 1114.5"));
    }

    @Test
    public void syys2015Test() {
        String syote = "2015\nsyys\n";
        io.setSysIn(syote);
        FillarointiaBaanallaOsa2.main(new String[0]);

        String[] rivit = io.getSysOut().split("\n");

        List<String> tunnissa = Arrays.stream(rivit).filter(p -> p.contains("tunnissa: ")).collect(Collectors.toList());
        List<String> paivassa = Arrays.stream(rivit).filter(p -> p.contains("iv")).collect(Collectors.toList());
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"tunnissa\" on 1.\nNyt rivejä oli " + tunnissa.size() + ".", tunnissa.size() == 1);
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin, että rivejä, joissa merkkijono \"päivässä\" on 1.\nNyt rivejä oli " + paivassa.size() + ".", paivassa.size() == 1);

        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Pyöräilijöitä keskimäärin tunnissa: 149.5625\". Nyt rivi oli\n " + tunnissa.get(0), tunnissa.get(0).contains("tunnissa: 149.5"));
        assertTrue("Syöte oli:\n" + syote + "\nOdotettiin riviä \"Pyöräilijöitä keskimäärin päivässä: 3589.5\". Nyt rivi oli\n " + paivassa.get(0), paivassa.get(0).contains(": 3589."));
    }

}
