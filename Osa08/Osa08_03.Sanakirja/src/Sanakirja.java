import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Sanakirja {
    private HashMap<String, String> sanakirja;


    public Sanakirja() {
        this.sanakirja = new HashMap<>(); 
    }
    
    public String kaanna(String sana) {
        return sanakirja.getOrDefault(sana, null);
    }
    
    public void lisaa(String sana, String kaannos) {
        sanakirja.put(sana, kaannos);
    }
    
    public int sanojenLukumaara() {
        return sanakirja.size();
    }
    
    public ArrayList<String> kaannoksetListana() {
        return sanakirja.entrySet().stream()
                .map(s -> s.getKey() + " = " + s.getValue())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
