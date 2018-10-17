package lukija.ehdot;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.io.File;
import java.util.Scanner;
import java.util.function.Predicate;
import org.junit.Test;
import static org.junit.Assert.*;

public class PredicateTest {

    Reflex.ClassRef<Object> classRef;

    @Points("11-01.1")
    @Test
    public void kaikkiRivitOlemassa() {
        String klassname = "lukija.ehdot.KaikkiRivit";
        classRef = Reflex.reflect(klassname);
        assertTrue("tee pakkauseen " + pre(klassname) + " luokka " + post(klassname), classRef.isPublic());
    }

    @Points("11-01.1")
    @Test
    public void kaikkiRivitKonstruktori() throws Throwable {
        String klassname = "lukija.ehdot.KaikkiRivit";
        classRef = Reflex.reflect(klassname);
        assertTrue("Tee luokalle " + post(klassname) + " konstruktori public " + post(klassname) + "()",
                classRef.constructor().takingNoParams().isPublic());

        String v = "virheen aiheutti koodi new " + post(klassname) + "();";
        classRef.constructor().takingNoParams().withNiceError(v).invoke();
    }

    private Predicate<String> kaikkiRivit() throws Throwable {
        String klassname = "lukija.ehdot.KaikkiRivit";
        classRef = Reflex.reflect(klassname);
        return (Predicate<String>) classRef.constructor().takingNoParams().invoke();
    }

    @Points("11-01.1")
    @Test
    public void kaikkiRivitOnEhto() {
        onEhto("lukija.ehdot.KaikkiRivit");
    }

    @Points("11-01.1")
    @Test
    public void kaikkiRivitToimii() throws Throwable {
        String[][] sanat = {
            {"testi", "t"},
            {"Huomaa, että ehtoja voi kombinoida mielivaltaisesti.", "t"},
            {"eins dwei drei", "t"},
            {"Each and every day, I have less and less hope for the 2012-2013 season.", "t"},
            {"Talvivaara puhutti Ruotsin kaivosmielenosoituksessa", "t"},
            {"Kotimainen hunaja uhkaa loppua ennen kevättä", "t"},
            {"", "t"}
        };

        Predicate<String> e = kaikkiRivit();

        testaa("lukija.ehdot.KaikkiRivit", e, "Predicate<String> ehto = new KaikkiRivit();", sanat);
    }

    /*
     *
     */
    @Points("11-01.2")
    @Test
    public void loppuuHuutoTaiKysymysmerkkiinOlemassa() {
        String klassname = "lukija.ehdot.LoppuuHuutoTaiKysymysmerkkiin";
        classRef = Reflex.reflect(klassname);
        assertTrue("tee pakkauseen " + pre(klassname) + " luokka " + post(klassname), classRef.isPublic());
    }

    @Points("11-01.2")
    @Test
    public void loppuuHuutoTaiKysymysmerkkiinKonstruktori() throws Throwable {
        String klassname = "lukija.ehdot.LoppuuHuutoTaiKysymysmerkkiin";
        classRef = Reflex.reflect(klassname);
        assertTrue("Tee luokalle " + post(klassname) + " konstruktori public " + post(klassname) + "()",
                classRef.constructor().takingNoParams().isPublic());

        String v = "virheen aiheutti koodi new " + post(klassname) + "();";
        classRef.constructor().takingNoParams().withNiceError(v).invoke();
    }

    private Predicate<String> loppuuHuutoTaiKysymysmerkkiin() throws Throwable {
        String klassname = "lukija.ehdot.LoppuuHuutoTaiKysymysmerkkiin";
        classRef = Reflex.reflect(klassname);
        return (Predicate<String>) classRef.constructor().takingNoParams().invoke();
    }

    @Points("11-01.2")
    @Test
    public void loppuuHuutoTaiKysymysmerkkiinOnEhto() {
        onEhto("lukija.ehdot.LoppuuHuutoTaiKysymysmerkkiin");
    }

