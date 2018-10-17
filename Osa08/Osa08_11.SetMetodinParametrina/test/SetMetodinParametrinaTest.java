
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

@Points("08-11")
public class SetMetodinParametrinaTest {

    @Test
    public void onMetodiPalautaKoko() {
        Reflex.reflect(JoukonTarkistin.class).method("palautaKoko").returning(int.class).taking(Set.class).requireExists();
    }

    @Test
    public void metodiPalauttaaAnnetunSetinKoon() throws Throwable {
        JoukonTarkistin tarkistin = new JoukonTarkistin();

        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int koko = rnd.nextInt(10);
            Set<String> set = null;

            if (rnd.nextBoolean()) {
                set = new HashSet<>();
            } else {
                set = new TreeSet<>();
            }

            for (int j = 0; j < koko; j++) {
                set.add(UUID.randomUUID().toString());
            }

            int arvoja = (int) Reflex.reflect(JoukonTarkistin.class).method("palautaKoko").returning(int.class).taking(Set.class).invokeOn(tarkistin, set);
            assertEquals("Kun metodille palautaKoko annetaan " + koko + ":n alkion kokoinen set-olio, tulisi palautetun arvon olla " + koko + ". Nyt palautettu arvo oli " + arvoja, koko, arvoja);
        }

    }

}
