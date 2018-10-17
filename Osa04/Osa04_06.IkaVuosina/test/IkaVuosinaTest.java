
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;

@Points("04-06")
public class IkaVuosinaTest {

    @Test
    public void ikaVuosinaTest() {
        LocalDate now = LocalDate.now();

        int vuosia = 0;
        while (vuosia < 20) {
            now = now.minusDays(370);
            vuosia++;

            Henkilo h = new Henkilo("Chronos", now.getDayOfMonth(), now.getMonthValue(), now.getYear());
            assertEquals("Kun henkilö on syntynyt " + (370 * vuosia) + " päivää sitten, tulisi hänen olla " + vuosia + " vanha.\n Kokeile:\nHenkilo h = new Henkilo(\"Esim\", " + now.getDayOfMonth() + ", " + now.getMonthValue() + ", " + now.getYear() + ");\nSystem.out.println(h.ikaVuosina());", vuosia, h.ikaVuosina());
        }

    }
}
