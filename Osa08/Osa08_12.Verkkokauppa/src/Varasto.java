import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Varasto {
    private Map<String, Integer> varasto;
    private Map<String, Integer> saldo;
    
    public Varasto() {
        this.varasto = new HashMap<>();
        this.saldo = new HashMap<>();
    }
    
    public void lisaaTuote(String tuote, int hinta, int saldo) {
        this.varasto.put(tuote, hinta);
        this.saldo.put(tuote, saldo);
    }
    
    public int hinta(String tuote) {
        return this.varasto.getOrDefault(tuote, -99);
    }
    
    public int saldo(String tuote) {
        return this.saldo.getOrDefault(tuote, 0);
    }
    
    public boolean ota(String tuote) {
        if (saldo(tuote) == 0) {
            return false;
        } else {
            this.saldo.replace(tuote, saldo(tuote) - 1);
            return true;
        }
    }
    
    public Set<String> tuotteet() {
        return this.varasto.keySet();
    }
}
