import java.util.ArrayList;
import java.util.stream.Collectors;

public class Kirjasto {
    private ArrayList<Kirja> hylly;
    
    public Kirjasto() {
        this.hylly = new ArrayList<>();
    }
    
    public void lisaaKirja(Kirja uusiKirja) {
        this.hylly.add(uusiKirja);
    }
    
    public void tulostaKirjat() {
        this.hylly.stream().forEach(k -> System.out.println(k));
    }
    
    public ArrayList<Kirja> haeKirjaNimekkeella(String nimeke) {
        return haeKirja(nimeke, null, -1);
    }
    
    public ArrayList<Kirja> haeKirjaJulkaisijalla(String julkaisija) {
        return haeKirja(null, julkaisija, -1);
    }
    
    public ArrayList<Kirja> haeKirjaJulkaisuvuodella(int julkaisuvuosi) {
        return haeKirja(null, null, julkaisuvuosi);
    }
    
    public ArrayList<Kirja> haeKirja(String nimeke, String julkaisija, int julkaisuvuosi) {
        return this.hylly.stream()
                .filter(k -> (nimeke != null && k.nimeke().contains(nimeke))
                        || (julkaisija != null && k.julkaisija().contains(julkaisija))
                        || (julkaisuvuosi != -1 && k.julkaisuvuosi() == julkaisuvuosi))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
