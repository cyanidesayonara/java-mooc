package hirsipuu;

import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@Points("11-10.1")
public class ASanalistaTest {

    @Test
    public void sanalistanKokoOikea() throws Throwable {
        List<String> sanat = listaSanoja1();
        Sanalista sl = new Sanalista(sanat);
        assertEquals("Sanalistan koko-metodin tulee palauttaa sanalistalla olevien sanojen lukumäärä. Nyt näin ei käy.", sanat.size(), sl.koko());

        sanat = listaSanoja2();
        sl = new Sanalista(sanat);
        assertEquals("Sanalistan koko-metodin tulee palauttaa sanalistalla olevien sanojen lukumäärä. Nyt näin ei käy.", sanat.size(), sl.koko());
    }
    
    
    @Test
    public void sanatMetodi() throws Throwable {
        List<String> sanat = listaSanoja3();
        Sanalista sl = new Sanalista(sanat);
        
        assertEquals("Tarkista sanalistan sanat-metodin toiminta.", sanat, sl.sanat());
    }


    @Test
    public void sanatJoidenPituusOn() throws Throwable {
        List<String> sanat = listaSanoja3();
        Sanalista sl = new Sanalista(sanat);
        Sanalista rajattu = sl.sanatJoidenPituusOn(4);

        assertFalse("Sanalistan sanatJoidenPituusOn-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joiden pituus on parametrina annettu luku. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoidenPituusOn-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joiden pituus on parametrina annettu luku. Nyt rajatulla sanalistalla oli väärä määrä alkioita.", 2, rajattu.koko());

        sanat = listaSanoja3();
        sl = new Sanalista(sanat);
        rajattu = sl.sanatJoidenPituusOn(1);

        assertFalse("Sanalistan sanatJoidenPituusOn-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joiden pituus on parametrina annettu luku. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoidenPituusOn-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joiden pituus on parametrina annettu luku. Nyt rajatulla sanalistalla oli väärä määrä alkioita.", 1, rajattu.koko());

        sanat = listaSanoja3();
        sl = new Sanalista(sanat);
        rajattu = sl.sanatJoidenPituusOn(17);

        assertFalse("Sanalistan sanatJoidenPituusOn-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joiden pituus on parametrina annettu luku. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoidenPituusOn-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joiden pituus on parametrina annettu luku. Nyt rajatulla sanalistalla oli väärä määrä alkioita.", 0, rajattu.koko());
    }

    @Test
    public void sanatJoissaEiEsiinnyKirjainta() throws Throwable {
        List<String> sanat = listaSanoja1();
        Sanalista sl = new Sanalista(sanat);
        Sanalista rajattu = sl.sanatJoissaEiEsiinnyKirjainta('r');

        assertFalse("Sanalistan sanatJoissaEiEsiinnyKirjainta-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annettua kirjainta ei esiinny. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoissaEiEsiinnyKirjainta-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annettua kirjainta ei esiinny. Nyt rajatulla sanalistalla oli väärä määrä sanoja.", 1, rajattu.koko());

        sanat = listaSanoja1();
        sl = new Sanalista(sanat);
        rajattu = sl.sanatJoissaEiEsiinnyKirjainta('a');

        assertFalse("Sanalistan sanatJoissaEiEsiinnyKirjainta-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annettua kirjainta ei esiinny. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoissaEiEsiinnyKirjainta-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annettua kirjainta ei esiinny. Nyt rajatulla sanalistalla oli väärä määrä sanoja.", 0, rajattu.koko());

        sanat = listaSanoja2();
        sl = new Sanalista(sanat);
        rajattu = sl.sanatJoissaEiEsiinnyKirjainta('k');
        rajattu = rajattu.sanatJoissaEiEsiinnyKirjainta('n');

        assertFalse("Sanalistan sanatJoissaEiEsiinnyKirjainta-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annettua kirjainta ei esiinny. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoissaEiEsiinnyKirjainta-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annettua kirjainta ei esiinny. Nyt rajatulla sanalistalla oli väärä määrä sanoja.", 1, rajattu.koko());
    }
    
    @Test
    public void sanatJoissaMerkit() throws Throwable {
        List<String> sanat = listaSanoja1();
        Sanalista sl = new Sanalista(sanat);
        Sanalista rajattu = sl.sanatJoissaMerkit("---ni-");

        assertFalse("Sanalistan sanatJoissaMerkit-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annetussa merkkijonossa olevat merkit esiintyvät annetuilla kohdilla. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoissaMerkit-metodin tulee uusi sanalista-olio, jossa on vain ne sanat,  joissa parametrina annetussa merkkijonossa olevat merkit esiintyvät annetuilla kohdilla. Nyt rajatulla sanalistalla oli väärä määrä sanoja.", 1, rajattu.koko());

        sanat = listaSanoja1();
        sl = new Sanalista(sanat);
        rajattu = sl.sanatJoissaMerkit("---r--");

        assertFalse("Sanalistan sanatJoissaMerkit-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annetussa merkkijonossa olevat merkit esiintyvät annetuilla kohdilla. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoissaMerkit-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annetussa merkkijonossa olevat merkit esiintyvät annetuilla kohdilla. Nyt rajatulla sanalistalla oli väärä määrä sanoja.", 2, rajattu.koko());


        sanat = listaSanoja2();
        sl = new Sanalista(sanat);
        rajattu = sl.sanatJoissaMerkit("-aur--");

        assertFalse("Sanalistan sanatJoissaMerkit-metodin tulee uusi sanalista-olio, jossa on vain ne sanat, joissa parametrina annetussa merkkijonossa olevat merkit esiintyvät annetuilla kohdilla. Nyt palautettu olio on sama kuin alkuperäinen.", sl.equals(rajattu));
        assertEquals("Sanalistan sanatJoissaMerkit-metodin tulee uusi sanalista-olio, jossa on vain ne sanat,  joissa parametrina annetussa merkkijonossa olevat merkit esiintyvät annetuilla kohdilla. Nyt rajatulla sanalistalla oli väärä määrä sanoja.", 3, rajattu.koko());
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
