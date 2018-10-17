package sovellus;

import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Kyselynakyma {

    private Sanasto sanasto;
    private TextField syotekentta;
    private Label syotettavaSana;

    public Kyselynakyma(Sanasto sanasto) {
        this.sanasto = sanasto;
        this.syotekentta = new TextField();
        this.syotekentta.setFont(new Font(32));
        this.syotekentta.setOpacity(0.7);
        this.syotekentta.setMaxWidth(250);
    }

    public Parent getNakyma() {
        GridPane asettelu = new GridPane();
        
        List<Label> lista = varitaSana(sanasto.annaSanat());
        this.syotettavaSana = lista.get(0);

        syotekentta.clear();

        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(0);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        
        Collections.reverse(lista);
        for (int i = 0; i < lista.size(); i++) {
            asettelu.add(lista.get(i), 0, i);
        }
        asettelu.add(syotekentta, 0, lista.size() - 1);
        return asettelu;
    }

    public Label syotettavaSana() {
        return this.syotettavaSana;
    }

    public TextField getSyoteKentta() {
        return this.syotekentta;
    }
    
    public void varitaSyoteKentta() {
        String syote = syotekentta.getText();
        String syotettava = syotettavaSana.getText();
        int lyhempi = 
                syote.length() < syotettava.length() ?
                syote.length() : syotettava.length();
        for (int i = 0; i < lyhempi; i++) {
            if (syote.charAt(i) != syotettava.charAt(i)) {
                this.syotekentta.setStyle("-fx-background-color: red;");
                return;
            }
        }
        this.syotekentta.setStyle("");
    }
    
    public List<Label> varitaSana(Queue<String> sanat) {
        List<Label> lista = new ArrayList();
        int x = sanat.size();
        Label label = new Label(sanat.poll());
        label.setStyle("-fx-text-fill: red;");
        label.setFont(new Font(32));
        label.setPadding(new Insets(0, 0, 0, 19));
        lista.add(label);
        
        for (int i = 1; i < x; i++) {
            label = new Label(sanat.poll());
            label.setOpacity((double) 1 - (i * (0.1)));

            BoxBlur bb = new BoxBlur();
            bb.setWidth(2 + i * 0.2);
            bb.setHeight(2 + i * 0.2);
            bb.setIterations(i);
            label.setEffect(bb);
            label.setStyle("-fx-text-fill: red;");
            label.setFont(new Font(28 - i));
            label.setPadding(new Insets(0, 0, 0, 19));
            lista.add(label);
        }
        return lista;
    }
}
