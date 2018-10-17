
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameOfLifeSovellus extends Application {

    public void start(Stage stage) {
        final int leveys = 800;
        final int korkeus = 800;

        stage.setTitle("Game of Life");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas piirtoalusta = new Canvas(leveys, korkeus);
        root.getChildren().add(piirtoalusta);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        GameOfLife gol = new GameOfLife(200, 200);
        gol.alustaSatunnaisesti();

        new AnimationTimer() {
            // päivitetään animaatiota noin 200 millisekunnin välein
            private long sleepNanoseconds = 200 * 1000000;
            private long prevTime = 0;

            public void handle(long currentNanoTime) {
                // päivitetään animaatiota noin 200 millisekunnin välein
                if ((currentNanoTime - prevTime) < sleepNanoseconds) {
                    return;
                }

                // piirretään alusta
                piirturi.setFill(Color.WHITE);
                piirturi.clearRect(0, 0, leveys, korkeus);

                // piirretään peli
                piirturi.setFill(Color.BLACK);

                int[][] taulukko = gol.getTaulukko();
                int x = 0;
                while (x < taulukko.length) {

                    int y = 0;
                    while (y < taulukko[x].length) {
                        int arvo = taulukko[x][y];

                        if (arvo == 1) {
                            piirturi.fillRect(x * 4, y * 4, 4, 4);
                        }

                        y++;
                    }

                    x++;
                }

                // kutsutaan game of lifelle kehity-metodia
                gol.kehity();

                // älä muuta tätä
                prevTime = currentNanoTime;
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