    @Points("11-01.2")
    @Test
    public void loppuuHuutoTaiKysymysmerkkiinToimii() throws Throwable {
        String[][] sanat = {
            {"testi", "f"},
            {"testi!", "t"},
            {"testi?", "t"},
            {"Huomaa, että ehtoja voi kombinoida mielivaltaisesti?", "t"},
            {"eins dwei drei!", "t"},
            {"Each and every day, I have less and less hope for the 2012-2013 season!", "t"},
            {"Talvivaara puhutti Ruotsin kaivosmielenosoituksessa!", "t"},
            {"Kotimainen hunaja uhkaa loppua ennen kevättä?", "t"},
            {"Huomaa, että ehtoja voi kombinoida mielivaltaisesti.", "f"},
            {"eins dwei drei!a", "f"},
            {"Each and every day! I have less and less hope for the 2012-2013 season.", "f"},
            {"Talvivaara puhutti Ruotsin kaivosmielenosoituksessa", "f"},
            {"??!?!?!?!?Kotimainen hunaja uhkaa loppua ennen kevättä", "f"},
            {"!", "t"},
            {"", "f"}
        };

        Predicate<String> e = loppuuHuutoTaiKysymysmerkkiin();

        testaa("lukija.ehdot.LoppuuHuutoTaiKysymysmerkkiin", e, "Predicate<String> ehto = new LoppuuHuutoTaiKysymysmerkkiin();", sanat);
    }

    /*
     *
     */
    @Points("11-01.3")
    @Test
    public void pituusVahintaanOlemassa() {
        String klassname = "lukija.ehdot.PituusVahintaan";
        classRef = Reflex.reflect(klassname);
        assertTrue("tee pakkauseen " + pre(klassname) + " luokka " + post(klassname), classRef.isPublic());
    }

    @Points("11-01.3")
    @Test
    public void pituusVahintaanKonstruktori() throws Throwable {
        String klassname = "lukija.ehdot.PituusVahintaan";
        classRef = Reflex.reflect(klassname);
        assertTrue("Tee luokalle " + post(klassname) + " konstruktori public " + post(klassname) + "(int pituus)",
                classRef.constructor().taking(int.class).isPublic());

        String v = "virheen aiheutti koodi new " + post(klassname) + "(10);";
        classRef.constructor().taking(int.class).withNiceError(v).invoke(10);
    }

    private Predicate<String> pituusVahintaan(int p) throws Throwable {
        String klassname = "lukija.ehdot.PituusVahintaan";
        classRef = Reflex.reflect(klassname);
        return (Predicate<String>) classRef.constructor().taking(int.class).invoke(p);
    }

    @Points("11-01.3")
    @Test
    public void pituusVahintaanOnEhto() {
        onEhto("lukija.ehdot.PituusVahintaan");
    }

    @Points("11-01.3")
    @Test
    public void pituusVahintaanToimii1() throws Throwable {
        String[][] sanat = {
            {"testi", "f"},
            {"Huomaa, että ehtoja voi kombinoida mielivaltaisesti.", "t"},
            {"eins dwei drei", "f"},
            {"Each and every day, I have less and less hope for the 2012-2013 season.", "t"},
            {"Talvivaara puhutti Ruotsin kaivosmielenosoituksessa", "t"},
            {"Kotimainen hunaja uhkaa loppua ennen kevättä", "t"},
            {"", "f"}
        };

        Predicate<String> e = pituusVahintaan(20);

        testaa("lukija.ehdot.PituusVahintaan", e, "Predicate<String> ehto = new PituusVahintaan(20);", sanat);
    }

    @Points("11-01.3")
    @Test
    public void pituusVahintaanToimii2() throws Throwable {
        String[][] sanat = {
            {"testi", "f"},
            {"Huomaa, että ehtoja voi kombinoida mielivaltaisesti.", "t"},
            {"eins dwei drei", "f"},
            {"Each and every day, I have less and less hope for the 2012-2013 season.", "t"},
            {"Talvivaara puhutti Ruotsin kaivosmielenosoituksessa", "t"},
            {"Kotimainen hunaja uhkaa loppua ennen kevättä", "f"},
            {"", "f"}
        };

        Predicate<String> e = pituusVahintaan(45);

        testaa("lukija.ehdot.PituusVahintaan", e, "Predicate<String> ehto = new PituusVahintaan(45);", sanat);
    }

    @Points("11-01.3")
    @Test
    public void pituusVahintaanToimii3() throws Throwable {
        for (int i = 5; i < 30; i++) {
            String s1 = luoSana(i - 1);
            String s2 = luoSana(i);
            String[][] sanat = {
                {s1, "f"},
                {s2, "t"}
            };

            Predicate<String> e = pituusVahintaan(i);

            testaa("lukija.ehdot.PituusVahintaan", e, "Predicate<String> ehto = new PituusVahintaan(" + i + ");", sanat);
        }

    }

    /*
     *
     */
    @Points("11-01.4")
    @Test
    public void molemmatOlemassa() {
        String klassname = "lukija.ehdot.Molemmat";
        classRef = Reflex.reflect(klassname);
        assertTrue("tee pakkauseen " + pre(klassname) + " luokka " + post(klassname), classRef.isPublic());
    }

