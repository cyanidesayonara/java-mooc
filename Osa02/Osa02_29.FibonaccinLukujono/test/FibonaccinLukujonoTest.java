
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

@Points("02-29")
public class FibonaccinLukujonoTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testi() {
        int[][] syotteet = {{0, 0, 1, 1}, {7, 13}, {22, 17711}};

        for (int i = 0; i < syotteet.length; i++) {
            tarkista(syotteet[i]);
        }
    }

    private void tarkista(int... luvut) {
        int oldOut = io.getSysOut().length();

        String in = "";
        for (int i = 0; i < luvut.length - 1; i += 2) {
            in += luvut[i] + "\n";
        }

        in += "-1\n";

        io.setSysIn(in);
        callMain(FibonaccinLukujono.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        for (int i = 1; i < luvut.length - 1; i += 2) {
            assertTrue("Kun käyttäjä syöttää luvun \"" + luvut[i - 1] + "\", tulostetun luvun pitäisi olla \"" + luvut[i] + "\".\nSyöte:\n" + in + "\nTulostus:\n" + out, out.contains("" + luvut[i]));
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
}
