
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("02-18")
public class VihjaavaArvauspeliTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testi() {
        int[][] syotteet = {{1, 6, 10, 11, 0, 42}, {42}, {123, 42}, {-3, -2, -1, -141, 42}};

        for (int i = 0; i < syotteet.length; i++) {
            tarkista(syotteet[i]);
        }
    }

    private void tarkista(int... luvut) {
        int oldOut = io.getSysOut().length();

        List<String> odotetutSanat = new ArrayList<>();

        String in = "";
        int arvauksia = 0;
        for (int i = 0; i < luvut.length; i++) {
            in += luvut[i] + "\n";
            if (luvut[i] < 1 || luvut[i] > 100) {
                continue;
            }

            if (luvut[i] < 42) {
                odotetutSanat.add("isompi");
            }
            if (luvut[i] > 42) {
                odotetutSanat.add("pienempi");
            }

            arvauksia++;
        }

        io.setSysIn(in);
        callMain(VihjaavaArvauspeli.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        for (String odotettu : odotetutSanat) {
            if (!out.contains(odotettu)) {
                fail("Syöte:\n" + in + "\nOdotettiin sanaa \"" + odotettu + "\", mutta sitä ei löytynyt.");
            }
        }

        if (!odotetutSanat.contains("isompi") && out.contains("isompi")) {
            fail("Syöte:\n" + in + "\nEi odotettu sanaa \"isompi\".");
        }
        if (!odotetutSanat.contains("pienempi") && out.contains("pienempi")) {
            fail("Syöte:\n" + in + "\nEi odotettu sanaa \"pienempi\".");
        }

        int vastaus = otaLukuLopusta(out);
        int odotettuVastaus = arvauksia;

        String virheIlm = "Syöte:\n" + in + "\n\n Odotettiin: \"" + odotettuVastaus + "\", tulostit: \"" + vastaus + "\"\n";
        assertEquals(virheIlm, odotettuVastaus, vastaus);
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

        String patternStr = "(?s).*?(-?\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("Viimeisen tulostuksen pitäisi olla muotoa \"Oikein! Arvauksia yhteensä: 3\". Nyt tulostit: " + inputStr, matcher.find());

        return Integer.parseInt(matcher.group(1));
    }
}
