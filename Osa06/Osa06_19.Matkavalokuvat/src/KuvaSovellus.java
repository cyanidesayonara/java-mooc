
import java.util.ArrayList;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class KuvaSovellus extends Application {

    private ArrayList<String> tiedostot;

    public KuvaSovellus() {
        super();
        this.tiedostot = new ArrayList<>();

        // Tiedostot löytyvät tehtäväpohjasta alla listatuilla nimillä.
        tiedostot.add("G0010099.png");
        tiedostot.add("G0010108.png");
        tiedostot.add("G0010109.png");
        tiedostot.add("G0010110.png");
        tiedostot.add("G0010111.png");
        tiedostot.add("G0010132.png");
        tiedostot.add("G0010159.png");
        tiedostot.add("G0010161.png");
        tiedostot.add("G0010163.png");
    }

    @Override
    public void start(Stage stage) {
        ArrayList<Image> kuvat = tiedostot.stream()
                .map(tiedosto -> new Image("file:" + tiedosto))
                .collect(Collectors.toCollection(ArrayList::new));

        stage.setTitle("Matka");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas piirtoalusta = new Canvas(495, 557);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        root.getChildren().add(piirtoalusta);

        scene.setOnKeyTyped((keyEvent) -> {

            for (int i = 0; i < kuvat.size(); i++) {
                if (keyEvent.getCharacter().equals("" + i)) {
                    piirturi.drawImage(kuvat.get(i), 0, 0);
                }
            }

            if (keyEvent.getCharacter().equals("v")) {
                piirturi.drawImage(new Yhdistin().vaalein(kuvat), 0, 0);
            }
            if (keyEvent.getCharacter().equals("t")) {
                piirturi.drawImage(new Yhdistin().tummin(kuvat), 0, 0);
            }
            if (keyEvent.getCharacter().equals("m")) {
                piirturi.drawImage(new Yhdistin().mediaani(kuvat), 0, 0);
            }

        });

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
