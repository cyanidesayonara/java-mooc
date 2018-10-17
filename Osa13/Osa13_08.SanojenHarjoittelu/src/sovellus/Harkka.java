/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Santtu
 */
public class Harkka {
    private Sanakirja sanakirja;
    
    public Harkka(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
    }
    
    public Parent getNakyma() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10, 10, 10, 10));
        
        Label ohje = new Label(kaannettavaSana());
        TextField sana = new TextField();
        Button b = new Button("Tarkista");
        Label info = new Label();
        info.setMaxWidth(150);
        info.setWrapText(true);
        
        gp.add(ohje, 0, 0);
        gp.add(sana, 0, 1);
        gp.add(b, 0, 2);
        gp.add(info, 0, 3);
        
        b.setOnAction((event) -> {
            String s = sana.getText();
            String k = ohje.getText().substring(13, ohje.getText().length() - 2);
            if (sanakirja.haeKaannos(k).equals(s)) {
                info.setText("Oikein!");
            } else {
                info.setText("Väärin! Sanan '" + k + "' käännös on '" +
                                            sanakirja.haeKaannos(k) + "'.");
            }
            sana.clear();
            ohje.setText(kaannettavaSana());
        });
        
        return gp;
    }
    
    public String kaannettavaSana() {
        return "Käännä sana '" + sanakirja.randomSana() + "'.";
    }
}
