package sovellus;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import javafx.application.Application;
import javafx.stage.Stage;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.matcher.base.NodeMatchers.hasText;

public class VitsiSovellusTest extends ApplicationTest {

    private Stage stage;

    static {
        if (Boolean.getBoolean("SERVER")) {

            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("glass.platform", "Monocle");
            System.setProperty("monocle.platform", "Headless");
            System.setProperty("java.awt.headless", "false");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        VitsiSovellus sovellus = new VitsiSovellus();

        try {
            Application app = Application.class.cast(sovellus);
        } catch (Throwable t) {
            fail("Periihän luokka VitsiSovellus luokan Application.");
        }

        try {
            Reflex.reflect(VitsiSovellus.class).method("start").returningVoid().taking(Stage.class).invokeOn(sovellus, stage);
        } catch (Throwable ex) {
            fail("Onhan luokalla VitsiSovellus metodi start, joka saa parametrina Stage-olion. Jos on, tarkista että metodi toimii. Virhe: " + ex.getMessage());
        }

        this.stage = stage;
    }

    @Test
    @Points("13-07")
    public void tarkista() {
        FxAssert.verifyThat(".label", hasText("What do you call a bear with no teeth?"));
        clickOn("Vitsi");
        FxAssert.verifyThat(".label", hasText("What do you call a bear with no teeth?"));
        clickOn("Vastaus");
        FxAssert.verifyThat(".label", hasText("A gummy bear."));
        clickOn("Vitsi");
        FxAssert.verifyThat(".label", hasText("What do you call a bear with no teeth?"));
        clickOn("Selitys");
        FxAssert.verifyThat(".label", NodeMatchers.isNotNull());
    }
}
