package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiSovellus extends Application {

    public static void main(String[] args) {
        launch(ShanghaiSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        NumberAxis x = new NumberAxis(2006, 2017, 2);
        NumberAxis y = new NumberAxis();
        x.setLabel("Vuosi");
        y.setLabel("Sijoitus");
        
        LineChart<Number, Number> kaavio = new LineChart<>(x, y);
        kaavio.setTitle("Helsingin yliopisto, Shanghai-ranking");
        
        XYChart.Series hkiData = new XYChart.Series();
        hkiData.getData().add(new XYChart.Data(2007, 73));
        hkiData.getData().add(new XYChart.Data(2008, 68));
        hkiData.getData().add(new XYChart.Data(2009, 72));
        hkiData.getData().add(new XYChart.Data(2010, 72));
        hkiData.getData().add(new XYChart.Data(2011, 74));
        hkiData.getData().add(new XYChart.Data(2012, 73));
        hkiData.getData().add(new XYChart.Data(2013, 76));
        hkiData.getData().add(new XYChart.Data(2014, 73));
        hkiData.getData().add(new XYChart.Data(2015, 67));
        hkiData.getData().add(new XYChart.Data(2016, 56));
        
        kaavio.getData().add(hkiData);
        Scene scene = new Scene(kaavio);
        stage.setScene(scene);
        stage.show();
    }

}
