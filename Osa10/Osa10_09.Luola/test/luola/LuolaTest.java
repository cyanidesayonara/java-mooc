package luola;


import fi.helsinki.cs.tmc.edutestutils.MockInOut;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import fi.helsinki.cs.tmc.edutestutils.Reflex.ClassRef;
import fi.helsinki.cs.tmc.edutestutils.Reflex.MethodRef1;
import fi.helsinki.cs.tmc.edutestutils.Reflex.MethodRef5;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

@Points("10-09.1 10-09.2 10-09.3 10-09.4")
public class LuolaTest {

    ClassRef luola;
    MethodRef5<Void, Object, Integer, Integer, Integer, Integer, Boolean> cons;
    MethodRef1<Object, Void, Scanner> run;

    @Before
    public void hae() {
        luola = Reflex.reflect("luola.Luola");
        cons = luola.constructor().taking(Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
        assertTrue("Tee luokalle Luola konstruktori public Luola(int leveys, int korkeus, int hirvioita, int siirtoja, boolean hirviotLiikkuvat)", cons.isPublic());
        run = luola.method("run").returningVoid().taking(Scanner.class);
        assertTrue("Tee luokalle Luola metodi public void run()", run.isPublic());
    }

    @Test
    public void testaaEnsimmainenTulostus() throws Throwable {
        String viesti = "Testattiin Scanner s = new Scanner(System.in);\nLuola luola = new Luola(5,5,3,3,false);\nluola.run(s);\n";
        Object luola = cons.invoke(5, 5, 3, 3, false);

        MockInOut io = new MockInOut("\n");
        String pastOut = io.getOutput();
        Scanner scanner = new Scanner("\n");
        try {
            run.invokeOn(luola, scanner);
        } catch (NoSuchElementException e) {
        }

        String s = io.getOutput().replace(pastOut, "");

        s = s.replaceAll("\r\n", "\n");
        s = s.replaceAll("\r", "\n");

        String[] rivit = s.split("\n");
        assertTrue(viesti + "Tulostusrivejä pitäisi olla vähintään 3. Tulostuksesi oli:\n" + s,
                rivit.length >= 3);

        assertEquals(viesti + "Et tulostanut ensimmäisellä rivillä siirtojen määrää. Tulostuksesi oli:\n" + s,
                "3",
                rivit[0].trim());
        assertTrue(viesti + "Tulosteen toisen rivin pitäisi olla tyhjä. Tulostuksesi oli: \n" + s,
                "".equals(rivit[1].trim()));
        assertEquals(viesti + "Et tulostanut pelaajan koordinaatteja. Tulostuksesi oli:\n" + s,
                "@ 0 0",
                rivit[2].trim());

        assertTrue(viesti + "Tulostusrivejä pitäisi olla vähintään 5. Tulostuksesi oli:\n" + s,
                rivit.length >= 5);
        for (int i = 1; i <= 3; i++) {
            if (!rivit[2 + i].startsWith("h")) {
                fail(viesti + "Et tulostanut hirviöriviä. Virheellinen rivi on:\n" + rivit[2 + i] + "\nKoko tulostuksesi oli:\n" + s);
            }
        }
        assertTrue(viesti + "Tulostusrivejä pitäisi olla vähintään 11. Tulostuksesi oli:\n" + s,
                rivit.length >= 11);
        assertTrue(viesti + "Ennen karttaa pitäisi olla tyhjä rivi. Tulostuksesi oli: \n" + s,
                "".equals(rivit[6].trim()));
        for (int i = 1; i <= 5; i++) {
            if (rivit[6 + i].length() != 5) {
                fail(viesti + "Karttarivillä on väärä pituus. Virheellinen rivi on:\n" + rivit[6 + i] + "\nKoko tulostuksesi oli:\n" + s);
            }
        }
    }

    @Test
    public void testaaHavio() throws Throwable {
        String viesti = "Testattiin Scanner s = new Scanner(System.in);\nLuola luola = new Luola(5,5,5,5,true);\nluola.run(s);\n";

        MockInOut io = new MockInOut("w\nw\nw\nw\nw\n");
        String pastOut = io.getOutput();
        Scanner scanner = new Scanner("w\nw\nw\nw\nw\n");

        Object luola = cons.invoke(5, 5, 5, 5, true);

        try {
            run.invokeOn(luola, scanner);
        } catch (NoSuchElementException e) {
        }

        String out = io.getOutput().replace(pastOut, "");

        assertTrue(viesti + "Pelin pitäisi loppua häviöön kun liikutaan 5 kertaa! Tulosteesi oli:\n" + out,
                out.contains("VISIT"));

    }

    @Test
    public void testaaVoitto() throws Throwable {
        String viesti = "Testattiin Scanner s = new Scanner(System.in);\nLuola luola = new Luola(4,4,1,100,false);\nluola.run(s);\n";

        MockInOut io = new MockInOut("s\ns\ns\nd\nw\nw\nw\nd\ns\ns\ns\nd\nw\nw\nw\n");
        String pastOut = io.getOutput();
        Scanner scanner = new Scanner("s\ns\ns\nd\nw\nw\nw\nd\ns\ns\ns\nd\nw\nw\nw\n");

        Object luola = cons.invoke(4, 4, 1, 100, false);

        try {
            run.invokeOn(luola, scanner);
        } catch (NoSuchElementException e) {
        }

        String out = io.getOutput().replace(pastOut, "");
        String syote = "s s s d w w w d s s s d w w w";

        assertTrue(viesti + "Pelin pitäisi loppua voittoon kun käydään kaikissa ruuduissa! \n"
                + "\nKun syöte oli " + syote
                + "\nTulosteesi oli:\n" + out,
                out.contains("VOITIT"));
    }

    @Test
    public void testaaEttaLamppujaVahennetaanVainKunKatsotaanTilanne() throws Throwable {
        String viesti = "Testattiin Scanner s = new Scanner(System.in);\nLuola luola = new Luola(4,4,2,100,false);\nluola.run(s);\n";

        MockInOut io = new MockInOut("swswswswswsw\ns\ns\ns\nd\nw\nw\nw\nd\ns\ns\ns\nd\nw\nw\nw\n");
        String pastOut = io.getOutput();
        Scanner scanner = new Scanner("swswswswswsw\ns\ns\ns\nd\nw\nw\nw\nd\ns\ns\ns\nd\nw\nw\nw\n");

        Object luola = cons.invoke(4, 4, 2, 100, false);

        try {
            run.invokeOn(luola, scanner);
        } catch (NoSuchElementException e) {
        }

        String out = io.getOutput().replace(pastOut, "");

        assertTrue(viesti + "Lampun välkäytysten määrän tulee pienentyä yhdellä vuoroa kohti. Pelaaja saa kävellä pimeässä niin paljon kuin haluaa ilman että lampun virta vähenee.",
                containsInOrder(out, "99", "98", "97"));
    }

    private boolean containsInOrder(String data, String... args) {
        int lastIndex = -1;
        for (String arg : args) {
            if (!data.contains(arg)) {
                return false;
            }

            if (data.indexOf(arg) <= lastIndex) {
                return false;
            }

            lastIndex = data.indexOf(arg);
        }

        return true;
    }
}
