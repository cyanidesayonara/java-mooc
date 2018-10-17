package ristinolla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RistinollaSovellus extends Application {
    private String vuoro = "X";
    private int koko = 3;
    private String[][] grid = new String[koko][koko];
    private boolean tv = false;
    private int siirrot = 0;
    
    @Override
    public void start(Stage stage) {    
        Label label = new Label("Vuoro: " + vuoro);
        Font font = Font.font("Monospaced", 40.0);
        label.setFont(font);
        GridPane gp = new GridPane();

        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                grid[i][j] = "" + i + j;
                Button b = new Button(" ");
                b.setFont(font);
                int x = i;
                int y = j;
                b.setOnAction((event) -> {
                    if (b.getText() == " " &&
                        tv != true) {
                        b.setText(vuoro);
                        kirjaaSiirto(x, y);
                        tv = tulikoVoitto();
                        if (tv) {
                            label.setText("Loppu!");
                        } else {
                            vaihdaVuoroa();
                            label.setText("Vuoro: " + vuoro);
                        }
                    }
                });      
                gp.add(b, i, j);
            }
        }
        
        BorderPane bp = new BorderPane();
        bp.setTop(label);
        bp.setCenter(gp);

        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }
    
    public boolean tulikoVoitto() {
        if ((grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) ||
            (grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) ||
            (siirrot == koko * koko)) {
            return true;
        }
        for (int i = 0; i < koko; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
                return true;
            }
            for (int j = 0; j < koko; j++) {
                if (grid[0][j] == grid[1][j] && grid[0][j] == grid[2][j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void vaihdaVuoroa() {
        vuoro = (vuoro == "X") ? "O" : "X";
    }
    
    public void kirjaaSiirto(int x, int y) {
        grid[x][y] = vuoro;
        siirrot++;
    }

    public static void main(String[] args) {
        launch(RistinollaSovellus.class);    
    }
}
