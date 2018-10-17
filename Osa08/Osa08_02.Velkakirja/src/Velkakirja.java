import java.util.HashMap;

public class Velkakirja {
private HashMap<String, Double> velkakirja;
    public Velkakirja(){
        this.velkakirja = new HashMap<>();
    }
    
    public void asetaLaina(String kenelle, double maara) {
        this.velkakirja.put(kenelle, maara);
    }
    
    public double paljonkoVelkaa(String kuka) {
        return velkakirja.getOrDefault(kuka, (double) 0);
    }
    
}