    @Points("11-01.4")
    @Test
    public void molemmatKonstruktori() throws Throwable {
        String klassname = "lukija.ehdot.Molemmat";
        classRef = Reflex.reflect(klassname);
        assertTrue("Tee luokalle " + post(klassname) + " konstruktori public " + post(klassname) + "(Predicate<String> ehto1, Predicate<String> ehto2)",
                classRef.constructor().taking(Predicate.class, Predicate.class).isPublic());

        Predicate<String> e1 = (Predicate<String>) new SisaltaaSanan("maito");
        Predicate<String> e2 = (Predicate<String>) new SisaltaaSanan("vesi");

        String v = "virheen aiheutti koodi new " + post(klassname) + "(new SisaltaaSanan(\"maito\"),"
                + "new SisaltaaSanan(\"vesi\"));";
        classRef.constructor().taking(Predicate.class, Predicate.class).withNiceError(v).invoke(e1, e2);
    }

    private Predicate<String> molemmat(Predicate<String> e1, Predicate<String> e2) throws Throwable {
        String klassname = "lukija.ehdot.Molemmat";
        classRef = Reflex.reflect(klassname);
        return (Predicate<String>) classRef.constructor().taking(Predicate.class, Predicate.class).invoke(e1, e2);
    }

    @Points("11-01.4")
    @Test
    public void molemmatOnEhto() {
        onEhto("lukija.ehdot.Molemmat");
    }

    @Points("11-01.4")
    @Test
    public void molemmatToimii1() throws Throwable {
        String[][] sanat = {
            {"testi", "f"},
            {"vesi vanhin voitehista, maito myös hyvä", "t"},
            {"vesi vanhin voitehista", "f"},
            {"maito myös hyvä", "f"},
            {"maitopoika ja vesimies", "t"},
            {"juo maitoa ja vettä", "f"},
            {"olutta sen pitää olla!", "f"},
            {"", "f"}
        };

        Predicate<String> e1 = (Predicate<String>) new SisaltaaSanan("maito");
        Predicate<String> e2 = (Predicate<String>) new SisaltaaSanan("vesi");
        Predicate<String> e = molemmat(e1, e2);

        testaa("lukija.ehdot.Molemmat", e,
                "Predicate<String> ehto = new Molemmat("
                + "new SisaltaaSanan(\"maito\"), "
                + "new SisaltaaSanan(\"vesi\") );", sanat);
    }

    @Points("11-01.4")
    @Test
    public void molemmatToimii2() throws Throwable {
        String[][] sanat = {
            {"testi", "f"},
            {"java ja ruby ovat ohjelmointikieliä", "t"},
            {"java kehitettiin 90-luvulla", "f"},
            {"ruby kehitettiin 2000-luvulla", "f"},
            {"java on syntaksiltaan c++:n kaltainen. ruby on smalltalkihmisten mieleen", "t"},
            {"hyvä meininki", "f"},
            {"e = mc^2", "f"},
            {"", "f"}
        };

        Predicate<String> e1 = (Predicate<String>) new SisaltaaSanan("java");
        Predicate<String> e2 = (Predicate<String>) new SisaltaaSanan("ruby");
        Predicate<String> e = molemmat(e1, e2);

        testaa("lukija.ehdot.Molemmat", e,
                "Predicate<String> ehto = new Molemmat("
                + "new SisaltaaSanan(\"java\n), "
                + "new SisaltaaSanan(\"ruby\n) );", sanat);
    }

    /*
     *
     */
    @Points("11-01.5")
    @Test
    public void ehtoEiOlemassa() {
        String klassname = "lukija.ehdot.Ei";
        classRef = Reflex.reflect(klassname);
        assertTrue("tee pakkauseen " + pre(klassname) + " luokka " + post(klassname), classRef.isPublic());
    }

    @Points("11-01.5")
    @Test
    public void ehtoEiKonstruktori() throws Throwable {
        String klassname = "lukija.ehdot.Ei";
        classRef = Reflex.reflect(klassname);
        assertTrue("Tee luokalle " + post(klassname) + " konstruktori public " + post(klassname) + "(Predicate<String> ehto)",
                classRef.constructor().taking(Predicate.class).isPublic()
        );

        Predicate<String> e = (Predicate<String>) new SisaltaaSanan("maito");
        String v = "virheen aiheutti koodi new " + post(klassname) + "(new SisaltaaSanan(\"maito\"));";
        classRef.constructor().taking(Predicate.class).withNiceError(v).invoke(e);
    }

    private Predicate<String> ei(Predicate<String> e) throws Throwable {
        String klassname = "lukija.ehdot.Ei";
        classRef = Reflex.reflect(klassname);
        return (Predicate<String>) classRef.constructor().taking(Predicate.class).invoke(e);
    }

