
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Test;

@Points("04-05")
public class NpeVirheOhjelmaTest {

    @Test
    public void tapahtuuNullPointerException() {
        try {
            NullPointerExceptionOhjelma.main(new String[]{});
            fail("Ohjelman suorituksessa tulee tapahtua NullPointerException-virhe. Nyt ei tapahtunut.");
        } catch (NullPointerException e) {
        }
    }
}
