package sovellus;

import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KirjoitusharjoitteluSovellusTest {

    @Test
    @Points("14-04.1 14-04.2")
    public void noTests() {
        assertTrue("Kirjoita toteuttamastasi ominaisuudesta vähintään 100 merkkiä.", KirjoitusharjoitteluSovellus.toteutettuOminaisuus().length() > 100);
    }
}
