package sovellus;

import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

public class SovellusTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    @Points("14-03.1")
    public void onParametritonKonstruktori() {
        Reflex.reflect("sovellus.Peliruudukko").ctor().takingNoParams().requirePublic();
    }

    @Test
    @Points("14-03.1")
    public void onMetodiGetTaulukko() {
        Reflex.reflect("sovellus.Peliruudukko").method("getTaulukko").returning(int[][].class).takingNoParams().requirePublic();
    }

    @Test
    @Points("14-03.1")
    public void onMetodiSetTaulukko() {
        Reflex.reflect("sovellus.Peliruudukko").method("setTaulukko").returningVoid().taking(int[][].class).requirePublic();
    }

    @Test
    @Points("14-03.1")
    public void parametritonKonstruktoriLuo4x4TaulukonJossaVasenYlaKulma1() throws Throwable {
        Object ruudukko = Reflex.reflect("sovellus.Peliruudukko").ctor().takingNoParams().invoke();
        int[][] taul = kutsuGetTaulukko(ruudukko);
        assertEquals(1, taul[0][0]);
        assertEquals(1, lukujenSumma(taul));
    }

    @Test
    @Points("14-03.2")
    public void onMetodiSiirraOikealle() {
        Reflex.reflect("sovellus.Peliruudukko").method("siirraOikealle").returningVoid().takingNoParams().isPublic();
    }

    @Test
    @Points("14-03.2")
    public void siirraOikealle1() throws Throwable {

        int[][] taul = new int[4][4];
        taul[0][0] = 1;
        taul[1][1] = 1;
        taul[2][2] = 1;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        Reflex.reflect("sovellus.Peliruudukko").method("siirraOikealle").returningVoid().takingNoParams().invokeOn(ruudukko);

        int[][] t = kutsuGetTaulukko(ruudukko);
        for (int i = 0; i < 4; i++) {
            assertEquals("Kutsuttiin siirraOikealle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 1, t[i][3]);
        }

        assertEquals("Kutsuttiin siirraOikealle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 4, lukujenSumma(t));
    }

    @Test
    @Points("14-03.2")
    public void siirraOikealle2() throws Throwable {

        int[][] taul = new int[4][4];
        taul[0][0] = 4;
        taul[0][1] = 2;
        taul[0][2] = 1;
        taul[0][3] = 1;

        taul[1][0] = 1;
        taul[1][1] = 1;
        taul[1][2] = 2;
        taul[1][3] = 4;

        taul[2][0] = 1;
        taul[2][1] = 2;
        taul[2][2] = 4;
        taul[2][3] = 1;

        taul[3][0] = 1;
        taul[3][1] = 4;
        taul[3][2] = 2;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        Reflex.reflect("sovellus.Peliruudukko").method("siirraOikealle").returningVoid().takingNoParams().invokeOn(ruudukko);

        int[][] t = kutsuGetTaulukko(ruudukko);
        assertEquals("Kutsuttiin siirraOikealle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 8, t[0][3]);
        assertEquals("Kutsuttiin siirraOikealle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 8, t[1][3]);
        assertEquals("Kutsuttiin siirraOikealle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 4, t[2][2]);
        assertEquals("Kutsuttiin siirraOikealle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 2, t[3][2]);

        assertEquals("Kutsuttiin siirraOikealle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 32, lukujenSumma(t));
    }

    @Test
    @Points("14-03.3")
    public void onMetodiSiirraYlos() {
        Reflex.reflect("sovellus.Peliruudukko").method("siirraYlos").returningVoid().takingNoParams().isPublic();
    }

    @Test
    @Points("14-03.3")
    public void siirraYlos1() throws Throwable {

        int[][] taul = new int[4][4];
        taul[0][0] = 1;
        taul[1][1] = 1;
        taul[2][2] = 1;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        Reflex.reflect("sovellus.Peliruudukko").method("siirraYlos").returningVoid().takingNoParams().invokeOn(ruudukko);

        int[][] t = kutsuGetTaulukko(ruudukko);
        for (int i = 0; i < 4; i++) {
            assertEquals("Kutsuttiin siirraYlos-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 1, t[0][i]);
        }

        assertEquals("Kutsuttiin siirraYlos-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 4, lukujenSumma(t));
    }

    @Test
    @Points("14-03.3")
    public void siirraYlos2() throws Throwable {

        int[][] taul = new int[4][4];
        taul[0][0] = 4;
        taul[1][0] = 2;
        taul[2][0] = 1;
        taul[3][0] = 1;

        taul[0][1] = 1;
        taul[1][1] = 1;
        taul[2][1] = 2;
        taul[3][1] = 4;

        taul[0][2] = 1;
        taul[1][2] = 2;
        taul[2][2] = 4;
        taul[3][2] = 1;

        taul[0][3] = 1;
        taul[1][3] = 4;
        taul[2][3] = 2;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        Reflex.reflect("sovellus.Peliruudukko").method("siirraYlos").returningVoid().takingNoParams().invokeOn(ruudukko);

        int[][] t = kutsuGetTaulukko(ruudukko);
        assertEquals("Kutsuttiin siirraYlos-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 8, t[0][0]);
        assertEquals("Kutsuttiin siirraYlos-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 8, t[0][1]);
        assertEquals("Kutsuttiin siirraYlos-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 4, t[2][2]);
        assertEquals("Kutsuttiin siirraYlos-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 2, t[2][3]);

        assertEquals("Kutsuttiin siirraYlos-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 32, lukujenSumma(t));
    }

    @Test
    @Points("14-03.3")
    public void onMetodiSiirraAlas() {
        Reflex.reflect("sovellus.Peliruudukko").method("siirraAlas").returningVoid().takingNoParams().isPublic();
    }

    @Test
    @Points("14-03.3")
    public void siirraAlas1() throws Throwable {

        int[][] taul = new int[4][4];
        taul[0][0] = 1;
        taul[1][1] = 1;
        taul[2][2] = 1;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        Reflex.reflect("sovellus.Peliruudukko").method("siirraAlas").returningVoid().takingNoParams().invokeOn(ruudukko);

        int[][] t = kutsuGetTaulukko(ruudukko);
        for (int i = 0; i < 4; i++) {
            assertEquals("Kutsuttiin siirraAlas-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 1, t[3][i]);
        }

        assertEquals("Kutsuttiin siirraAlas-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 4, lukujenSumma(t));
    }

    @Test
    @Points("14-03.3")
    public void siirraAlas2() throws Throwable {

        int[][] taul = new int[4][4];
        taul[0][0] = 4;
        taul[1][0] = 2;
        taul[2][0] = 1;
        taul[3][0] = 1;

        taul[0][1] = 1;
        taul[1][1] = 1;
        taul[2][1] = 2;
        taul[3][1] = 4;

        taul[0][2] = 1;
        taul[1][2] = 2;
        taul[2][2] = 4;
        taul[3][2] = 1;

        taul[0][3] = 1;
        taul[1][3] = 4;
        taul[2][3] = 2;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        Reflex.reflect("sovellus.Peliruudukko").method("siirraAlas").returningVoid().takingNoParams().invokeOn(ruudukko);

        int[][] t = kutsuGetTaulukko(ruudukko);
        assertEquals("Kutsuttiin siirraAlas-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 8, t[3][0]);
        assertEquals("Kutsuttiin siirraAlas-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 8, t[3][1]);
        assertEquals("Kutsuttiin siirraAlas-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 4, t[2][2]);
        assertEquals("Kutsuttiin siirraAlas-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 2, t[2][3]);

        assertEquals("Kutsuttiin siirraAlas-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 32, lukujenSumma(t));
    }

    @Test
    @Points("14-03.4")
    public void onMetodiSiirraVasemmalle() {
        Reflex.reflect("sovellus.Peliruudukko").method("siirraVasemmalle").returningVoid().takingNoParams().isPublic();
    }

    @Test
    @Points("14-03.4")
    public void siirraVasemmalle1() throws Throwable {

        int[][] taul = new int[4][4];
        taul[0][0] = 1;
        taul[1][1] = 1;
        taul[2][2] = 1;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        Reflex.reflect("sovellus.Peliruudukko").method("siirraVasemmalle").returningVoid().takingNoParams().invokeOn(ruudukko);

        int[][] t = kutsuGetTaulukko(ruudukko);
        for (int i = 0; i < 4; i++) {
            assertEquals("Kutsuttiin siirraVasemmalle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 1, t[i][0]);
        }

        assertEquals("Kutsuttiin siirraVasemmalle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 4, lukujenSumma(t));
    }

    @Test
    @Points("14-03.4")
    public void siirraVasemmalle2() throws Throwable {

        int[][] taul = new int[4][4];
        taul[0][0] = 4;
        taul[0][1] = 2;
        taul[0][2] = 1;
        taul[0][3] = 1;

        taul[1][0] = 1;
        taul[1][1] = 1;
        taul[1][2] = 2;
        taul[1][3] = 4;

        taul[2][0] = 1;
        taul[2][1] = 2;
        taul[2][2] = 4;
        taul[2][3] = 1;

        taul[3][0] = 1;
        taul[3][1] = 4;
        taul[3][2] = 2;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        Reflex.reflect("sovellus.Peliruudukko").method("siirraVasemmalle").returningVoid().takingNoParams().invokeOn(ruudukko);

        int[][] t = kutsuGetTaulukko(ruudukko);
        assertEquals("Kutsuttiin siirraVasemmalle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 8, t[0][0]);
        assertEquals("Kutsuttiin siirraVasemmalle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 8, t[1][0]);
        assertEquals("Kutsuttiin siirraVasemmalle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 4, t[2][2]);
        assertEquals("Kutsuttiin siirraVasemmalle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 2, t[3][2]);

        assertEquals("Kutsuttiin siirraVasemmalle-metodia taulukolle:\n" + taulukko(taul) + "\nTulos oli:\n" + taulukko(t), 32, lukujenSumma(t));
    }

    @Test
    @Points("14-03.4")
    public void onMetodiPeliKaynnissa() {
        Reflex.reflect("sovellus.Peliruudukko").method("peliKaynnissa").returning(boolean.class).takingNoParams().isPublic();
    }

    @Test
    @Points("14-03.4")
    public void peliKaynnissaKoskaNolla() throws Throwable {
        int[][] taul = new int[4][4];
        taul[0][0] = 8;
        taul[0][1] = 4;
        taul[0][2] = 2;
        taul[0][3] = 1;

        taul[1][0] = 1;
        taul[1][1] = 2;
        taul[1][2] = 4;
        taul[1][3] = 8;

        taul[2][0] = 0;
        taul[2][1] = 8;
        taul[2][2] = 1;
        taul[2][3] = 2;

        taul[3][0] = 2;
        taul[3][1] = 4;
        taul[3][2] = 8;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        boolean kaynnissa = Reflex.reflect("sovellus.Peliruudukko").method("peliKaynnissa").returning(boolean.class).takingNoParams().invokeOn(ruudukko);
        assertTrue("Metodi peliKaynnissa palautti arvon false kun peli on:\n" + taulukko(taul), kaynnissa);
    }

    @Test
    @Points("14-03.4")
    public void peliEiKaynnissa() throws Throwable {
        int[][] taul = new int[4][4];
        taul[0][0] = 8;
        taul[0][1] = 4;
        taul[0][2] = 2;
        taul[0][3] = 1;

        taul[1][0] = 1;
        taul[1][1] = 2;
        taul[1][2] = 4;
        taul[1][3] = 8;

        taul[2][0] = 4;
        taul[2][1] = 8;
        taul[2][2] = 1;
        taul[2][3] = 2;

        taul[3][0] = 2;
        taul[3][1] = 4;
        taul[3][2] = 8;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        boolean kaynnissa = Reflex.reflect("sovellus.Peliruudukko").method("peliKaynnissa").returning(boolean.class).takingNoParams().invokeOn(ruudukko);
        assertFalse("Metodi peliKaynnissa palautti arvon true kun peli on:\n" + taulukko(taul), kaynnissa);
    }

    @Test
    @Points("14-03.5")
    public void tekstikayttoliittymaKaynnistyy() throws Throwable {
        io.setSysIn("x\n");
        try {
            Peli.main(new String[]{});
        } catch (Throwable t) {
            fail("Virhe kun tekstikäyttöliittymä käynnistettiin, ja tekstikäyttöliittymässä annettiin komento x: " + t.getMessage());
        }

        String out = io.getSysOut();

        if (out.split("\n").length < 5) {
            fail("Kun tekstikäyttöliittymä käynnistetään, tulostuksessa pitäisi näkyä pelitilanne\n1 0 0 0\n0 0 0 0\n0 0 0 0\n0 0 0 0\nNyt tulostus oli:\n" + out);
        }

        int[][] taul = getLastTable(out);
        assertEquals("Kun tekstikäyttöliittymä käynnistetään, tulostuksessa pitäisi näkyä pelitilanne\n1 0 0 0\n0 0 0 0\n0 0 0 0\n0 0 0 0\nNyt tekstikäyttöliittymän käynnistys näytti:\n" + taulukko(taul), 1, lukujenSumma(taul));
        assertEquals("Kun tekstikäyttöliittymä käynnistetään, tulostuksessa pitäisi näkyä pelitilanne\n1 0 0 0\n0 0 0 0\n0 0 0 0\n0 0 0 0\nNyt tekstikäyttöliittymän käynnistys näytti:\n" + taulukko(taul), 1, taul[0][0]);
    }

    @Test
    @Points("14-03.5")
    public void oikealleSiirtaminenTekstikayttoliittymassa() throws Throwable {
        io.setSysIn("o\nx\n");
        try {
            Peli.main(new String[]{});
        } catch (Throwable t) {
            fail("Virhe kun tekstikäyttöliittymä käynnistettiin, ja tekstikäyttöliittymässä annettiin komento o ja x: " + t.getMessage());
        }

        String out = io.getSysOut();

        if (out.split("\n").length < 4) {
            fail("Kun tekstikäyttöliittymä käynnistetään ja siirretään oikealle, viimeksi tulostetun pelitilanteen oikeassa yläkulmassa pitäisi olla arvo 1.\n" + out);
        }

        int[][] taul = getLastTable(out);

        assertEquals("Kun tekstikäyttöliittymä käynnistetään ja tehdään siirto oikealle, viimeksi tulostetun pelitilanteen oikeassa yläkulmassa pitäisi olla arvo 1.\nNyt tekstikäyttöliittymän käynnistys näytti:\n" + taulukko(taul), 1, taul[0][3]);
        assertEquals("Kun tekstikäyttöliittymä käynnistetään ja siirretään oikealle, uusi luku 1 pitäisi asettaa satunnaiseen tyhjään kohtaan.\nNyt tekstikäyttöliittymän käynnistys näytti:\n" + taulukko(taul), 2, lukujenSumma(taul));
    }

    @Test
    @Points("14-03.5")
    public void siirtaminenTekstikayttoliittymassa() throws Throwable {
        String siirrot = "o\na\nv\ny\no\nx\n";
        io.setSysIn(siirrot);
        try {
            Peli.main(new String[]{});
        } catch (Throwable t) {
            fail("Virhe kun tekstikäyttöliittymä käynnistettiin, ja tekstikäyttöliittymässä annettiin komennot:\n" + siirrot + "\nVirhe:" + t.getMessage());
        }

        String out = io.getSysOut();

        int[][] taul = getLastTable(out);

        assertEquals("Kun tekstikäyttöliittymä käynnistetään ja tehdään siirrot:\n" + siirrot + "\nViimeksi tulostetun pelitilanteen arvojen summan pitäisi olla 6.\nNyt tekstikäyttöliittymän käynnistys näytti:\n" + taulukko(taul), 6, lukujenSumma(taul));
    }

    private int[][] getLastTable(String out) {
        String[] lines = out.split("\n");
        int[][] table = new int[4][4];
        int tableYIndex = 3;

        for (int i = lines.length - 1; i >= 0; i--) {
            String line = lines[i];
            line = line.replaceAll("[^\\d]", " ");

            String[] parts = line.trim().split("\\s+");
            if (parts.length <= 2) {
                continue;
            }

            try {
                Integer.parseInt(parts[0]);
                Integer.parseInt(parts[1]);
                Integer.parseInt(parts[2]);
                Integer.parseInt(parts[3]);
            } catch (Throwable t) {
                continue;
            }

            for (int x = 0; x < parts.length; x++) {
                table[tableYIndex][x] = Integer.parseInt(parts[x]);
            }
            tableYIndex--;

            if (tableYIndex < 0) {
                break;
            }
        }

        return table;
    }

    @Test
    @Points("14-03.4")
    public void peliKaynnissaVierekkaisetVoiYhdistaa() throws Throwable {
        int[][] taul = new int[4][4];
        taul[0][0] = 8;
        taul[0][1] = 4;
        taul[0][2] = 2;
        taul[0][3] = 1;

        taul[1][0] = 1;
        taul[1][1] = 2;
        taul[1][2] = 4;
        taul[1][3] = 8;

        taul[2][0] = 4;
        taul[2][1] = 8;
        taul[2][2] = 1;
        taul[2][3] = 1;

        taul[3][0] = 2;
        taul[3][1] = 4;
        taul[3][2] = 8;
        taul[3][3] = 1;

        Object ruudukko = luoRuudukkoTaulukolla(copy(taul));
        boolean kaynnissa = Reflex.reflect("sovellus.Peliruudukko").method("peliKaynnissa").returning(boolean.class).takingNoParams().invokeOn(ruudukko);
        assertTrue("Metodi peliKaynnissa palautti arvon false kun peli on:\n" + taulukko(taul), kaynnissa);
    }

    private int lukujenSumma(int[][] taulukko) {
        int summa = 0;
        for (int y = 0; y < taulukko.length; y++) {
            for (int x = 0; x < taulukko[y].length; x++) {
                summa += taulukko[y][x];
            }
        }

        return summa;
    }

    private int[][] kutsuGetTaulukko(Object ruudukko) throws Throwable {
        return Reflex.reflect("sovellus.Peliruudukko").method("getTaulukko").returning(int[][].class).takingNoParams().invokeOn(ruudukko);
    }

    private void kutsuSetTaulukko(Object ruudukko, int[][] taul) throws Throwable {
        Reflex.reflect("sovellus.Peliruudukko").method("setTaulukko").returningVoid().taking(int[][].class).invokeOn(ruudukko, taul);
    }

    private Object luoRuudukkoTaulukolla(int[][] taul) throws Throwable {
        Object ruudukko = Reflex.reflect("sovellus.Peliruudukko").ctor().takingNoParams().invoke();
        kutsuSetTaulukko(ruudukko, taul);
        return ruudukko;
    }

    private String taulukko(int[][] t) {

        StringBuilder palautus = new StringBuilder();
        for (int y = 0; y < t.length; y++) {
            for (int x = 0; x < t[y].length; x++) {
                palautus.append(t[y][x]).append(" ");
            }
            palautus.append("\n");
        }

        return palautus.toString();
    }

    public static int[][] copy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
