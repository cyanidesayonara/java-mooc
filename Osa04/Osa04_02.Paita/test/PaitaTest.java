
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

@Points("04-02")
public class PaitaTest {

    Reflex.ClassRef<Object> klass;
    String klassName = "Paita";

    @Before
    public void haeLuokka() {
        klass = Reflex.reflect(klassName);
    }

    @Test
    public void luokkaJulkinen() {
        assertTrue("Luokan " + klassName + " pitää olla julkinen, eli se tulee määritellä\npublic class " + klassName + " {...\n}", klass.isPublic());
    }

    @Test
    public void testaaKonstruktori() throws Throwable {
        Reflex.MethodRef3<Object, Object, String, Integer, String> cc = klass.constructor().taking(String.class, int.class, String.class).withNiceError();
        assertTrue("Määrittele luokalle " + klassName + " julkinen konstruktori: public " + klassName + "(String vari, int koko, String materiaali)", cc.isPublic());
        cc.invoke("Punainen", 38, "Puuvilla");
    }

    @Test
    public void onkoMetodi() throws Throwable {
        Reflex.MethodRef3<Object, Object, String, Integer, String> cc = klass.constructor().taking(String.class, int.class, String.class).withNiceError();
        assertTrue("Määrittele luokalle " + klassName + " julkinen konstruktori: public " + klassName + "(String vari, int koko, String materiaali)", cc.isPublic());
        Object paita = cc.invoke("Punainen", 38, "Puuvilla");

        try {
            klass.method(paita, "getKoko")
                    .returning(int.class)
                    .takingNoParams().invoke();
        } catch (AssertionError ae) {
            fail("Virhe: " + ae + "\n eli tee luokalle " + klassName + " metodi public int getKoko()");
        }
    }
}
