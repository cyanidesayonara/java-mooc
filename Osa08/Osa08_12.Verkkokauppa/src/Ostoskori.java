import java.util.Map;
import java.util.HashMap;

public class Ostoskori {
    private Map<String, Ostos> kori;
    
    public Ostoskori() {
        this.kori = new HashMap<>();
    }
    
    public void lisaa(String tuote, int hinta) {
        
        // mallisuoritus:
        // kori.putIfAbsent(tuote, new Ostos(tuote, 0, hinta));
        // this.ostokset.get(tuote).kasvataMaaraa();
        
        if (kori.containsKey(tuote)) {
            kori.get(tuote).kasvataMaaraa();
        } else {
            kori.put(tuote, new Ostos(tuote, 1, hinta));
        }
    }
    
    public int hinta() {
        return kori.values().stream()
                .mapToInt(o -> o.hinta())
                .sum();  
    }
    
    public void tulosta() {
        kori.values().stream()
                .forEach(o -> System.out.println(o));
    }
}
