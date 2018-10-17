import java.util.ArrayList;

public class Lastiruuma {
    private int maksimipaino;
    private ArrayList<Matkalaukku> ruuma;
    
    public Lastiruuma(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.ruuma = new ArrayList<>();
    }
    
    public void lisaaMatkalaukku(Matkalaukku laukku) {
        if (ruumanPaino() + laukku.yhteispaino() <= maksimipaino) {
            ruuma.add(laukku);
        }
    }
    
    public int ruumanPaino() {
        return ruuma.stream()
                .mapToInt(l -> l.yhteispaino())
                .sum();
    }
    
    @Override
    public String toString() {
        if (ruuma.isEmpty()) {
            return "ei matkalaukkuja (0 kg)";
        }
        if (ruuma.size() == 1) {
            return "1 matkalaukku (" + ruumanPaino() + " kg)";
        }
        return ruuma.size() + " matkalaukkua (" + ruumanPaino() + " kg)";
    }
    
    public void tulostaTavarat() {
        ruuma.stream()
                .forEach(t -> t.tulostaTavarat());
        
    }
}
