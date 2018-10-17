
import fi.helsinki.cs.tmc.edutestutils.Points;
import javafx.stage.Stage;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.fail;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.hasText;

@Points("01-10")
public class JakolaskinTest extends ApplicationTest {

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
        new Jakolaskin().start(stage);
    }

    @Test
    public void nappiOnOlemassa() {
        // expect:
        verifyThat("#nappi", hasText(" / "));
    }

    @Test
    public void tekstiKentatOlemassa() {
        // expect:
        verifyThat("#luku1", hasText("0"));
        verifyThat("#luku2", hasText("0"));
    }

    @Test
    public void jakolaskuEka() {
        clickOn("#luku1");
        eraseText(1);
        write("1");
        clickOn("#luku2");
        eraseText(1);
        write("2");
        clickOn("#nappi");

        try {
            verifyThat("#osamaara", hasText(containsString("0.5")));
        } catch (Throwable t) {
            fail("Kun laskettiin jakolaskua 1 / 2, laskun tulos ei ollut 0.5");
        }
    }

    @Test
    public void jakolaskuToka() {
        clickOn("#luku1");
        eraseText(1);
        write("42");
        clickOn("#luku2");
        eraseText(1);
        write("2");
        clickOn("#nappi");
        
        try {
            verifyThat("#osamaara", hasText(containsString("21.")));
        } catch (Throwable t) {
            fail("Kun laskettiin jakolaskua 42 / 2, laskun tulos ei ollut 21.0");
        }
    }

}
