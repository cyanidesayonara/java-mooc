import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

public class KopiointiJaKaantaminenTest {

    Reflex.ClassRef<Object> klass;
    String klassName = "Taulukot";

    @Points("06-12.1")
    @Test
    public void onMetodiKopioi() throws Throwable {
        klass = Reflex.reflect(klassName);
        String metodinNimi = "kopioi";

        assertTrue("tee luokalle " + klassName + " metodi public int[] " + metodinNimi + "(int[] taulukko) ",
                klass.method(metodinNimi).returning(int[].class).
                taking(int[].class).isPublic());

        int[] t = {1, 2, 3};

        String v = "\nVirheen aiheuttanut koodi int[] t = {1,2,3}; " + klassName + "." + metodinNimi + "(t);";

        klass.method(metodinNimi).returning(int[].class).
                taking(int[].class).withNiceError(v).invokeOn(new Taulukot(), t);
    }

    @Points("06-12.1")
    @Test
    public void kopiointi1() {
        int[] alkup = {1, 2, 3};
        int[] kopio = kopioi(alkup);

        assertArrayEquals("metodi kopioi ei toimi oikein syötteellä " + toS(alkup), alkup, kopio);

        kopio[0] = 0;
        assertEquals("Kopion muuttaminen muuttaa alkuperäistä, eli metodisi ei tee kopioa parametrina annetusta taulukosta! Tarkasta mitä tapahtuu seuraavalla koodilla:\n"
                + "int[] alkup = {1, 2, 3}; int[] kopio = new Taulukot().kopioi(alkup); kopio[0]=0; System.out.println(alkup[0]); ", 1, alkup[0]);
    }
    Random arpa = new Random();

    @Points("06-12.1")
    @Test
    public void kopiointi2() {
        int n = arpa.nextInt(5) + 5;

        int[] alkup = new int[n];
        for (int i = 0; i < alkup.length; i++) {
            alkup[i] = arpa.nextInt(20);
        }
        int eka = alkup[0];
        int[] kopio = kopioi(alkup);

        assertArrayEquals("metodi kopioi ei toimi oikein syötteellä " + toS(alkup), alkup, kopio);

        kopio[0] = 0;
        assertEquals("Kopion muuttaminen muuttaa alkuperäistä, eli metodisi ei tee kopioa parametrina annetusta taulukosta! Tarkasta mitä tapahtuu seuraavalla koodilla: "
                + "int[] alkup = {1, 2, 3}; int[] kopio = new Taulukot().kopioi(alkup); kopio[0]=0; System.out.println(alkup[0]); ", eka, alkup[0]);
    }

    @Points("06-12.1")
    @Test
    public void kopiointi3() {
        int n = arpa.nextInt(10) + 10;

        int[] alkup = new int[n];
        for (int i = 0; i < alkup.length; i++) {
            alkup[i] = arpa.nextInt(20);
        }

        int eka = alkup[0];
        int[] kopio = kopioi(alkup);

        assertArrayEquals("metodi kopioi ei toimi oikein syötteellä " + toS(alkup), alkup, kopio);

        kopio[0] = 0;
        assertEquals("Kopion muuttaminen muuttaa alkuperäistä, eli metodisi ei tee kopioa parametrina annetusta taulukosta! Tarkasta mitä tapahtuu seuraavalla koodilla: \n"
                + "int[] alkup = {1, 2, 3}; int[] kopio = new Taulukot().kopioi(alkup); kopio[0]=0; System.out.println(alkup[0]); ", eka, alkup[0]);
    }

