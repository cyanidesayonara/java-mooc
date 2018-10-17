
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SensuroijaTest {

    Class sanaLuokka;
    private final String ENKOODAUSONGELMIA = "Mac- ja windowskäyttäjillä voi olla ongelmia ä ja ö -merkkejä sisältävien sanojen kanssa.\n"
            + "Tässä tapauksessa luo Scanner seuraavasti: Scanner lukija = new Scanner(tiedosto, \"UTF-8\");";
    String klassName = "Sensuroija";
    Reflex.ClassRef<Object> classRef;

    @Before
    public void setUp() {
        classRef = Reflex.reflect(klassName);

        assertTrue("Luokan " + s(klassName) + " pitää olla julkinen, eli se tulee määritellä\n"
                + "public class " + s(klassName) + " {...\n}", classRef.isPublic());

        try {
            sanaLuokka = ReflectionUtils.findClass(klassName);
            assertNotNull(sanaLuokka);
        } catch (Throwable t) {
            fail("Olethan luonut luokan \"Sanatutkimus\"?");
        }
    }

    @Test
    @Points("07-07")
    public void onKonstruktoriSensuroija() throws Throwable {
        Reflex.MethodRef1<Object, Object, String> ctor = classRef.constructor().taking(String.class).withNiceError();
        assertTrue("Määrittele luokalle " + s(klassName) + " julkinen konstruktori: \n"
                + "public " + s(klassName) + "(String sensuroitava)", ctor.isPublic());
        String v = "virheen aiheutti koodi new Sensuroija(\"rump\");\n";
        ctor.withNiceError(v).invoke("rump");
    }

    public Object luo(String sensuroitava) throws Throwable {
        return classRef.constructor().taking(String.class).invoke(sensuroitava);
    }

    @Test
    @Points("07-07")
    public void onMetodiSensuroi() throws Throwable {
        Object o = luo("boogie");

        assertTrue("Lisää luokalle " + klassName + " metodi public void sensuroi(String lahdetiedosto, String kohdetiedosto)", classRef.method(o, "sensuroi").returningVoid().taking(String.class, String.class).isPublic());
    }

    @Test
    @Points("07-07")
    public void sensuroiPieni() throws Throwable {

        File eka;
        eka = File.createTempFile("eka", "txt");
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(eka), "UTF-8");
        out.append("sana1\nsana2\nsana3\nsana4\nsana5\n");
        out.flush();
        out.close();

        Object o = luo("sana1");
        assertTrue("Lisää luokalle " + klassName + " metodi public void sensuroi(String lahdetiedosto, String kohdetiedosto)", classRef.method(o, "sensuroi").returningVoid().taking(String.class, String.class).isPublic());

        classRef.method(o, "sensuroi").returningVoid().taking(String.class, String.class).invokeOn(o, eka.getAbsolutePath(), "test-pieni-output.txt");

        String k = "Tiedoston \"eka.txt\" sisältönä:\n"
                + "sana1\nsana2\nsana3\nsana4\nsana5"
                + "\nSensuroija s = new Sensuroija(\"sana1\");\ns.sensuroi(\"eka.txt\", \"eka-out.txt\");\nTiedostossa \"eka-out.txt\" pitäisi olla sisältö:\n"
                + "sana2\nsana3\nsana4\nsana5";

        List<String> lines = Files.lines(Paths.get("test-pieni-output.txt")).collect(Collectors.toList());
        assertTrue(k, lines.size() == 4);
        assertFalse(k, lines.contains("sana1"));
        assertTrue(k, lines.contains("sana2"));
    }

    @Test
    @Points("07-07")
    public void sensuroiHiemanIsompi() throws Throwable {

        File eka;
        eka = File.createTempFile("toka", "txt");
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(eka), "UTF-8");
        out.append("sana\nmuuta\nsana1\nsana2\nsana3\nsana4\nsana5\n");
        out.flush();
        out.close();

        Object o = luo("sana");
        assertTrue("Lisää luokalle " + klassName + " metodi public void sensuroi(String lahdetiedosto, String kohdetiedosto)", classRef.method(o, "sensuroi").returningVoid().taking(String.class, String.class).isPublic());

        classRef.method(o, "sensuroi").returningVoid().taking(String.class, String.class).invokeOn(o, eka.getAbsolutePath(), "toka-out.txt");

        List<String> lines = Files.lines(Paths.get("toka-out.txt")).collect(Collectors.toList());
        
        String sis = "";
        for (int i = 0; i < lines.size(); i++) {
            sis += lines.get(i) + "\n";   
        }
        
        String k = "Tiedoston \"toka.txt\" sisältönä:\n"
                + "sana\nmuuta\nsana1\nsana2\nsana3\nsana4\nsana5\n"
                + "\nSensuroija s = new Sensuroija(\"sana\");\ns.sensuroi(\"toka.txt\", \"toka-out.txt\");\nTiedostossa \"toka-out.txt\" pitäisi olla sisältö:\n"
                + "muuta\n\nNyt sisältö oli:\n" + sis;

        assertTrue(k, lines.size() == 1);
        assertTrue(k, lines.contains("muuta"));
        assertFalse(k, lines.contains("sana"));
    }

    private String s(String klassName) {
        return klassName.substring(klassName.lastIndexOf(".") + 1);
    }

}
