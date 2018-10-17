/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Santtu
 */
public class Syotto {
    private Sanakirja sanakirja;
    
    public Syotto(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
    }
    
    public Parent getNakyma() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10, 10, 10, 10));
        
        Label sanaOhje = new Label("Sana");
        TextField sana = new TextField();
        Label kaannosOhje = new Label("Käännös");
        TextField kaannos = new TextField();
        Button b = new Button("Lisää sanapari");
        
        gp.add(sanaOhje, 0, 0);
        gp.add(sana, 0, 1);
        gp.add(kaannosOhje, 0, 2);
        gp.add(kaannos, 0, 3);        
        gp.add(b, 0, 4);
        
        sana.setOnKeyPressed((event) -> {
            sana.setPromptText("");
        });
        
        kaannos.setOnKeyPressed((event) -> {
            kaannos.setPromptText("");
        });
        
        b.setOnAction((event) -> {
            String s = sana.getText();
            String k = kaannos.getText();
            if (s.isEmpty() || k.isEmpty()) {
                if (s.isEmpty()) {
                    sana.setPromptText("Kenttä ei voi olla tyhjä");
                }
                if (k.isEmpty()) {
                    kaannos.setPromptText("Kenttä ei voi olla tyhjä");
                }
            } else {
                sanakirja.lisaa(s, k);
            }
            sana.clear();
            kaannos.clear();
        });
        
        return gp;
    }
}
