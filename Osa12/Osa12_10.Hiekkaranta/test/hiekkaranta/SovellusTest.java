package hiekkaranta;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.testfx.framework.junit.ApplicationTest;

public class SovellusTest extends ApplicationTest {

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
        HiekkarantaSovellus sovellus = new HiekkarantaSovellus();

        try {
            Application app = Application.class.cast(sovellus);
        } catch (Throwable t) {
            fail("Periihän luokka HiekkarantaSovellus luokan Application.");
        }

        try {
            Reflex.reflect(HiekkarantaSovellus.class).method("start").returningVoid().taking(Stage.class).invokeOn(sovellus, stage);
        } catch (Throwable ex) {
            fail("Onhan luokalla HiekkarantaSovellus metodi start, joka saa parametrina Stage-olion. Jos on, tarkista että metodi toimii. Virhe: " + ex.getMessage());
        }

        this.stage = stage;
    }

    @Test
    @Points("12-10.1")
    public void osatKohdallaan() {
        piirtoalusta();
        napit();

        assertTrue("Kun olet tehnyt ensimmäisen osan, muistathan päivittää myös luokan HiekkarantaSovellus metodia toteutetutOsat palauttamaan arvon 1.", HiekkarantaSovellus.toteutetutOsat() >= 1);
    }

    private Canvas piirtoalusta() {
        Scene scene = stage.getScene();
        assertNotNull("Stage-oliolla pitäisi olla Scene-olio. Nyt start-metodin suorituksen jälkeen stagelle tehty kutsu getScene palautti null-viitteen.", scene);
        Parent elementtienJuuri = scene.getRoot();
        assertNotNull("Scene-oliolle tulee antaa parametrina käyttöliittymäkomponenttien asetteluun tarkoitettu olio (tässä BorderPane). Nyt Scene-oliolta ei löytynyt komponentteja sisältävää oliota.", elementtienJuuri);

        BorderPane asettelu = null;
        try {
            asettelu = BorderPane.class.cast(elementtienJuuri);
        } catch (Throwable t) {
            fail("Käytäthän käyttöliittymäkomponenttien asetteluun BorderPane-luokkaa.");
        }

        assertNotNull("Scene-oliolle tulee antaa parametrina käyttöliittymäkomponenttien asetteluun tarkoitettu BorderPane-olio.", asettelu);
        assertTrue("BorderPanen keskellä pitäisi olla Canvas-olio. Nyt siellä oli: " + asettelu.getCenter(), asettelu.getCenter().getClass().isAssignableFrom(Canvas.class));
        assertTrue("BorderPanen oikeassa laidassa pitäisi olla VBox-olio. Nyt siellä oli: " + asettelu.getRight(), asettelu.getRight().getClass().isAssignableFrom(VBox.class));

        Canvas piirtoalusta = null;
        try {
            piirtoalusta = Canvas.class.cast(asettelu.getCenter());
        } catch (Throwable t) {
            fail("Käytäthän BorderPanen keskellä Canvas-luokkaa.");
        }

        return piirtoalusta;
    }

    private List<RadioButton> napit() {
        Scene scene = stage.getScene();
        assertNotNull("Stage-oliolla pitäisi olla Scene-olio. Nyt start-metodin suorituksen jälkeen stagelle tehty kutsu getScene palautti null-viitteen.", scene);
        Parent elementtienJuuri = scene.getRoot();
        assertNotNull("Scene-oliolle tulee antaa parametrina käyttöliittymäkomponenttien asetteluun tarkoitettu olio (tässä BorderPane). Nyt Scene-oliolta ei löytynyt komponentteja sisältävää oliota.", elementtienJuuri);

        BorderPane asettelu = null;
        try {
            asettelu = BorderPane.class.cast(elementtienJuuri);
        } catch (Throwable t) {
            fail("Käytäthän käyttöliittymäkomponenttien asetteluun BorderPane-luokkaa.");
        }

        assertNotNull("Scene-oliolle tulee antaa parametrina käyttöliittymäkomponenttien asetteluun tarkoitettu BorderPane-olio.", asettelu);
        assertTrue("BorderPanen keskellä pitäisi olla Canvas-olio. Nyt siellä oli: " + asettelu.getCenter(), asettelu.getCenter().getClass().isAssignableFrom(Canvas.class));
        assertTrue("BorderPanen oikeassa laidassa pitäisi olla VBox-olio. Nyt siellä oli: " + asettelu.getRight(), asettelu.getRight().getClass().isAssignableFrom(VBox.class));

        Canvas piirtoalusta = null;
        try {
            piirtoalusta = Canvas.class.cast(asettelu.getCenter());
        } catch (Throwable t) {
            fail("Käytäthän BorderPanen keskellä Canvas-luokkaa.");
        }

        VBox vbox = null;
        try {
            vbox = VBox.class.cast(asettelu.getRight());
        } catch (Throwable t) {
            fail("Käytäthän BorderPanen oikealla laidalla VBox-luokkaa.");
        }
        assertEquals("Odotettiin, että VBoxissa on kolme vaihtoehtoa. Nyt vaihtoehtoja oli: " + vbox.getChildren().size(), 3, vbox.getChildren().size());

        List<RadioButton> napit = new ArrayList<>();

        for (Node node : vbox.getChildren()) {
            try {
                RadioButton button = RadioButton.class.cast(node);
                napit.add(button);
            } catch (Throwable t) {
                fail("Odotettiin, että jokainen VBoxin sisältämä olio on RadioButton. Nyt ei ollut. Virhe: " + t.getMessage());
            }
        }

        assertEquals("Odotettiin, että ensimmäisessä VBox-oliossa on teksti \"Metalli\". Nyt teksti oli \"" + napit.get(0).getText() + "\".", "Metalli", napit.get(0).getText());
        assertEquals("Odotettiin, että toisessa VBox-oliossa on teksti \"Hiekka\". Nyt teksti oli \"" + napit.get(1).getText() + "\".", "Hiekka", napit.get(1).getText());
        assertEquals("Odotettiin, että kolmannessa VBox-oliossa on teksti \"Vesi\". Nyt teksti oli \"" + napit.get(2).getText() + "\".", "Vesi", napit.get(2).getText());

        return napit;
    }

}
