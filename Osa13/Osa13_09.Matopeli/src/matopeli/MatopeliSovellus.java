package matopeli;

import java.util.Iterator;
import java.util.List;
import matopeli.domain.Suunta;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import matopeli.domain.HallOfFame;
import matopeli.domain.Matopeli;
import matopeli.domain.Omena;

public class MatopeliSovellus extends Application {
    private double nopeuskerroin = 1;
    
    @Override
    public void start(Stage ikkuna) throws Exception {
        int ruudunkoko = 20;
        int ruutuja = 30;

        Canvas piirtoalusta = new Canvas(ruutuja * ruudunkoko, ruutuja * ruudunkoko);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        Matopeli matopeli = new Matopeli(ruutuja, ruutuja);
        
        // pelin piirtäminen tapahtuu 30 kertaa sekunnissa
        new AnimationTimer() {
            private long edellinen;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 1_000_000_000 / 30) {
                    return;
                }
                edellinen = nykyhetki;

                piirturi.setFill(Color.BLACK);
                piirturi.fillRect(0, 0, ruutuja * ruudunkoko, ruutuja * ruudunkoko);

                piirturi.setFill(Color.WHITE);

                if (matopeli.loppu()) {
                    piirturi.setFill(Color.LIGHTGRAY);
                }

                matopeli.getMato().getPalat().stream().forEach(pala -> {
                    piirturi.fillRect(pala.getX() * ruudunkoko, pala.getY() * ruudunkoko, ruudunkoko, ruudunkoko);
                });

                piirturi.setFill(Color.RED);
                Omena omena = matopeli.getOmena();
                piirturi.fillRect(omena.getX() * ruudunkoko, omena.getY() * ruudunkoko, ruudunkoko, ruudunkoko);

            }
        }.start();
        
        // scoreboard
        BorderPane asettelu = new BorderPane();
        HBox scoreboard = new HBox();
        Text score = new Text();
        score.setFont(new Font(20));
        scoreboard.getChildren().add(score);
        scoreboard.setAlignment(Pos.CENTER);
        asettelu.setTop(scoreboard);
        
        asettelu.setCenter(piirtoalusta);
                            
        // hienompi taustaväri
        asettelu.setStyle("-fx-background-color: linear-gradient(#299,#111);");

        Scene nakyma = new Scene(asettelu);

        // pelin päivittäminen (madon liikkuminen ym) tapahtuu 5 kertaa sekunnissa
        new AnimationTimer() {
            private long edellinen;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 1_000_000_000 / (5 * nopeuskerroin)) {
                    return;
                }
                edellinen = nykyhetki;
                
                // scoreboard päivittyy
                score.setText("Score: " + matopeli.getPojot());

                matopeli.paivita();
                
                // omenan syöminen kasvattaa nopeuskerrointa
                if (matopeli.kasvoiko()) {
                    nopeuskerroin += 0.1;
                }

                if (matopeli.loppu()) {
                    stop();
                    
                    int pojot = matopeli.getPojot();

                    // nimenantonäyttö
                    GridPane gridpane = new GridPane();
                    gridpane.setAlignment(Pos.CENTER);
                    gridpane.setHgap(10);
                    gridpane.setVgap(10);
                            
                    // onnitteluteksti yläreunaan
                    Text congrats = new Text("Congratulations, your score is " + pojot + "!");
                    congrats.setFont(new Font(24));
                    HBox hbox = new HBox();
                    hbox.getChildren().add(congrats);
                    hbox.setAlignment(Pos.CENTER);
                    hbox.setPadding(new Insets(100));
                    asettelu.setTop(hbox);
                    
                    // tekstikenttä ja nappi
                    TextField textfield = new TextField();
                    Button button = new Button("Enter name");
                    gridpane.add(textfield, 0, 1);
                    gridpane.add(button, 0, 2);
                    
                    // vaihda näyttö
                    asettelu.setCenter(gridpane);
                    
                    // poista muistutus tyhjästä nimestä
                    textfield.setOnKeyPressed((event) -> textfield.setPromptText(""));

                    // nappia painamalla tulos tallettuu ja näyttö vaihtuu
                    button.setOnAction((event) -> {
                        // jos tyhjä nimi, muistuta
                        if (textfield.getText().isEmpty()) {
                            textfield.setPromptText("Name can't be empty");
                        } else {
                            // tallentaa tuloksen ja palauttaa sen muodossa 
                            // "rank,name,score"
                            String hofTulos = HallOfFame.lisaaTulos(textfield.getText(), pojot);

                            // vaihda hall of fame -näyttöön
                            asettelu.setCenter(HOF(hofTulos));

                            // teksti näytön ylälaitaan
                            Text text = new Text("HALL OF FAME");
                            text.setFont(new Font(32));
                            hbox.getChildren().clear();
                            hbox.getChildren().add(text);
                            hbox.setAlignment(Pos.CENTER);
                            hbox.setPadding(new Insets(50));
                            asettelu.setTop(hbox);
                        }
                    });   
                }
            }
        }.start();

        // tapahtuman käsittely (näppäimistön kuuntelu)
        nakyma.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.UP)) {
                matopeli.getMato().setSuunta(Suunta.YLOS);
            } else if (event.getCode().equals(KeyCode.DOWN)) {
                matopeli.getMato().setSuunta(Suunta.ALAS);
            } else if (event.getCode().equals(KeyCode.RIGHT)) {
                matopeli.getMato().setSuunta(Suunta.OIKEA);
            } else if (event.getCode().equals(KeyCode.LEFT)) {
                matopeli.getMato().setSuunta(Suunta.VASEN);
            }
        });

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(MatopeliSovellus.class);
    }
    
    public GridPane HOF(String hofTulos) {
        // hall of fame -ruudukko
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(100);
        gridpane.setVgap(10);
        
        // eka rivi, otsikot
        Label rankHeader = new Label("RANK");
        rankHeader.setTextFill(Color.WHITE);
        gridpane.add(rankHeader, 0, 0);
        Label nameHeader = new Label("NAME");
        nameHeader.setTextFill(Color.WHITE);
        gridpane.add(nameHeader, 1, 0);
        Label scoreHeader = new Label("SCORE");
        scoreHeader.setTextFill(Color.WHITE);
        gridpane.add(scoreHeader, 2, 0);
        
        // tulokset listana
        List<String> tulokset = HallOfFame.getTulokset();

        // jos edellinen tulos pääsi top10, se väritettään
        String[] varitettava = hofTulos.split(",");
        
        //iteridaan tulokset, lisätään ruudukkoon
        Iterator iter = tulokset.iterator();
        
        int i = 1;
        while (iter.hasNext()) {
            String[] x = iter.next().toString().split(",");
 
            // normiväri: valkoinen
            Label rank = new Label(i + ".");
            rank.setTextFill(Color.WHITE);
            Label name = new Label(x[0]);
            name.setTextFill(Color.WHITE);
            Label score = new Label(x[1]);
            score.setTextFill(Color.WHITE);
            
            // oma tulos: oranssi
            if (Integer.parseInt(varitettava[0]) == i &&
                varitettava[1].equals(x[0]) &&
                varitettava[2].equals(x[1])) {

                rank.setTextFill(Color.ORANGE);
                name.setTextFill(Color.ORANGE);
                score.setTextFill(Color.ORANGE);
            }
            
            gridpane.add(rank, 0, i);
            gridpane.add(name, 1, i);
            gridpane.add(score, 2, i);
            i++;
        }
        
        return gridpane;
    }

}
