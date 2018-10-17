package hiekkaranta;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class SovellusXTest {

    @Test
    @Points("12-10.2")
    public void simulaationAlkupalat() {
        Reflex.reflect("hiekkaranta.Simulaatio").requirePublic();
        Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).requirePublic();
        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).requirePublic();
        Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).requirePublic();
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().requirePublic();

        assertTrue("Kun olet tehnyt toisen osan, muistathan päivittää myös luokan HiekkarantaSovellus metodia toteutetutOsat palauttamaan arvon 2.", HiekkarantaSovellus.toteutetutOsat() >= 2);
    }

    @Test
    @Points("12-10.2")
    public void ulkopuolellaMetallia() {
        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(200, 100);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(200, 100) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        List<Point> pisteet = new ArrayList<>();
        pisteet.add(new Point(-1, -1));
        pisteet.add(new Point(0, -1));
        pisteet.add(new Point(-1, 0));
        pisteet.add(new Point(200, 0));
        pisteet.add(new Point(0, 100));

        for (Point point : pisteet) {
            int x = (int) point.getX();
            int y = (int) point.getY();

            Tyyppi tyyppi = null;
            try {
                tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, y);
            } catch (Throwable ex) {
                fail("Kutsu:\nSimulaatio s = new Simulaatio(200, 100);\ns.sisalto(" + x + ", " + y + ");\nEpäonnistui. Virhe: " + ex.getMessage());
            }

            assertEquals("Kokeile: Simulaatio s = new Simulaatio(200, 100);\ns.sisalto(" + x + ", " + y + ");\n. Pitäisi olla Tyyppi.METALLI.\nNyt arvo oli: " + tyyppi, Tyyppi.METALLI, tyyppi);
        }
    }

    @Test
    @Points("12-10.2")
    public void lisaaminenJaSisaltoToimii() {
        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(300, 200);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(300, 200) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        Random rnd = new Random();
        Map<Point, Tyyppi> pisteet = new HashMap<>();

        for (int i = 0; i < 30; i++) {
            int x = rnd.nextInt(300);
            int y = rnd.nextInt(200);

            double d = rnd.nextDouble();
            Tyyppi t = null;
            if (d < 0.33) {
                t = Tyyppi.METALLI;
            } else if (d < 0.66) {
                t = Tyyppi.HIEKKA;
            } else {
                t = Tyyppi.VESI;
            }

            pisteet.put(new Point(x, y), t);
        }

        for (Point piste : pisteet.keySet()) {
            Tyyppi t = pisteet.get(piste);
            int x = (int) piste.getX();
            int y = (int) piste.getY();

            try {
                Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, y, t);
            } catch (Throwable ex) {
                fail("Kutsu:\nSimulaatio s = new Simulaatio(300, 200);\ns.lisaa(" + x + ", " + y + ", Tyyppi." + t.name() + ");\nEpäonnistui. Virhe: " + ex.getMessage());
            }
        }

        for (Point piste : pisteet.keySet()) {
            int x = (int) piste.getX();
            int y = (int) piste.getY();
            Tyyppi t = pisteet.get(piste);

            Tyyppi tyyppi = null;
            try {
                tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, y);
            } catch (Throwable ex) {
                fail("Kutsu:\nSimulaatio s = new Simulaatio(300, 200);\ns.lisaa(" + x + ", " + y + ", Tyyppi." + t.name() + ");\nTyyppi t = s.sisalto(" + x + ", " + y + ");\nEpäonnistui. Virhe: " + ex.getMessage());
            }

            assertEquals("Kokeile:\nSimulaatio s = new Simulaatio(300, 200);\ns.lisaa(" + x + ", " + y + ", Tyyppi." + t.name() + ");\nTyyppi t = s.sisalto(" + x + ", " + y + ");\n Pitäisi olla Tyyppi." + t.name() + ".\nNyt arvo oli: " + tyyppi, t, tyyppi);
        }
    }

    @Test
    @Points("12-10.3")
    public void metallinLisaaminenJaPiirtaminen() {
        assertTrue("Kun olet tehnyt kolmannen osan, muistathan päivittää myös luokan HiekkarantaSovellus metodia toteutetutOsat palauttamaan arvon 3.", HiekkarantaSovellus.toteutetutOsat() >= 3);
    }

    @Test
    @Points("12-10.4")
    public void hiekanLisaaminenJaToiminnallisuus() {
        assertTrue("Kun olet tehnyt neljännen osan, muistathan päivittää myös luokan HiekkarantaSovellus metodia toteutetutOsat palauttamaan arvon 4.", HiekkarantaSovellus.toteutetutOsat() >= 4);
    }

    @Test
    @Points("12-10.5")
    public void vedenLisaaminenJaToiminnallisuus() {
        assertTrue("Kun olet tehnyt viidennen osan, muistathan päivittää myös luokan HiekkarantaSovellus metodia toteutetutOsat palauttamaan arvon 5.", HiekkarantaSovellus.toteutetutOsat() >= 5);
    }
}