    /*
     * 
     */
    @Points("06-12.2")
    @Test
    public void onMetodiKaanna() throws Throwable {
        klass = Reflex.reflect(klassName);
        String metodinNimi = "kaanna";

        assertTrue("tee luokalle " + klassName + " metodi public int[] " + metodinNimi + "(int[] taulukko) ",
                klass.method(metodinNimi).returning(int[].class).
                taking(int[].class).isPublic());

        int[] t = {1, 2, 3};

        String v = "\nVirheen aiheuttanut koodi int[] t = {1,2,3}; " + klassName + "." + metodinNimi + "(t);";

        klass.method(metodinNimi).returning(int[].class).
                taking(int[].class).withNiceError(v).invokeOn(new Taulukot(), t);
    }
    @Points("06-12.2")
    @Test
    public void kaanto1() {
        int[] alkup = {1, 2, 3};
        int[] kopio = kaanna(alkup);
        int[] odotettu = {3, 2, 1};

        assertArrayEquals("metodi kaanna ei toimi oikein syötteellä " + toS(alkup), odotettu, kopio);

        assertEquals("Kääntäminen ei saa muuttaa parametrina annettua taulukkoa! Tarkasta mitä tapahtuu seuraavalla koodilla: "
                + "int[] alkup = {1, 2, 3}; int[] kaannettu = new Taulukot().kaanna(alkup); System.out.println(alkup[0]); ", 1, alkup[0]);
    }

    @Points("06-12.2")
    @Test
    public void kaanto2() {
        int n = arpa.nextInt(5) + 5;

        int[] alkup = new int[n];
        int[] odotettu = new int[n];

        for (int i = 0; i < odotettu.length; i++) {
            int arvottu = arpa.nextInt(20);
            alkup[i] = arvottu;
            odotettu[n - 1 - i] = arvottu;
        }

        int eka = alkup[0];
        int[] kopio = kaanna(alkup);

        assertArrayEquals("metodi kaanna ei toimi oikein syötteellä " + toS(alkup), odotettu, kopio);

        assertEquals("Kääntäminen ei saa muuttaa parametrina annettua taulukkoa! Tarkasta mitä tapahtuu seuraavalla koodilla: "
                + "int[] alkup = {1, 2, 3}; int[] kaannettu = new Taulukot().kaanna(alkup); System.out.println(alkup[0]); ", eka, alkup[0]);
    }

    @Points("06-12.2")
    @Test
    public void kaanto3() {
        int n = arpa.nextInt(10) + 10;

        int[] alkup = new int[n];
        int[] odotettu = new int[n];

        for (int i = 0; i < odotettu.length; i++) {
            int arvottu = arpa.nextInt(20);
            alkup[i] = arvottu;
            odotettu[n - 1 - i] = arvottu;
        }

        int eka = alkup[0];
        int[] kopio = kaanna(alkup);

        assertArrayEquals("metodi kaanna ei toimi oikein syötteellä " + toS(alkup), odotettu, kopio);

        assertEquals("Kääntäminen ei saa muuttaa parametrina annettua taulukkoa! Tarkasta mitä tapahtuu seuraavalla koodilla: "
                + "int[] alkup = {1, 2, 3}; int[] kaannettu = new Taulukot().kaanna(alkup); System.out.println(alkup[0]); ", eka, alkup[0]);
    }

    /*
     * 
     */
    private int[] kopioi(int[] t) {
        try {
            String[] args = new String[0];
            Method m = ReflectionUtils.requireMethod(Taulukot.class, "kopioi", int[].class);

            return ReflectionUtils.invokeMethod(int[].class, m, new Taulukot(), t);
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("metodissa kopioi viitataan taulukon ulkopuolelle kun syötteenä on " + toS(t));
        } catch (NullPointerException e) {
            fail("metodissa kopioi taidetaan viitata taulukkoon jota ei ole luotu new int[...] -komennolla");
        } catch (Throwable e) {
            fail("eikai metodi kopioi palauta null?");
        }
        return null;
    }

    private int[] kaanna(int[] t) {
        try {
            String[] args = new String[0];
            Method m = ReflectionUtils.requireMethod(Taulukot.class, "kaanna", int[].class);

            return ReflectionUtils.invokeMethod(int[].class, m, new Taulukot(), t);
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("metodissa kaanna viitataan taulukon ulkopuolelle kun syötteenä on " + toS(t));
        } catch (NullPointerException e) {
            fail("metodissa kaanna taidetaan viitata taulukkoon jota ei ole luotu new int[...] -komennolla");
        } catch (Throwable e) {
            fail("eikai metodi kaanna palauta null?");
        }
        return null;
    }

    private String toS(int[] t) {
        return Arrays.toString(t).replace("[", "").replace("]", "");
    }
}
