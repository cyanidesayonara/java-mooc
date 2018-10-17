
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("02-16")
public class MarsinLampotilanKeskiarvoTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testi() {
        int[][] syotteet = {{5, 22, -11, -140, -18}, {1}, {3, 2, 1}, {-3, -2, -1, -141}};

        for (int i = 0; i < syotteet.length; i++) {
            tarkista(syotteet[i]);
        }
    }

    private void tarkista(int... luvut) {
        int oldOut = io.getSysOut().length();

        String in = "";
        int summa = 0;
        int hyvaksyttaviaLukuja = 0;
        for (int i = 0; i < luvut.length; i++) {
            in += luvut[i] + "\n";
            if(luvut[i] < -140 || luvut[i] > 20) {
                continue;
            }
            
            summa += luvut[i];
            hyvaksyttaviaLukuja++;            
        }
        
        in += "9999\n";
        

        io.setSysIn(in);
        callMain(MarsinLampotilanKeskiarvo.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        double vastaus = otaLukuLopusta(out);
        double odotettuVastaus = (1.0 * summa / hyvaksyttaviaLukuja);
        
        String virheIlm = "Syöte:\n" + in + "\n\n Odotettiin: \"" + odotettuVastaus + "\", tulostit: \"" + vastaus + "\"\n";
        assertEquals(virheIlm, odotettuVastaus, vastaus, 0.001);
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

    private static double otaLukuLopusta(String inputStr) {

        String patternStr = "(?s).*?(-?\\d+\\.\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("Tulostuksen pitäisi olla muotoa \"Mittausten keskiarvo: -167.0\". Nyt tulostit: " + inputStr, matcher.find());

        double luku = Double.parseDouble(matcher.group(1));
        return luku;
    }
}
