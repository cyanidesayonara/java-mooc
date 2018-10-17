
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.effect.Glow;
import javafx.scene.text.Font;

public class Breakout extends Application {

    public void start(Stage stage) {
        final int pelinLeveys = 480;
        final int pelinKorkeus = 640;

        stage.setTitle("Breakout");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
                
        Canvas piirtoalusta = new Canvas(pelinLeveys, pelinKorkeus);
        root.getChildren().add(piirtoalusta);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        // luodaan maila
        Suorakulmio maila = new Suorakulmio(0, 580, 80, 20, Color.BURLYWOOD);

        // luodaan pallo
        Pallo pallo = new Pallo(pelinLeveys / 2, pelinKorkeus / 2, 10);
        // ja pallon "liike"
        Liike liike = new Liike(2.0, 2.0);

        // luodaan rikottavat palat
        ArrayList<Suorakulmio> palat = new ArrayList<>();

        int i = 30;
        while (i < 425) {
            palat.add(new Suorakulmio((i), 15, 30, 15, Color.RED));
            i += 32;
        }
        i = 30;
        while (i < 425) {
            palat.add(new Suorakulmio((i), 32, 30, 15, Color.YELLOW));
            i += 32;
        }
        i = 30;
        while (i < 425) {
            palat.add(new Suorakulmio((i), 49, 30, 15, Color.LIME));
            i += 32;
        }
        i = 30;
        while (i < 425) {
            palat.add(new Suorakulmio((i), 66, 30, 15, Color.CYAN));
            i += 32;
        }
        i = 30;
        while (i < 425) {
            palat.add(new Suorakulmio((i), 83, 30, 15, Color.BLUE));
            i += 32;
        }
        
        // siirretään mailaa kun hiiri liikkuu
        scene.setOnMouseMoved((MouseEvent e) -> {
            maila.setX((int) e.getSceneX() - maila.getLeveys() / 2);
        });

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                piirturi.clearRect(0, 0, pelinLeveys, pelinKorkeus);
                
                if(palat.size() == 0) {
                    piirturi.setStroke(Color.RED);
                    piirturi.setEffect(new Glow(1.0));
                    piirturi.setFont(new Font("font", 24));
                    piirturi.strokeText("A WINNER IS YOU", 150, 300);
                    liike.setLiikeX(0);
                    liike.setLiikeY(0);
                    piirturi.setEffect(null);
                }
                                
                // piirretään maila
                piirturi.setFill(maila.getVari());
                piirturi.fillRect(maila.getX(), maila.getY(), maila.getLeveys(), maila.getKorkeus());

                // piirretään pallo
                piirturi.setFill(Color.CORNFLOWERBLUE);
                piirturi.fillOval(pallo.getX(), pallo.getY(), pallo.getSade() * 2, pallo.getSade() * 2);

                int x = (int) Math.round(pallo.getX());
                int y = (int) Math.round(pallo.getY());
                
                // piirretään rikottavat palat
                int palaIndeksi = 0;
                while (palaIndeksi < palat.size()) {
                    Suorakulmio pala = palat.get(palaIndeksi);
                    piirturi.setFill(pala.getVari());
                    piirturi.fillRect(pala.getX(), pala.getY(), pala.getLeveys(), pala.getKorkeus());
                    if (!pala.ulkopuolella(x, y)) {
                        liike.setLiikeY(-1 * liike.getLiikeY());
                        palat.remove(palaIndeksi);
                        //if ()
                    }
                    palaIndeksi++;
                }
                
                
                // liikutetaan palloa
                pallo.liikuta(liike);

                System.out.println("x on " + liike.getLiikeX());
                System.out.println("y on " + liike.getLiikeY());
                
                // tarkista osuuko pallo mailaan
                //if (!maila.ulkopuolella(x, y + 18)) {
                if (pallo.getY() == maila.getY() - 18 &&
                    pallo.getX() - maila.getX() < 75 &&
                    pallo.getX() - maila.getX() >= 0) {
                    liike.setLiikeY(-1 * liike.getLiikeY());
                } 
                if (pallo.getY() == maila.getY() - 18 &&
                    pallo.getX() - maila.getX() >= 75 &&
                    pallo.getX() - maila.getX() < 100 &&
                    liike.getLiikeX() < 0) {
                        liike.setLiikeY(-1 * liike.getLiikeY());
                        liike.setLiikeX(-1 * liike.getLiikeX());
                }
                if (pallo.getY() == maila.getY() - 18 &&
                    pallo.getX() - maila.getX() < 0 &&
                    pallo.getX() - maila.getX() >= -25 &&
                    liike.getLiikeX() > 0) {
                        liike.setLiikeY(-1 * liike.getLiikeY());
                        liike.setLiikeX(-1 * liike.getLiikeX());
                }
                
                // tarkistetaan osuuko pallo johonkin reunoista
                if (pallo.getY() < 0) {
                    liike.setLiikeY(-1 * liike.getLiikeY());
                }

                if (pallo.getX() < 0) {
                    liike.setLiikeX(-1 * liike.getLiikeX());
                }
                
                if (pallo.getX() + pallo.getSade() * 2 > pelinLeveys) {
                    liike.setLiikeX(-1 * liike.getLiikeX());
                }

                // jos pallo osuu alalaitaan, lopetetaan peli
                if (pallo.getY() > pelinKorkeus) {
                    ((Stage) root.getScene().getWindow()).close();
                }
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
