
import fi.helsinki.cs.tmc.edutestutils.Points;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import static org.junit.Assert.fail;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.hasText;

@Points("01-22")
public class MaaraTest extends ApplicationTest {

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
        new Maara().start(stage);
    }

    @Test
    public void nollassaEiLainkaan() {
        clickOn("#liukuri");
        press(MouseButton.PRIMARY);
        moveBy(-150, 0);
        release(MouseButton.PRIMARY);

        try {

            verifyThat("#teksti", hasText("Ei lainkaan."));
        } catch (Throwable t) {
            fail("Kun liukuri viedään vasemmalle, tekstin tulee olla \"Ei lainkaan.\"");
        }
    }

    @Test
    public void sadassaKaikki() {
        clickOn("#liukuri");
        press(MouseButton.PRIMARY);
        moveBy(150, 0);
        release(MouseButton.PRIMARY);

        try {

            verifyThat("#teksti", hasText("Kaikki."));
        } catch (Throwable t) {
            fail("Kun liukuri viedään oikealle, tekstin tulee olla \"Kaikki.\"");
        }
    }

}
