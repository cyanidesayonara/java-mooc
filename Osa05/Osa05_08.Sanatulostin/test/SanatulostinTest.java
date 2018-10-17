
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import junit.framework.Assert;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

public class SanatulostinTest {

    private static final String PISTE = "05-08";

    @Rule
    public MockStdio io = new MockStdio();

    String klass = "Sanatulostin";

    @Test
    public void luokkaSanatulostin() {
        Assert.assertTrue("Toteuta luokka " + klass + ". Varmista että se on muotoa public " + klass + " {..", Reflex.reflect(klass).isPublic());
    }

    @Test
    public void luokallaParametrillinenKonstruktori() {
        Reflex.reflect(klass).constructor().taking(String.class).requireExists();
    }

    @Points(PISTE + ".1")
    @Test
    public void onMetodiSanaporras() {
        Reflex.reflect(klass).method("sanaporras").returningVoid().taking(int.class).requirePublic();
    }

    @Points(PISTE + ".1")
    @Test
    public void sanaporras1() throws Throwable {
        kutsuSanaporras("nauris", 2, "n", "au");
    }

    @Points(PISTE + ".1")
    @Test
    public void sanaporras2() throws Throwable {
        kutsuSanaporras("nauris", 3, "n", "au", "ris");
    }

    @Points(PISTE + ".1")
    @Test
    public void sanaporras3() throws Throwable {
        kutsuSanaporras("nauris", 4, "n", "au", "ris", "naur");
    }

    @Points(PISTE + ".1")
    @Test
    public void sanaporras4() throws Throwable {
        kutsuSanaporras("ronsu", 3, "r", "on", "sur");
    }

    @Points(PISTE + ".1")
    @Test
    public void sanaporras5() throws Throwable {
        kutsuSanaporras("vara-asentaja", 6, "v", "ar", "a-a", "sent", "ajava", "ra-ase");
    }

    @Points(PISTE + ".2")
    @Test
    public void onMetodiLaskevaSanaporras() {
        Reflex.reflect(klass).method("laskevaSanaporras").returningVoid().taking(int.class).requirePublic();
    }

    @Points(PISTE + ".2")
    @Test
    public void laskevaSanaporras1() throws Throwable {
        kutsuLaskevaSanaporras("nauris", 1, "n");
    }

    @Points(PISTE + ".2")
    @Test
    public void laskevaSanaporras2() throws Throwable {
        kutsuLaskevaSanaporras("nauris", 2, "na", "u");
    }

    @Points(PISTE + ".2")
    @Test
    public void laskevaSanaporras3() throws Throwable {
        kutsuLaskevaSanaporras("nauris", 3, "nau", "ri", "s");
    }

    @Points(PISTE + ".2")
    @Test
    public void laskevaSanaporras4() throws Throwable {
        kutsuLaskevaSanaporras("nauris", 4, "naur", "isn", "au", "r");
    }

    @Points(PISTE + ".2")
    @Test
    public void laskevaSanaporras5() throws Throwable {
        kutsuLaskevaSanaporras("salmiakki", 5, "salmi", "akki", "sal", "mi", "a");
    }

    @Points(PISTE + ".2")
    @Test
    public void laskevaSanaporras6() throws Throwable {
        kutsuLaskevaSanaporras("salmi", 5, "salmi", "salm", "isa", "lm", "i");
    }

    @Points(PISTE + ".3")
    @Test
    public void onMetodiSanapyramidi() {
        Reflex.reflect(klass).method("sanapyramidi").returningVoid().taking(int.class).requirePublic();
    }

    @Points(PISTE + ".3")
    @Test
    public void sanapyramidi1() throws Throwable {
        kutsuSanapyramidi("salmi", 1, "s");
    }

    @Points(PISTE + ".3")
    @Test
    public void sanapyramidi2() throws Throwable {
        kutsuSanapyramidi("salmi", 2, "s", "al", "m");
    }

    @Points(PISTE + ".3")
    @Test
    public void sanapyramidi3() throws Throwable {
        kutsuSanapyramidi("salmi", 3, "s", "al", "mis", "al", "m");
    }

    @Points(PISTE + ".3")
    @Test
    public void sanapyramidi4() throws Throwable {
        kutsuSanapyramidi("Saippuakauppias", 4, "S", "ai", "ppu", "akau", "ppi", "as", "S");
    }

    private Object luoSanatulostin(String sana) {
        try {
            return Reflex.reflect(klass).constructor().taking(String.class).invoke(sana);
        } catch (Throwable ex) {
            fail("Kutsu new " + klass + "(\"" + sana + "\"); epäonnistui. Virhe: " + ex.getMessage());
        }

        return null;
    }

    public void kutsuSanaporras(String sana, int arvo, String... rivitJarj) throws Throwable {
        kutsuMetodi("sanaporras", sana, arvo, rivitJarj);
    }

    public void kutsuLaskevaSanaporras(String sana, int arvo, String... rivitJarj) throws Throwable {
        kutsuMetodi("laskevaSanaporras", sana, arvo, rivitJarj);
    }

    public void kutsuSanapyramidi(String sana, int arvo, String... rivitJarj) throws Throwable {
        kutsuMetodi("sanapyramidi", sana, arvo, rivitJarj);
    }

    public void kutsuMetodi(String metodi, String sana, int arvo, String... rivitJarj) throws Throwable {
        Object tulostin = luoSanatulostin(sana);
        Reflex.reflect(klass).method(metodi).returningVoid().taking(int.class).invokeOn(tulostin, arvo);
        String output = io.getSysOut();
        String[] lines = output.split("\n");

        assertTrue("Kun sanasta \"" + sana + "\" luodulle " + klass + "-oliolle tehdään metodikutsu " + metodi + "(" + arvo + "),\ntulee tulostuksessa olla " + rivitJarj.length + " riviä.", lines.length == rivitJarj.length);

        for (int i = lines.length - 1; i > 0; i--) {
            assertTrue("Kun sanasta \"" + sana + "\" luodulle " + klass + "-oliolle on kutsuttu metodia " + metodi + " parametrilla " + arvo + ",\ntulee rivillä " + (i + 1) + " olla arvo " + rivitJarj[i].trim() + ".\nNyt rivi oli " + lines[i].trim(),
                    lines[i].trim().equals(rivitJarj[i].trim()));
        }
    }
}
