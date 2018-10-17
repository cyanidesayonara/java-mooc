import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Sanatutkimus {
    private ArrayList<String> lista;

    public Sanatutkimus(String tiedosto) {
        this.lista = new ArrayList<>();
        makeList(tiedosto);
    }
    
    public void makeList(String tiedosto) {
        try {
            Files.lines(Paths.get(tiedosto))
                    .forEach(line -> {
                        if (!line.equals("")) {
                        lista.add(line);}
                    });
        } catch (Exception ex) {
            System.out.println("Tiedostoa ei vissiin sitten ole");
        }
    }
    
    public int sanojenMaara() {
        return lista.size();
    }
    
    public ArrayList<String> kirjaimenZSisaltavatSanat() {
        return lista.stream()
                .filter(l -> l.contains("z"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<String> kirjaimeenNPaattyvatSanat() {
        return lista.stream()
                .filter(l -> l.endsWith("n"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<String> palindromit() {
        return lista.stream()
                .filter(l -> onPalindromi(l))
                .collect(Collectors.toCollection(ArrayList::new));
                
    }
    
    public boolean onPalindromi(String sana) {
        int loppu = sana.length() - 1;
        for (int i = 0; i < sana.length() / 2; i++) {
            if (sana.charAt(i) != sana.charAt(loppu - i)) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<String> kaikkiVokaalitSisaltavatSanat(){
        return lista.stream()
                .filter(l -> sisaltaaKaikkiVokaalit(l))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public boolean sisaltaaKaikkiVokaalit(String sana) {
        String[] vokaalit = {"a", "e", "i", "o", "u", "y", "ä", "ö"};
        for (int i = 0; i < vokaalit.length; i++) {
            if (!sana.contains(vokaalit[i])) {
                return false;
            }
        }
        return true;
    }
}
