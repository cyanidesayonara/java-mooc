package sovellus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PuolueetSovellus extends Application {

    public static void main(String[] args) {
        launch(PuolueetSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        Map<String, Map<Integer, Double>> kannatusData = new HashMap();
        List<String[]> list = new ArrayList();
        try {
            Files.lines(Paths.get("puoluedata.tsv")).forEach(line -> {
                list.add(line.split("\t"));
            });
        } catch (IOException e ) {
            System.out.println("Ei onnaa");
        }
        
        for (int i = 1; i < list.size(); i++) {
            Map<Integer, Double> mappi = new HashMap();
            for (int j = 1; j < list.get(i).length; j++) {
                if (!list.get(i)[j].equals("-")) {
                    int vuosi = Integer.parseInt(list.get(0)[j]);
                    double kannatus = Double.parseDouble(list.get(i)[j]);
                    mappi.put(vuosi, kannatus);
                }
            }
            kannatusData.put(list.get(i)[0], mappi);
        }
        
        int alku = Integer.parseInt(list.get(0)[1]);
        int loppu = Integer.parseInt(list.get(0)[list.get(0).length - 1]);
        int vali = (loppu - alku) / list.get(0).length - 2;
        
        NumberAxis x = new NumberAxis(alku, loppu, vali);
        NumberAxis y = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> kaavio = new LineChart<>(x, y);
        kaavio.setTitle("Puolueiden suhteellinen kannatus");
        
        kannatusData.keySet().stream().forEach(puolue -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(puolue);
            kannatusData.get(puolue).entrySet().stream().forEach(pari -> {
                data.getData().add(new XYChart.Data(pari.getKey(),
                                                    pari.getValue()));
            });
            kaavio.getData().add(data);
        });
        
        Scene scene = new Scene(kaavio);
        stage.setScene(scene);
        stage.show();
    }
}