    @Points("11-01.5")
    @Test
    public void ehtoEiOnEhto() {
        onEhto("lukija.ehdot.Ei");
    }

    @Points("11-01.5")
    @Test
    public void ehtoEiToimii1() throws Throwable {
        String[][] sanat = {
            {"testi", "t"},
            {"java ja ruby ovat ohjelmointikieliä", "f"},
            {"java kehitettiin 90-luvulla", "f"},
            {"ruby kehitettiin 2000-luvulla", "t"},
            {"java on syntaksiltaan c++:n kaltainen. ruby on smalltalkihmisten mieleen", "f"},
            {"hyvä meininki", "t"},
            {"e = mc^2", "t"},
            {"", "t"}
        };

        Predicate<String> e = (Predicate<String>) ei((Predicate<String>) new SisaltaaSanan(("java")));

        testaa("lukija.ehdot.Ei", e, "Predicate<String> ehto = new Ei( new SisaltaaSanan(\"java\") );", sanat);
    }

    @Points("11-01.5")
    @Test
    public void ehtoEiToimii2() throws Throwable {
        String[][] sanat = {
            {"testi", "t"},
            {"testi!", "f"},
            {"testi?", "f"},
            {"Huomaa, että ehtoja voi kombinoida mielivaltaisesti?", "f"},
            {"eins dwei drei!", "f"},
            {"Each and every day, I have less and less hope for the 2012-2013 season!", "f"},
            {"Talvivaara puhutti Ruotsin kaivosmielenosoituksessa!", "f"},
            {"Kotimainen hunaja uhkaa loppua ennen kevättä?", "f"},
            {"Huomaa, että ehtoja voi kombinoida mielivaltaisesti.", "t"},
            {"eins dwei drei!a", "t"},
            {"Each and every day! I have less and less hope for the 2012-2013 season.", "t"},
            {"Talvivaara puhutti Ruotsin kaivosmielenosoituksessa", "t"},
            {"??!?!?!?!?Kotimainen hunaja uhkaa loppua ennen kevättä", "t"},
            {"!", "f"},
            {"", "t"}
        };

        Predicate<String> e = ei(loppuuHuutoTaiKysymysmerkkiin());

        testaa("lukija.ehdot.Ei", e, "Predicate<String> ehto = new Ei( new LoppuuHuutoTaiKysymysmerkkiin() );", sanat);
    }

    /*
     *
     */
    @Points("11-01.6")
    @Test
    public void vahintaanYksiOlemassa() {
        String klassname = "lukija.ehdot.VahintaanYksi";
        classRef = Reflex.reflect(klassname);
        assertTrue("tee pakkauseen " + pre(klassname) + " luokka " + post(klassname), classRef.isPublic());
    }

    @Points("11-01.6")
    @Test
    public void ehtoVahintaanYksiKonstruktori() throws Throwable {
        String klassname = "lukija.ehdot.VahintaanYksi";
        classRef = Reflex.reflect(klassname);
        assertTrue("Tee luokalle " + post(klassname) + " konstruktori public " + post(klassname) + "(Predicate<String>... ehdot)",
                classRef.constructor().taking(Predicate[].class).isPublic());

        Predicate<String> e1 = (Predicate<String>) new SisaltaaSanan("maito");
        Predicate<String> e2 = (Predicate<String>) new SisaltaaSanan("vesi");
        Predicate<String> e3 = (Predicate<String>) new SisaltaaSanan("kahvi");

        assertEquals("Luokalla VahintaanYksi liikaa konstruktoreja", 1, classRef.cls().getConstructors().length);

        String v = "Onhan luokalla " + post(klassname) + " konstruktori public " + post(klassname) + "(Predicate<String>... ehdot)\n";

        assertTrue(v, vaihtuvaMaaraParametrejaKonstruktorilla());
    }

    private Predicate<String> vahintaanYksi(Predicate<String>... ehdot) throws Throwable {
        String klassname = "lukija.ehdot.VahintaanYksi";
        classRef = Reflex.reflect(klassname);
        return (Predicate<String>) classRef.constructor().taking(Predicate[].class).invoke(ehdot);
    }

    @Points("11-01.6")
    @Test
    public void vahintaanYksiOnEhto() {
        onEhto("lukija.ehdot.VahintaanYksi");
    }

