import java.util.ArrayList;
import java.util.stream.Collectors;

public class Lintukirja {
    private ArrayList<Lintu> linnut;
    
    public Lintukirja() {
        this.linnut = new ArrayList<>();
    }
    
    public void lisaaLintu(Lintu uusiLintu) {
        linnut.add(uusiLintu);
    }
    
    public ArrayList<Lintu> haeLintu(String nimi) {
        return linnut.stream()
                .filter(l -> l.getNimi().contains(nimi))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Lintu> naytaLinnut() {
        return linnut.stream()
                .sorted((l1, l2) -> l1.getNimi().compareTo(l2.getNimi()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
