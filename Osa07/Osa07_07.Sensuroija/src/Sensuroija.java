import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Sensuroija {
    private String sana;
    private ArrayList<String> teksti = new ArrayList<>();
    
    public Sensuroija(String sana) {
        this.sana = sana;
    }
    
    public void sensuroi(String lahdetiedosto, String kohdetiedosto) {
        lataaTeksti(lahdetiedosto);
        teksti = poistaSanat();
        
        kirjoitaTiedosto(kohdetiedosto);
        System.out.println(sana);
    }
    
    public void lataaTeksti(String lahdetiedosto) {
        try {
            Files.lines(Paths.get(lahdetiedosto))
                    .forEach(rivi -> teksti.add(rivi));
        } catch (Exception e) {
            System.out.println("Tiedostoa " + e.getMessage() + " ei ole olemassa");
        }
    }
    
    public ArrayList<String> poistaSanat() {
        return teksti.stream()
                .filter(s -> !s.contains(sana))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public void kirjoitaTiedosto(String kohdetiedosto) {
        try {
            Files.write(Paths.get(kohdetiedosto), teksti);
        } catch (Exception x) {
            System.out.println(x);
        }
    }
}
