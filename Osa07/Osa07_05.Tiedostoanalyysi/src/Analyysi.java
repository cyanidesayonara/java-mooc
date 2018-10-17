import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Analyysi {
    private String tiedosto;
    private ArrayList<String> lista;
    private int rivimaara;
    
    public Analyysi(String tiedosto) {
        this.tiedosto = tiedosto;
        this.lista = new ArrayList<>();
        makeList();
    }
    
    public void makeList() {
        try {
            Files.lines(Paths.get(tiedosto))
                    .forEach(line -> lista.add(line + "\n"));
        } catch (Exception ex) {
            System.out.println("Tiedostoa ei ole olemassa: " + ex.getMessage());
        }
    }
    
    public int rivimaara() {
        return lista.size();
    }
    
    public int merkkeja() {
        return lista.stream().mapToInt(l -> l.length()).sum();
    }
}