    @Points("11-01.6")
    @Test
    public void vahintaanYksiToimii1() throws Throwable {
        String[][] sanat = {
            {"testi", "f"},
            {"vesi vanhin voitehista, maito myös hyvä", "t"},
            {"vesi vanhin voitehista", "t"},
            {"maito myös hyvä", "t"},
            {"maitopoika ja vesimies", "t"},
            {"klara vappen", "f"},
            {"juo maitoa ja vettä", "t"},
            {"olutta sen pitää olla!", "f"},
            {"", "f"}
        };

        Predicate<String> e1 = (Predicate<String>) new SisaltaaSanan("maito");
        Predicate<String> e2 = (Predicate<String>) new SisaltaaSanan("vesi");
        Predicate<String> e = vahintaanYksi(e1, e2);

        testaa("lukija.ehdot.VahintaanYksi", e,
                "Predicate<String> ehto = new VahintaanYksi("
                + "new SisaltaaSanan(\"maito\"), "
                + "new SisaltaaSanan(\"vesi\") );", sanat);
    }

    @Points("11-01.6")
    @Test
    public void vahintaanYksiToimii2() throws Throwable {
        String[][] sanat = {
            {"testi", "f"},
            {"java ja ruby ovat ohjelmointikieliä", "t"},
            {"fortran kehitettiin 50-luvulla", "f"},
            {"ruby kehitettiin 2000-luvulla", "t"},
            {"java on syntaksiltaan c++:n kaltainen. ruby on smalltalkihmisten mieleen", "t"},
            {"hyvä meininki", "f"},
            {"Each and every day, I have less and less hope for the 2012-2013 season.", "f"},
            {"Talvivaara puhutti Ruotsin kaivosmielenosoituksessa", "f"},
            {"luokkakaavioilla voidaan kuvata ohjelman rakennetta", "f"},
            {"ei yhtään ohjelmointikieltä mainittu", "f"},
            {"", "f"}
        };

        Predicate<String> e1 = (Predicate<String>) new SisaltaaSanan("ruby");
        Predicate<String> e2 = (Predicate<String>) new SisaltaaSanan("java");
        Predicate<String> e3 = (Predicate<String>) new SisaltaaSanan("c++");
        Predicate<String> e = vahintaanYksi(e1, e2, e3);

        testaa("lukija.ehdot.VahintaanYksi", e,
                "Predicate<String> ehto = new VahintaanYksi("
                + "new SisaltaaSanan(\"java\"), "
                + "new SisaltaaSanan(\"ruby\"),"
                + "new SisaltaaSanan(\"c++\") );", sanat);
    }

    /*
     *
     */
    private String pre(String klassname) {
        int kohta = klassname.lastIndexOf(".");
        return klassname.substring(0, kohta);
    }

    private String post(String klassname) {
        int kohta = klassname.lastIndexOf(".");
        return klassname.substring(kohta + 1);
    }

    private void onEhto(String klassname) {
        classRef = Reflex.reflect(klassname);
        Class clazz = classRef.cls();

        boolean toteuttaaRajapinnan = false;
        Class ehto = Predicate.class;
        for (Class iface : clazz.getInterfaces()) {
            if (iface.equals(ehto)) {
                toteuttaaRajapinnan = true;
            }
        }
        if (!toteuttaaRajapinnan) {
            fail("Toteuttaahan luokka " + post(klassname) + " rajapinnan Predicate<String>?");
        }
    }

    private boolean toteutuu(String klassname, Predicate<String> e, String rivi, String v) throws Throwable {
        classRef = Reflex.reflect(klassname);
        return classRef.method(e, "test").returning(boolean.class).taking(String.class).withNiceError(v).invoke(rivi);

    }

    private void testaa(String klassname, Predicate<String> e, String v, String[][] rivit) throws Throwable {
        for (String[] rivi : rivit) {
            boolean odotettu = rivi[1].equals("t") ? true : false;
            String f = v + "\nehto.test(\"" + rivi[0] + "\");\n";
            assertEquals(f, odotettu, toteutuu(klassname, e, rivi[0], "\nVirhe tapahtui koodilla:\n" + f));
        }
    }

    private String luoSana(int pit) {
        String s = "";
        for (int i = 0; i < pit; i++) {
            s += "a";
        }
        return s;
    }

    private boolean vaihtuvaMaaraParametrejaKonstruktorilla() {

        boolean ok = false;
        try {
            Scanner lukija = new Scanner(new File("src/lukija/ehdot/VahintaanYksi.java"));
            while (lukija.hasNext()) {
                String rivi = lukija.nextLine();

                if (rivi.indexOf("//") > -1) {
                    rivi = rivi.substring(0, rivi.indexOf("//"));
                }

                if (rivi.contains("Predicate<String>... ") && rivi.contains("VahintaanYksi")) {
                    ok = true;
                    break;
                }

            }

        } catch (Exception e) {
            fail(e.getMessage());
        }
        return ok;
    }
}
