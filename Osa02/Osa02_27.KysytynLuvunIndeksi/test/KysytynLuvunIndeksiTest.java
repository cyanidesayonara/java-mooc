
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("02-27")
public class KysytynLuvunIndeksiTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testi() {
        int[][] syotteet = {{51, 22, -11, -140, -18}, {1, 7}, {3, 2}, {-3, -2, -141, 22, 22, 7}};

        for (int i = 0; i < syotteet.length; i++) {
            tarkista(7, syotteet[i]);
            tarkista(22, syotteet[i]);
        }
    }

    private void tarkista(int haettava, int... luvut) {
        int oldOut = io.getSysOut().length();

        Set<Integer> indeksit = new HashSet<>();

        String in = "";
        for (int i = 0; i < luvut.length; i++) {
            in += luvut[i] + "\n";

            if (haettava == luvut[i]) {
                indeksit.add(i);
            }
        }

        in += "-1\n";
        in += "" + haettava + "\n";

        io.setSysIn(in);
        callMain(KysytynLuvunIndeksi.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        if (indeksit.isEmpty()) {
            assertTrue("Kun lukua ei löydy, niin luku tulee sisällyttää \"ei löydy\"-ilmoitukseen. Esim: \"Lukua 7 ei löydy.\". Nyt tulostus oli:\n" + out, out.contains(" " + haettava + " "));
            assertTrue("Kun lukua ei löydy, niin siitä pitää ilmoittaa. Esim: \"Lukua 7 ei löydy.\". Nyt tulostus oli:\n" + out, out.contains("ei"));
        } else {
            assertFalse("Kun luku löytyy, sanan \"ei\" ei pitäisi esiintyä tulostuksessa. Nyt tulostus oli:\n" + out, out.contains("ei"));

            for (int indeksi : indeksit) {
                assertTrue("Kun luku löytyy, tulostuksessa tulee kertoa kaikki indeksit, missä luku esiintyy.\nSyötteellä:\n" + in + "\nTulostus oli:\n" + out, out.contains(" " + indeksi));

            }
        }
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("Ohjelmasi koitti lukea liikaa syötettä. Muista lukea nextLine()-metodilla!");
        } catch (Throwable e) {
            fail(kl + "-luokan public static void main(String[] args) -metodi on hävinnyt "
                    + "tai jotain muuta odottamatonta tapahtunut, lisätietoja " + e);
        }
    }

    private static int otaLukuLopusta(String inputStr) {

        String patternStr = "(?s).*?(\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("Tulostuksen pitäisi olla muotoa \"Luku on indeksissä 10\". Nyt tulostit: " + inputStr, matcher.find());

        int luku = Integer.parseInt(matcher.group(1));
        return luku;
    }
}
