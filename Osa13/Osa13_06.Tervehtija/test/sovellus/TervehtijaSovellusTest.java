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

public class TervehtijaSovellusTest extends ApplicationTest {

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
        TervehtijaSovellus sovellus = new TervehtijaSovellus();

        try {
            Application app = Application.class.cast(sovellus);
        } catch (Throwable t) {
            fail("Periihän luokka TervehtijaSovellus luokan Application.");
        }

        try {
            Reflex.reflect(TervehtijaSovellus.class).method("start").returningVoid().taking(Stage.class).invokeOn(sovellus, stage);
        } catch (Throwable ex) {
            fail("Onhan luokalla TervehtijaSovellus metodi start, joka saa parametrina Stage-olion. Jos on, tarkista että metodi toimii. Virhe: " + ex.getMessage());
        }

        this.stage = stage;
    }

    @Test
    @Points("13-06")
    public void tervetuloaAda() {
        tarkista("Ada Lovelace");
    }

    @Test
    @Points("13-06")
    public void tervetuloaBilba() {
        tarkista("Bilba Labingi");
    }

    private void tarkista(String nimi) {
        clickOn(".text-field").write(nimi);
        clickOn(".button");
        FxAssert.verifyThat(".label", hasText("Tervetuloa " + nimi + "!"));
        FxAssert.verifyThat(".text-field", NodeMatchers.isNull());
        FxAssert.verifyThat(".button", NodeMatchers.isNull());

    }
}
