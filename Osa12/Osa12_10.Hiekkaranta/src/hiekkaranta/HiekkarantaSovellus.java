package hiekkaranta;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class HiekkarantaSovellus extends Application {
    private Simulaatio sim;
    private Random random;

    public static void main(String[] args) {
        launch(HiekkarantaSovellus.class);
    }
    
    @Override
    public void start(Stage stage) {
        random = new Random();
        sim = new Simulaatio(200, 200);
        
        Canvas canvas = new Canvas(200, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 200, 200);
        
        RadioButton rb1 = new RadioButton("Metalli");
        RadioButton rb2 = new RadioButton("Hiekka");
        RadioButton rb3 = new RadioButton("Vesi");
        
        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        
        canvas.setOnMouseDragged((event) -> {
            int x = (int) event.getSceneX();
            int y = (int) event.getSceneY();

            if (rb1.isSelected()) {
                lisaaAine(x, y, 3, Tyyppi.METALLI);
            }
            if (rb2.isSelected()) {
                lisaaAine(x, y, 2, Tyyppi.HIEKKA);
            }
            if (rb3.isSelected()) {
                lisaaAine(x, y, 2, Tyyppi.VESI);
            }
        });
        
        new AnimationTimer() {
            long edellinen = 0;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 50000000) {
                    return;
                }
                
                piirra(gc);
                sim.paivita();
                this.edellinen = nykyhetki;
            }
        }.start();
        
        BorderPane bp = new BorderPane();
        VBox vbox = new VBox();
        
        bp.setCenter(canvas);        
        vbox.getChildren().addAll(rb1, rb2, rb3);
        bp.setRight(vbox);

        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }
    
    public void lisaaAine(int x, int y, int paksuus, Tyyppi tyyppi) {
        for (int i = -paksuus; i <= paksuus; i++) {
            for (int j = -paksuus; j <= paksuus; j++) {
                if (y + i >= 0 && y + i < 200 &&
                    y + j >= 0 && y + j < 200) {
                    if (random.nextBoolean() == true) {
                        sim.lisaa(x + i, y + j, tyyppi);
                    }
                }
            }
        }
    }
    
    public void piirra(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 200, 200);
        
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                Tyyppi tyyppi = sim.sisalto(i, j);
                if (tyyppi.equals(Tyyppi.METALLI)) {
                    gc.setFill(Color.WHITE);
                    gc.fillOval(i, j, 1, 1);
                }
                if (tyyppi.equals(Tyyppi.HIEKKA)) {
                    gc.setFill(Color.ORANGE);
                    gc.fillOval(i, j, 1, 1);
                }
                if (tyyppi.equals(Tyyppi.VESI)) {
                    gc.setFill(Color.PALETURQUOISE);
                    gc.fillOval(i, j, 1, 1);
                }
            }
        }
    }

    public static int toteutetutOsat() {
        // muokkaa täällä olevaa arvoa siten, että se kertoo 
        // tekemiesi osan määrän
        return 5;
    }
}
