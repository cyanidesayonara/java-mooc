
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

@Points("05-18")
public class LukutaitoTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void tulostusSisaltaa() {
        io.setSysIn("");
        Lukutaito.main(new String[0]);

        String[] out = io.getSysOut().split("\n");
        assertTrue("Tulostuksessa tulee olla merkkijono \"Miesten lukutaidon keskiarvo:\".", Arrays.stream(out).filter(s -> s.contains("Miesten")).count() > 0);
        assertTrue("Tulostuksessa tulee olla merkkijono \"Naisten lukutaidon keskiarvo:\".", Arrays.stream(out).filter(s -> s.contains("Naisten")).count() > 0);
        assertTrue("Tulostuksessa tulee olla merkkijono \"Korkein lukutaito on maassa:\".", Arrays.stream(out).filter(s -> s.contains("Korkein")).count() > 0);
    }

}
