
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

@Points("01-29")
public class LaskinTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testaaSumma() {
        tarkista("+", 3, 6);
        tarkista("+", 37, 99);
        tarkista("+", 4, 1);
    }

    @Test
    public void testaaErotus() {
        tarkista("-", 3, 6);
        tarkista("-", 99, 37);
        tarkista("-", 4, 1);
    }

    @Test
    public void testaaTulo() {
        tarkista("*", 3, 6);
        tarkista("*", 99, 37);
        tarkista("*", 4, 1);
    }

    @Test
    public void testaaJako() {
        tarkista("*", 3, 6);
        tarkista("*", 99, 37);
        tarkista("*", 4, 1);
    }

    @Test
    public void testaaSatunnainen() {
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int eka = rnd.nextInt(1000) + 1;
            int toka = rnd.nextInt(1000) + 1;

            tarkista("+", eka, toka);
            tarkista("-", eka, toka);
            tarkista("*", eka, toka);
            tarkista("/", eka, toka);
        }
    }

    private void tarkista(String operaatio, int eka, int toka) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(eka + "\n" + toka + "\n" + operaatio + "\n");
        callMain(Laskin.class);
        String out = io.getSysOut().substring(oldOut);

        String tulos = laske(operaatio, eka, toka);

        assertTrue("Odotettiin " + tulos + " kun lasku oli " + eka + " " + operaatio + " " + toka + ".\n Nyt tulostus oli:\n" + out, out.contains(tulos));

    }

    private String laske(String operaatio, int eka, int toka) {
        switch (operaatio) {
            case "+":
                return "" + (eka + toka);
            case "-":
                return "" + (eka - toka);
            case "*":
                return "" + (eka * toka);
        }

        return "" + (1.0 * eka / toka);
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (Throwable e) {
            fail("Jotain kummallista tapahtui. Saattaa olla että " + kl + "-luokan public static void main(String[] args) -metodi on hävinnyt\n"
                    + "tai ohjelmasi kaatui poikkeukseen. Lisätietoja " + e);
        }
    }
}
