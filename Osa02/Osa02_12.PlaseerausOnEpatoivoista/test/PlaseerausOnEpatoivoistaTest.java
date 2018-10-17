
import fi.helsinki.cs.tmc.edutestutils.Points;
import javafx.stage.Stage;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.fail;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.hasText;

@Points("02-12")
public class PlaseerausOnEpatoivoistaTest extends ApplicationTest {

    static {
        if (Boolean.getBoolean("SERVER")) {

            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("glass.platform", "Monocle");
            System.setProperty("monocle.platform", "Headless");

        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        new PlaseerausOnEpatoivoista().start(stage);
    }

    @Test
    public void nappiOnOlemassa() {
        // expect:
        verifyThat("#nappi", hasText(containsString("toivoista")));
    }

    @Test
    public void tekstiKentatOlemassa() {
        // expect:
        verifyThat("#vieraita", hasText("0"));
    }

    @Test
    public void vieraitaEka() {
        clickOn("#vieraita");
        eraseText(1);
        write("3");
        clickOn("#nappi");

        try {
            verifyThat("#vaihtoehtoja", hasText(containsString("6")));
        } catch (Throwable t) {
            fail("Kun vieraita on 3, vaihtoehtoja pitäisi olla 6.");
        }
    }

    @Test
    public void vieraitaToka() {
        clickOn("#vieraita");
        eraseText(1);
        write("8");
        clickOn("#nappi");

        try {
            verifyThat("#vaihtoehtoja", hasText(containsString("40320")));
        } catch (Throwable t) {
            fail("Kun vieraita on 8, vaihtoehtoja pitäisi olla 40320.");
        }
    }
    
    @Test
    public void vieraitaKolmas() {
        clickOn("#vieraita");
        eraseText(1);
        write("19");
        clickOn("#nappi");

        try {
            verifyThat("#vaihtoehtoja", hasText(containsString("121645100408832000")));
        } catch (Throwable t) {
            fail("Kun vieraita on 19, vaihtoehtoja pitäisi olla 121645100408832000.<br/>Käytä laskemisessa tehtäväpohjassa vinkattua long-muuttujatyyppiä.");
        }
    }

}
