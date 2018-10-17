import java.util.ArrayList;

public class Havainnot {
    private ArrayList<String> havainnot;
    
    public Havainnot() {
        this.havainnot = new ArrayList<>();
    }
    
    public void lisaaHavainto(String nimi) {
        havainnot.add(nimi);
    }
    
    public int havainnotMaara(String nimi) {
        return (int) havainnot.stream()
                .filter(l -> l.equals(nimi)).count();
    }
}