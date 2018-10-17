
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

@Points("01-25")
public class MerkkijonojenVertailuTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void samatOvatSamat() {
        String syote = "apupapu";
        io.setSysIn(syote.substring(0, 3) + "\n" + syote.substring(0, 3) + "\n");

        int oldOut = io.getSysOut().length();
        callMain(MerkkijonojenVertailu.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        assertTrue("syötteellä: \"apu\" ja \"apu\" tulostit \"" + out + "\" kun pitäisi tulostaa \"Syötetyt merkkijonot olivat samat!\".", out.toLowerCase().contains("olivat") && !out.toLowerCase().contains("olleet"));
    }

    @Test
    public void eriOvatSamat() {
        String syote = "apupapu";
        io.setSysIn(syote.substring(0, 3) + "\n" + syote.substring(3, 7) + "\n");

        int oldOut = io.getSysOut().length();
        callMain(MerkkijonojenVertailu.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        assertTrue("syötteellä: \"apu\" ja \"papu\" tulostit \"" + out + "\" kun pitäisi tulostaa \"Syötetyt merkkijonot eivät olleet samat!\".", out.toLowerCase().contains("olleet") && !out.toLowerCase().contains("olivat"));
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("luethan syöteen käyttäjältä lukija.nextLine()-komennolla?");
        } catch (Throwable e) {
            fail("Jotain kummallista tapahtui. Saattaa olla että " + kl + "-luokan public static void main(String[] args) -metodi on hävinnyt\n"
                    + "tai ohjelmasi kaatui poikkeukseen. Lisätietoja " + e);
        }
    }
}
