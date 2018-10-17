import java.util.ArrayList;
import java.util.stream.Collectors;

public class Matkalaukku {
    final private ArrayList<Tavara> laukku;
    final private int maksimipaino;
    
    public Matkalaukku(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.laukku = new ArrayList<>();
    }
    
    public void lisaaTavara(Tavara tavara) {
        int yhteispaino = tavara.getPaino() + yhteispaino();
        if (yhteispaino <= maksimipaino) {
            laukku.add(tavara);
        }
    }
    
    @Override
    public String toString() {
        String tavarat = "ei";
        
        if (!laukku.isEmpty()) {
            tavarat = "" + laukku.size();
        }
        
        String tvr = "tavaraa";
        
        if (laukku.isEmpty()) {
            tvr = "tavaroita";
        }
        if (laukku.size() == 1) {
            tvr = "tavara";
        }
        
        return tavarat + " " + tvr + " (" + yhteispaino() + " kg)";
    }
    
    public int yhteispaino() {
        if (!laukku.isEmpty()) {
            return laukku.stream()
                    .mapToInt(l -> l.getPaino()).sum();
        } else {
            return 0;
        }
    }
    
    public void tulostaTavarat() {
        laukku.stream()
                .forEach(t -> System.out.println(t));
    }
    
    public Tavara raskainTavara() {                
        ArrayList<Tavara> raskain;
        raskain = laukku.stream()
                .sorted((t1, t2) -> {
                    return t2.getPaino() - t1.getPaino();
                })
                .collect(Collectors.toCollection(ArrayList::new));
        if (!raskain.isEmpty()) {
            return raskain.get(0);
        } else {
            return null;
        }
    }
}
