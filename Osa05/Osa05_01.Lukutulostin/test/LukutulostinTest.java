
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import junit.framework.Assert;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

public class LukutulostinTest {

    private static final String PISTE = "05-01";

    @Rule
    public MockStdio io = new MockStdio();

    String klass = "Lukutulostin";

    @Test
    public void luokkaLukutulostin() {
        Assert.assertTrue("Toteuta luokka Lukutulostin. Varmista että se on muotoa public " + klass + " {..", Reflex.reflect(klass).isPublic());
    }

    @Test
    public void luokallaOnParametritonKonstruktori() {
        luokkaLukutulostin();
        Reflex.reflect(klass).constructor().takingNoParams().requirePublic();
    }

    @Points(PISTE + ".1")
    @Test
    public void onMetodiLukuporras() {
        luokallaOnParametritonKonstruktori();
        Reflex.reflect(klass).method("lukuporras").returningVoid().taking(int.class).requirePublic();
    }

    @Points(PISTE + ".1")
    @Test
    public void lukuporras1() throws Throwable {
        kutsuLukuporras(1, "1");
    }

    @Points(PISTE + ".1")
    @Test
    public void lukuporras2() throws Throwable {
        kutsuLukuporras(2, "1", "1 2");
    }

    @Points(PISTE + ".1")
    @Test
    public void lukuporras5() throws Throwable {
        kutsuLukuporras(5, "1", "1 2", "1 2 3", "1 2 3 4", "1 2 3 4 5");
    }

    @Points(PISTE + ".1")
    @Test
    public void lukuporras7() throws Throwable {
        kutsuLukuporras(7, "1", "1 2", "1 2 3", "1 2 3 4", "1 2 3 4 5", "1 2 3 4 5 6", "1 2 3 4 5 6 7");
    }

    @Points(PISTE + ".2")
    @Test
    public void onMetodiJatkuvaLukuporras() {
        Reflex.reflect(klass).method("jatkuvaLukuporras").returningVoid().taking(int.class).requirePublic();
    }

    @Points(PISTE + ".2")
    @Test
    public void jatkuvaLukuporras1() throws Throwable {
        kutsuJatkuvaLukuporras(1, "1");
    }

    @Points(PISTE + ".2")
    @Test
    public void jatkuvaLukuporras2() throws Throwable {
        kutsuJatkuvaLukuporras(2, "1", "2 3");
    }

    @Points(PISTE + ".2")
    @Test
    public void jatkuvaLukuporras5() throws Throwable {
        kutsuJatkuvaLukuporras(5, "1", "2 3", "4 5 6", "7 8 9 10", "11 12 13 14 15");
    }

    @Points(PISTE + ".3")
    @Test
    public void onMetodiKertokolmio() {
        Reflex.reflect(klass).method("kertokolmio").returningVoid().taking(int.class).requirePublic();
    }

    @Points(PISTE + ".3")
    @Test
    public void kertokolmio1() throws Throwable {
        kutsuKertokolmio(1, "1");
    }

    @Points(PISTE + ".3")
    @Test
    public void kertokolmio2() throws Throwable {
        kutsuKertokolmio(3, "1", "2 4", "3 6 9");
    }

    @Points(PISTE + ".3")
    @Test
    public void kertokolmio6() throws Throwable {
        kutsuKertokolmio(6, "1", "2 4", "3 6 9", "4 8 12 16", "5 10 15 20 25", "6 12 18 24 30 36");
    }

    private Object luoLukutulostin() {
        try {
            return Reflex.reflect(klass).constructor().takingNoParams().invoke();
        } catch (Throwable ex) {
            fail("Kutsu new " + klass + "(); epäonnistui. Virhe: " + ex.getMessage());
        }

        return null;
    }

    public void kutsuLukuporras(int arvo, String... rivitJarj) throws Throwable {
        kutsuMetodi("lukuporras", arvo, rivitJarj);
    }

    public void kutsuJatkuvaLukuporras(int arvo, String... rivitJarj) throws Throwable {
        kutsuMetodi("jatkuvaLukuporras", arvo, rivitJarj);
    }

    public void kutsuKertokolmio(int arvo, String... rivitJarj) throws Throwable {
        kutsuMetodi("kertokolmio", arvo, rivitJarj);
    }

    public void kutsuMetodi(String metodi, int arvo, String... rivitJarj) throws Throwable {
        Object tulostin = luoLukutulostin();
        Reflex.reflect(klass).method(metodi).returningVoid().taking(int.class).invokeOn(tulostin, arvo);
        String output = io.getSysOut().trim();
        String[] lines = output.split("\n");

        assertTrue("Kun " + klass + "-oliolle tehdään metodikutsu " + metodi + "(" + arvo + "), tulee tulostuksessa olla " + rivitJarj.length + " riviä.", lines.length >= rivitJarj.length);

        for (int i = lines.length - 1; i > 0; i--) {
            assertTrue("Kun on kutsuttu metodia " + metodi + " parametrilla " + arvo + ", tulee rivillä " + (i + 1) + " olla arvo " + rivitJarj[i].trim() + ".\n Nyt rivi oli " + lines[i].trim(),
                    lines[i].trim().equals(rivitJarj[i].trim()));
        }
    }
}
