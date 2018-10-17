
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SanatutkimusTest {

    Class sanaLuokka;
    private final String ENKOODAUSONGELMIA = "Mac- ja windowskäyttäjillä voi olla ongelmia ä ja ö -merkkejä sisältävien sanojen kanssa.\n"
            + "Tässä tapauksessa lue rivit seuraavasti: Files.lines(Paths.get(tiedosto), StandardCharsets.UTF_8);";
    String klassName = "Sanatutkimus";
    Reflex.ClassRef<Object> classRef;

    @Before
    public void setUp() {
        classRef = Reflex.reflect(klassName);

        assertTrue("Luokan " + s(klassName) + " pitää olla julkinen, eli se tulee määritellä\n"
                + "public class " + s(klassName) + " {...\n}", classRef.isPublic());

        try {
            sanaLuokka = ReflectionUtils.findClass("Sanatutkimus");
            assertNotNull(sanaLuokka);
        } catch (Throwable t) {
            fail("Olethan luonut luokan \"Sanatutkimus\"");
        }
    }

    @Test
    @Points("07-06.1")
    public void eiYlimaaraisiaMuuttujia() {
        saniteettitarkastus(klassName, 20, "");
    }

    @Test
    @Points("07-06.1")
    public void onKonstruktoriAnalyysi() throws Throwable {
        Reflex.MethodRef1<Object, Object, String> ctor = classRef.constructor().taking(String.class).withNiceError();
        assertTrue("Määrittele luokalle " + s(klassName) + " julkinen konstruktori: \n"
                + "public " + s(klassName) + "(String tiedosto)", ctor.isPublic());
        String v = "virheen aiheutti koodi new Sanatutkimus( new String(\"src/pienilista.txt\") );\n";
        ctor.withNiceError(v).invoke(new String("pienilista.txt"));
    }

    public Object luo(String file) throws Throwable {
        return classRef.constructor().taking(String.class).invoke(file);
    }

    @Test
    @Points("07-06.1")
    public void onMetodiSanojenMaara() throws Throwable {
        Object o = luo(new String("pienilista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public int sanojenMaara()", classRef.method(o, "sanojenMaara").returning(int.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/pienilista.txt\") );\n"
                + "s.sanojenMaara();";

        assertEquals(k, 24, (int) classRef.method(o, "sanojenMaara").returning(int.class).takingNoParams().withNiceError(k).invoke());
    }

    @Test
    @Points("07-06.1")
    public void pieniFile() throws Throwable {

        File eka;
        eka = File.createTempFile("eka", "txt");
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(eka), "UTF-8");
        out.append("sana1\nsana2\nsana3\nsana4\nsana5\n");
        out.flush();
        out.close();

        Object o = luo(eka.getAbsolutePath());

        assertTrue("Lisää luokalle Sanatutkimus metodi public int sanojenMaara()", classRef.method(o, "sanojenMaara").returning(int.class).takingNoParams().isPublic());

        String k = "Tiedoston sisältönä:\n"
                + "sana1\nsana2\nsana3\nsana4\nsana5"
                + "\ns.sanojenMaara();";

        assertEquals(k, 5, (int) classRef.method(o, "sanojenMaara").returning(int.class).takingNoParams().withNiceError(k).invoke());

    }

    @Test
    @Points("07-06.1")
    public void hiemanIsompiFile() throws Throwable {

        File eka;
        eka = File.createTempFile("eka", "txt");
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(eka), "UTF-8");
        out.append("sana1\nsana2\nsana3\nsana4\nsana5\nlisäsana\n");
        out.flush();
        out.close();

        Object o = luo(eka.getAbsolutePath());

        assertTrue("Lisää luokalle Sanatutkimus metodi public int sanojenMaara()", classRef.method(o, "sanojenMaara").returning(int.class).takingNoParams().isPublic());

        String k = "Tiedoston sisältönä:\n"
                + "sana1\nsana2\nsana3\nsana4\nsana5\nlisäsana\n"
                + "\ns.sanojenMaara();";

        assertEquals(k, 6, (int) classRef.method(o, "sanojenMaara").returning(int.class).takingNoParams().withNiceError(k).invoke());

    }

    @Test
    @Points("07-06.1")
    public void sanojenMaaraIsoLista() throws Throwable {
        Object o = luo(new String("sanalista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public int sanojenMaara()", classRef.method(o, "sanojenMaara").returning(int.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/sanalista.txt\") );\n"
                + "s.sanojenMaara();";

        assertEquals(k, 91591, (int) classRef.method(o, "sanojenMaara").returning(int.class).takingNoParams().withNiceError(k).invoke());

    }

    /*
     *
     */
    @Test
    @Points("07-06.2")
    public void onMetodiZZZ() throws Throwable {
        Object o = luo(new String("pienilista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public List<String> kirjaimenZSisaltavatSanat()", classRef.method(o, "kirjaimenZSisaltavatSanat").returning(ArrayList.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/pienilista.txt\") );\n"
                + "s.kirjaimenZSisaltavatSanat();";

        classRef.method(o, "kirjaimenZSisaltavatSanat").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();
    }

    @Test
    @Points("07-06.2")
    public void zetallaAlkavatPieniLista() throws Throwable {
        Object o = luo(new String("pienilista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public List<String> kirjaimenZSisaltavatSanat()", classRef.method(o, "kirjaimenZSisaltavatSanat").returning(ArrayList.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/pienilista.txt\") );\n"
                + "s.kirjaimenZSisaltavatSanat();";

        List<String> zeta = (List<String>) classRef.method(o, "kirjaimenZSisaltavatSanat").returning(ArrayList.class)
                .takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        List<String> odotettu = new ArrayList<String>();
        Collections.addAll(odotettu, "appenzeller", "appenzellerjuusto", "gorgonzola", "gorgonzolajuusto");

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 4, zeta.size());
        assertEquals(k, odotettu, zeta);
    }

    @Test
    @Points("07-06.2")
    public void zKirjainTest() throws Exception, Throwable {
        FileWriter n;
        File eka = File.createTempFile("eka", "txt");
        n = new FileWriter(eka);
        n.append("jazz\nzombi\nbomb\npalmu\nzzz\nunilla\nzoo\n");
        n.flush();
        n.close();

        ArrayList<String> odotettu = new ArrayList<String>() {
            {
                add("jazz");
                add("zombi");
                add("zoo");
                add("zzz");
            }
        };

        Object o = luo(eka.getAbsolutePath());

        String k = "Tiedoston sisältönä:\n"
                + "jazz\nzombi\nbomb\npalmu\nzzz\nunilla\nzoo\n"
                + "\ns.sanojenMaara();";

        List<String> zeta = (List<String>) classRef.method(o, "kirjaimenZSisaltavatSanat").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 4, zeta.size());

        k = "Tiedoston sisältönä:\n"
                + "jazz\nzombi\nbomb\npalmu\nzzz\nunilla\nzoo\n"
                + "\ns.sanojenMaara();\n"
                + "palautit: " + zeta;

        assertEquals(k, odotettu, zeta);
    }

    @Test
    @Points("07-06.2")
    public void ztanSisaltavatSanaLista() throws Throwable {
        Object o = luo(new String("sanalista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public List<String> kirjaimenZSisaltavatSanat()", classRef.method(o, "kirjaimenZSisaltavatSanat").returning(ArrayList.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/sanalista.txt\") );\n"
                + "s.kirjaimenZSisaltavatSanat();";

        List<String> zeta = (List<String>) classRef.method(o, "kirjaimenZSisaltavatSanat").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        List<String> odotettu = new ArrayList<String>() {
            {
                add("appenzeller");
                add("appenzellerjuusto");
                add("azeri");
                add("blazer");
                add("buzuki");
                add("gorgonzola");
                add("gorgonzolajuusto");
                add("gorgonzolanjuusto");
                add("intermezzo");
                add("jazz");
                add("jazzfestivaali");
                add("jazzklubi");
                add("jazzlaulaja");
                add("jazzmessu");
                add("jazzmusiikki");
                add("jazzmuusikko");
                add("jazzorkesteri");
                add("jazztanssi");
                add("kamikazelentäjä");
                add("mezzoforte");
                add("mezzopiano");
                add("mezzosopraano");
                add("mezzotinto");
                add("nizzansalaatti");
                add("ouzo");
                add("paparazzi");
                add("pizza");
                add("pizzeria");
                add("pizzicato");
                add("puzzle");
                add("puzzlepeli");
                add("scherzo");
                add("zambo");
                add("zen");
                add("zenbuddhalaisuus");
                add("zeniitti");
                add("zeppeliini");
                add("zirkoni");
                add("zirkonium");
                add("zloty");
                add("zombi");
                add("zombie");
                add("zoologi");
                add("zoologia");
                add("zoologinen");
                add("zoomata");
                add("zoomaus");
                add("zoomi");
                add("zoonoosi");
                add("zucchini");
                add("zulu");
            }
        };

        Collections.sort(zeta);
        assertEquals(ENKOODAUSONGELMIA + "\n" + k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 51, zeta.size());
        assertEquals(k, odotettu, zeta);
    }

    /*
     *
     */
    @Test
    @Points("07-06.3")
    public void onMetodilPaatteiset() throws Throwable {
        Object o = luo(new String("pienilista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public List<String> kirjaimeenNPaattyvatSanat()", classRef.method(o, "kirjaimeenNPaattyvatSanat").returning(ArrayList.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/pienilista.txt\") );\n"
                + "s.kirjaimeenNPaattyvatSanat();";

        classRef.method(o, "kirjaimeenNPaattyvatSanat").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();
    }

    @Test
    @Points("07-06.3")
    public void nLoppuisetPieniLista() throws Throwable {
        Object o = luo("pienilista.txt");

        String k = "Sanatutkimus s = new Sanatutkimus(\"src/pienilista.txt\");\n"
                + "s.kirjaimeenNPaattyvatSanat();";

        List<String> zeta = (List<String>) classRef.method(o, "kirjaimeenNPaattyvatSanat").returning(ArrayList.class)
                .takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        List<String> odotettu = new ArrayList<>();
        Collections.addAll(odotettu, "aakkonen", "aakkosellinen", "aakkosittain", "aakkosnumeerinen", "valkokaulustyöläinen");

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 5, zeta.size());
        assertEquals(k, odotettu, zeta);
    }

    @Test
    @Points("07-06.3")
    public void nPaateTest() throws Exception, Throwable {
        FileWriter n;
        File eka = File.createTempFile("eka", "txt");
        n = new FileWriter(eka);
        n.append("kannel\ntalo\nsammal\nlol\nhoh\niloinen\naurinkoinen\njoo\nlossi\nl\n");
        n.flush();
        n.close();

        String lisa = "Lisääthän sanat ArrayListiin, jonka metodi palauttaa?";
        ArrayList<String> odotettu = new ArrayList<String>() {
            {
                add("aurinkoinen");
                add("iloinen");
            }
        };

        Object o = luo(eka.getAbsolutePath());

        String k = "Tiedoston sisältönä:\n"
                + "kannel\ntalo\nsammal\nlol\nhoh\niloinen\naurinkoinen\njoo\nlossi\nl\n"
                + "\ns.kirjaimeenNPaattyvatSanat();";

        List<String> zeta = (List<String>) classRef.method(o, "kirjaimeenNPaattyvatSanat").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 2, zeta.size());
        assertEquals(k, odotettu, zeta);

    }

    /*
     *
     */
    @Test
    @Points("07-06.4")
    public void onMetodiPalindromit() throws Throwable {
        Object o = luo(new String("pienilista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public List<String> palindromit()", classRef.method(o, "palindromit").returning(ArrayList.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/pienilista.txt\") );\n"
                + "s.palindromit();";

        classRef.method(o, "palindromit").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();
    }

    @Test
    @Points("07-06.4")
    public void palindromitPieniLista() throws Throwable {
        Object o = luo(new String("pienilista.txt"));

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/pienilista.txt\") );\n"
                + "s.palindromit();";

        List<String> zeta = (List<String>) classRef.method(o, "palindromit").returning(ArrayList.class)
                .takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        List<String> odotettu = new ArrayList<String>();
        Collections.addAll(odotettu, "autioitua", "suuruus", "utu");

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 3, zeta.size());
        assertEquals(k, odotettu, zeta);
    }

    @Test
    @Points("07-06.4")
    public void palindromitTest() throws Exception, Throwable {
        FileWriter n;
        File eka = File.createTempFile("eka", "txt");
        n = new FileWriter(eka);
        n.append("hissi\na\nb\nlol\nsaippuakauppias\nsiilo\nabba\n");
        n.flush();
        n.close();

        ArrayList<String> odotettu = new ArrayList<String>() {
            {
                add("a");
                add("abba");
                add("b");
                add("lol");
                add("saippuakauppias");
            }
        };

        Object o = luo(eka.getAbsolutePath());

        String k = "Tiedoston sisältönä:\n"
                + "hissi\na\nb\nlol\nsaippuakauppias\nsiilo\nabba\n"
                + "\ns.palindromit();";

        List<String> zeta = (List<String>) classRef.method(o, "palindromit").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 5, zeta.size());
        assertEquals(k, odotettu, zeta);

    }

    @Test
    @Points("07-06.4")
    public void palindromitSanalistalla() throws Throwable {
        Object o = luo(new String("sanalista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public List<String> kirjaimenZSisaltavatSanat()", classRef.method(o, "palindromit").returning(ArrayList.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/sanalista.txt\") );\n"
                + "s.palindromit();";

        List<String> zeta = (List<String>) classRef.method(o, "palindromit").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        List<String> odotettu = new ArrayList<String>() {
            {
                add("ajaja");
                add("akka");
                add("ala");
                add("alla");
                add("autioitua");
                add("ele");
                add("enne");
                add("hah");
                add("heh");
                add("huh");
                add("hyh");
                add("häh");       //
                add("imaami");
                add("isi");
                add("niin");
                add("oho");
                add("olo");
                add("opo");
                add("otto");
                add("piip");
                add("pop");
                add("sadas");
                add("sammas");
                add("sees");
                add("siis");
                add("sus");
                add("suuruus");
                add("sylys");
                add("sytytys");
                add("syys");
                add("syöppöys");   //
                add("tuut");
                add("tyyt");
                add("tööt");     //
                add("utu");
                add("yty");
                add("älä");     //
                add("ämmä");  //
                add("ässä");   //
            }
        };

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 39, zeta.size());
        assertEquals(k, odotettu, zeta);
    }

    /*
     *
     */
    @Test
    @Points("07-06.5")
    public void onMetodiKaikkiVokaalitSisaltavatSanat() throws Throwable {
        Object o = luo(new String("pienilista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public List<String> kaikkiVokaalitSisaltavatSanat()", classRef.method(o, "kaikkiVokaalitSisaltavatSanat").returning(ArrayList.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/pienilista.txt\") );\n"
                + "s.kaikkiVokaalitSisaltavatSanat();";

        classRef.method(o, "kaikkiVokaalitSisaltavatSanat").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();
    }

    @Test
    @Points("07-06.5")
    public void kaikkiVokaalitSisaltavatSanatPieniLista() throws Throwable {
        Object o = luo(new String("pienilista.txt"));

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/pienilista.txt\") );\n"
                + "s.kaikkiVokaalitSisaltavatSanat();";

        List<String> zeta = (List<String>) classRef.method(o, "kaikkiVokaalitSisaltavatSanat").returning(ArrayList.class)
                .takingNoParams().withNiceError(k).invoke();
        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        List<String> odotettu = new ArrayList<String>();
        Collections.addAll(odotettu, "juustohöyläperiaate", "valkokaulustyöläinen");

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 2, zeta.size());
        assertEquals(k, odotettu, zeta);
    }

//    @Test
//    @Points("07-06.5")
//    public void kaikkiVokaalitSisaltavatSanatTest() throws Exception, Throwable {
//        FileWriter n;
//        File eka = File.createTempFile("eka", "txt");
//        n = new FileWriter(eka);
//        n.append("myöhäiselokuva\nb\nympäristöntuhoaja\nsiilo\nabba\naeiouyäö\n");
//        n.flush();
//        n.close();
//
//        String lisa = "Lisääthän sanat ArrayListiin, jonka metodi palauttaa?";
//        ArrayList<String> odotettu = new ArrayList<String>() {
//            {
//                add("aeiouyäö");
//                add("myöhäiselokuva");
//            }
//        };
//
//        Object o = luo(eka);
//
//        String k = "Tiedoston sisältönä:\n"
//                + "myöhäiselokuva\nb\nympäristöntuhoaja\nsiilo\nabba\naeiouyäö\n"
//                + "\ns.palindromit();";
//
//        List<String> zeta = (List<String>) classRef.method(o, "kaikkiVokaalitSisaltavatSanat").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();
//
//        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);
//
//        Collections.sort(zeta);
//        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 2, zeta.size());
//        assertEquals(k, odotettu, zeta);
//
//    }
    @Test
    @Points("07-06.5")
    public void kaikkiVokaalitSisaltavatSanatSanalistalla() throws Throwable {
        Object o = luo(new String("sanalista.txt"));

        assertTrue("Lisää luokalle Sanatutkimus metodi public List<String> kaikkiVokaalitSisaltavatSanat()", classRef.method(o, "kaikkiVokaalitSisaltavatSanat").returning(ArrayList.class).takingNoParams().isPublic());

        String k = "Sanatutkimus s = new Sanatutkimus( new String(\"src/sanalista.txt\") );\n"
                + "s.kaikkiVokaalitSisaltavatSanat();";

        List<String> zeta = (List<String>) classRef.method(o, "kaikkiVokaalitSisaltavatSanat").returning(ArrayList.class).takingNoParams().withNiceError(k).invoke();

        assertFalse(k + "\nPalautettu lista oli null.", zeta == null);

        List<String> odotettu = new ArrayList<String>() {
            {
                add("arvostelukyvyttömästi");
                add("juustohöyläperiaate");
                add("kotitaloustyöntekijä");
                add("maataloustyöntekijä");
                add("myöhäiselokuva");
                add("suojatyöntekijä");
                add("taloustyöntekijä");
                add("ulkomaantyöntekijä");
                add("valkokaulustyöläinen");
                add("valkokaulustyöntekijä");
                add("ympäristönsuojelija");
            }
        };

        Collections.sort(zeta);
        assertEquals(k + "\npalautetun listan pituus väärä\nPalautettu lista oli: " + zeta, 11, zeta.size());
        assertEquals(k, odotettu, zeta);
    }

    private String s(String klassName) {
        return klassName.substring(klassName.lastIndexOf(".") + 1);
    }

    private void saniteettitarkastus(String klassName, int n, String m) throws SecurityException {
        Field[] kentat = ReflectionUtils.findClass(klassName).getDeclaredFields();

        for (Field field : kentat) {
            assertFalse("et tarvitse \"stattisia muuttujia\", poista luokalta " + s(klassName) + " muuttuja " + kentta(field.toString(), s(klassName)), field.toString().contains("static") && !field.toString().contains("final"));
            assertTrue("luokan kaikkien oliomuuttujien näkyvyyden tulee olla private, muuta luokalta " + s(klassName) + " löytyi: " + kentta(field.toString(), klassName), field.toString().contains("private"));
        }

        if (kentat.length > 1) {
            int var = 0;
            for (Field field : kentat) {
                if (!field.toString().contains("final")) {
                    var++;
                }
            }
            assertTrue("et tarvitse " + s(klassName) + "-luokalle kuin " + m + ", poista ylimääräiset", var <= n);
        }
    }

    private String kentta(String toString, String klassName) {
        return toString.replace(klassName + ".", "").replace("java.lang.", "").replace("java.util.", "").replace("java.io.", "");
    }
}
