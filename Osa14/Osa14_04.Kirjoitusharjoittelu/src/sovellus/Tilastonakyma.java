package sovellus;

import java.util.Map;
import javafx.scene.Parent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Tilastonakyma {
    
    private Kirjoitusnopeudet kirjoitusnopeudet;
    private XYChart.Series kaavioData;
    
    public Tilastonakyma(Kirjoitusnopeudet kirjoitusnopeudet) {
        this.kirjoitusnopeudet = kirjoitusnopeudet;
    }
    
    public Parent getNakyma() {
        CategoryAxis xAkseli = new CategoryAxis();
        xAkseli.setLabel("Kirjoitettu sana");
        NumberAxis yAkseli = new NumberAxis();
        yAkseli.setLabel("Yksittäisen merkin kirjoitusnopeus (millisekuntia)");
        
        LineChart<String, Number> kaavio = new LineChart<>(xAkseli, yAkseli);
        kaavio.setAnimated(false);
        kaavio.setLegendVisible(false);
        
        this.kaavioData = new XYChart.Series();
        kaavio.getData().add(kaavioData);
        
        return kaavio;
    }
    
    public void paivita() {
        this.kaavioData.getData().clear();
        Map<String, Double> nopeudet = kirjoitusnopeudet.keskiarvot();
        nopeudet.entrySet().stream().forEach(entry -> {
            this.kaavioData.getData().add(new XYChart.Data(entry.getKey(), entry.getValue() / entry.getKey().length()));
        });
    }
}
