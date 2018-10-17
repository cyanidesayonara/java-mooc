import java.util.ArrayList;

public class Pakkaus {
    private ArrayList<Lahja> lista;
    
    public Pakkaus() {
        this.lista = new ArrayList<>();
    }
    
    public void lisaaLahja(Lahja lahja) {
        lista.add(lahja);
    }
    
    public int getPaino() {
        return lista.stream()
                .mapToInt(p -> p.getPaino()).sum();
    }
}
