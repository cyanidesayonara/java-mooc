package hirsipuu;

import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Points("11-10.2")
public class BHirsipuuTest {

    @Test
    public void hirsipuuSailyttaaArvatutKirjaimet() throws Throwable {
        Hirsipuu hirsipuu = new Hirsipuu(new Sanalista(listaSanoja2()), 7);
        assertNotNull(hirsipuu.arvaukset());
        assertTrue(hirsipuu.arvaukset().isEmpty());
        hirsipuu.arvaa('h');
        assertEquals(1, hirsipuu.arvaukset().size());
        assertTrue(hirsipuu.arvaukset().contains('h'));
        hirsipuu.arvaa('k');
        assertEquals(2, hirsipuu.arvaukset().size());
        assertTrue(hirsipuu.arvaukset().contains('h'));
        assertTrue(hirsipuu.arvaukset().contains('k'));
    }

    @Test
    public void arvauksiaJaljellaOikeaMaaraAlussa() throws Throwable {
        Hirsipuu hirsipuu = new Hirsipuu(new Sanalista(listaSanoja1()), 5);
        assertEquals(5, hirsipuu.arvauksiaJaljella());
    }

    @Test
    public void arvaustenLukumaaraVaheneeYhdellaKunArvataanVaarin() throws Throwable {
        Hirsipuu hirsipuu = new Hirsipuu(new Sanalista(listaSanoja3()), 5);
        hirsipuu.arvaa('f');
        assertEquals(4, hirsipuu.arvauksiaJaljella());
    }

    @Test
    public void merkkiLoytyyArvauksesta() throws Throwable {
        Hirsipuu hirsipuu = new Hirsipuu(new Sanalista(listaSanoja1()), 5);
        assertEquals("------", hirsipuu.sana());
        hirsipuu.arvaa('a');
        assertEquals(5, hirsipuu.arvauksiaJaljella());
        assertEquals("-a----", hirsipuu.sana());
        hirsipuu.arvaa('u');
        assertEquals(5, hirsipuu.arvauksiaJaljella());
        assertEquals("-au---", hirsipuu.sana());
    }
    
    @Test
    public void peliLoppuuKunKokoSanaArvattu() throws Throwable {
        Hirsipuu hirsipuu = new Hirsipuu(new Sanalista(listaSanoja1()), 5);
        hirsipuu.arvaa('a');
        assertEquals(5, hirsipuu.arvauksiaJaljella());
        assertEquals("-a----", hirsipuu.sana());
        hirsipuu.arvaa('u');
        assertEquals(5, hirsipuu.arvauksiaJaljella());
        assertEquals("-au---", hirsipuu.sana());
        hirsipuu.arvaa('i');
        assertEquals(5, hirsipuu.arvauksiaJaljella());
        assertEquals("-au-i-", hirsipuu.sana());
        hirsipuu.arvaa('s');
        assertEquals(5, hirsipuu.arvauksiaJaljella());
        assertEquals("-au-is", hirsipuu.sana());
        
        assertFalse(hirsipuu.onLoppu());
        hirsipuu.arvaa('n');
        hirsipuu.arvaa('k');
        hirsipuu.arvaa('r');
        assertTrue(hirsipuu.onLoppu());
    }


    public List<String> listaSanoja1() {
        List<String> sanat = new ArrayList<>();
        sanat.add("nauris");
        sanat.add("kauris");
        sanat.add("kaunis");
        return sanat;
    }

    public List<String> listaSanoja2() {
        List<String> sanat = new ArrayList<>();
        sanat.add("nauris");
        sanat.add("kauris");
        sanat.add("kaunis");
        sanat.add("hauras");
        return sanat;
    }

    public List<String> listaSanoja3() {
        List<String> sanat = new ArrayList<>();
        sanat.add("a");
        sanat.add("bb");
        sanat.add("ccc");
        sanat.add("dddd");
        sanat.add("eeee");
        return sanat;
    }
}
