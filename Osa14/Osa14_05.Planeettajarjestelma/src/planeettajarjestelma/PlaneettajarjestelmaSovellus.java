package planeettajarjestelma;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlaneettajarjestelmaSovellus extends Application {
    private Planeettajarjestelma pj;
    
    @Override
    public void start(Stage ikkuna) {
        int leveys = 300;
        int korkeus = 300;
        double halkaisija = 5.0E11;
        
        pj = asetaPlaneetat(halkaisija);
        
        Canvas canvas = new Canvas(leveys, korkeus);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Label label = new Label("Auringon massa:");
        label.setPadding(new Insets(0, 0, 0, 10));
        
        ComboBox cb = new ComboBox();
        cb.getItems().addAll(1E29, 1.989E30, 5E30, 1E31, 1E32);
        cb.setValue(1.989E30);
        cb.setOnAction((event) -> {
            pj.getPlaneetat().stream().filter(p -> p.getMassa() > 1E28)
                    .forEach(p -> p.setMassa((double) cb.getValue()));
        });
                 
        Button button = new Button("Reset");
        
        button.setOnAction((event) -> {
            pj = asetaPlaneetat(halkaisija);
            pj.getPlaneetat().stream().filter(p -> p.getMassa() > 1E28)
                    .forEach(p -> p.setMassa((double) cb.getValue()));
        });
        
        HBox hb = new HBox();
        hb.setSpacing(20);
        hb.getChildren().addAll(label, cb, button);

        BorderPane bp = new BorderPane();
        bp.setCenter(canvas);
        bp.setTop(hb);
        
        new AnimationTimer() {
            long edellinen = 0;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 1_000_000_000 / 30) {
                    return;
                }
                pj.paivita(100000);
                this.edellinen = nykyhetki;
            }
        }.start();
        
        new AnimationTimer() {
            long edellinen = 0;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 1_000_000_000 / 60) {
                    return;
                }
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, leveys, korkeus);

                List<Planeetta> planeetat = pj.getPlaneetat();
                
                planeetat.forEach(p -> {
                    gc.setFill(p.getVari());
                    if (p.getMassa() > 1E28) {
                        gc.fillOval(leveys / 2 + leveys * p.getSijaintiX() / halkaisija - 10, korkeus / 2 + korkeus * p.getSijaintiY() / halkaisija - 10, 20, 20);
                        return;
                    }
                    gc.fillOval(leveys / 2 + leveys * p.getSijaintiX() / halkaisija, korkeus / 2 + korkeus * p.getSijaintiY() / halkaisija, 10, 10);
                });
                this.edellinen = nykyhetki;
            }
        }.start();
        
        Scene scene = new Scene(bp);
        ikkuna.setScene(scene);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(PlaneettajarjestelmaSovellus.class);
    }
    
    public Planeettajarjestelma asetaPlaneetat(double halkaisija) {     
        List<Planeetta> planeetat = new ArrayList();
        planeetat.add(new Planeetta(538771.2647179796, 311728.01914265234, 0.15944610708562912, 0.15099663888466472, 1.989E30, Color.YELLOW));
        planeetat.add(new Planeetta(-2.3423738558153862E10, -5.363391883276512E10, 43168.9924212314, -19555.612648233368, 3.302E23, Color.GRAY));
        planeetat.add(new Planeetta(-1.2257733349672739E10, 1.0688994731967513E11, -34980.88986158969, -3903.1360711941647, 4.869E24, Color.SIENNA));
        planeetat.add(new Planeetta(7.649815710400691E10, 1.2825871174194992E11, -25608.972746907584, 15340.707015973465, 5.974E24, Color.BLUE));
        planeetat.add(new Planeetta(1.9433739848583844E11, 1.1855926503806793E11, -12591.918312354934, 20580.315270396313, 6.419E23, Color.RED));
        return new Planeettajarjestelma(planeetat, halkaisija);
    }

}
