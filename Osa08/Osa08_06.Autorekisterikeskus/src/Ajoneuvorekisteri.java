import java.util.HashMap;

public class Ajoneuvorekisteri {
    private HashMap<Rekisterinumero, String> rekisteri;
    
    public Ajoneuvorekisteri() {
        this.rekisteri = new HashMap<>();
    }
    
    public boolean lisaa(Rekisterinumero rekkari, String omistaja) {
        
        if (this.rekisteri.containsKey(rekkari)) {
            if (this.rekisteri.get(rekkari).isEmpty()) {
                this.rekisteri.put(rekkari, omistaja);
                return true;
            } else {
                return false;
            }
        } else {
            this.rekisteri.put(rekkari, omistaja);
            return true;
        }
    }
    
    public String hae(Rekisterinumero rekkari) {
        if (!this.rekisteri.containsKey(rekkari)) {
            return null;
        }
        return this.rekisteri.get(rekkari);
    }
    
    public boolean poista(Rekisterinumero rekkari) {
        if (!this.rekisteri.containsKey(rekkari)) {
            return false;
        } else {
            this.rekisteri.remove(rekkari);
            return true;
        }
    }
    
    public void tulostaRekisterinumerot() {
        this.rekisteri.keySet().stream()
                .forEach(r -> System.out.println(r));
    }
    
    public void tulostaOmistajat() {
        this.rekisteri.values().stream()
                .distinct()
                .forEach(o -> System.out.println(o));
    }
}
