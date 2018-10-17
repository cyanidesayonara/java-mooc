import java.util.ArrayList;
import java.util.stream.Collectors;

public class Kasi {
    private ArrayList<Kortti> kasi;
    private ArrayList<Kortti> sopivat;
    private ArrayList<Integer> sopivienIndeksit;
    
    public Kasi(ArrayList<Kortti> kasi, Kortti paallimmaisin, String vari) {
        this.kasi = kasi;
        this.sopivat = sopivatKortit(paallimmaisin, vari);
        this.sopivienIndeksit = sopivienIndeksit(paallimmaisin, vari);
    }
    
    public Kasi(ArrayList<Kortti> kasi) {
        this.kasi = kasi;
    }
    
    public ArrayList<Kortti> getKasi() {
        return kasi;
    }
    
    public ArrayList<Kortti> getSopivat() {
        return sopivat;
    }
    
    public ArrayList<Integer> getSopivienIndeksit() {
        return sopivienIndeksit;
    }
    
    public ArrayList<Kortti> sopivatKortit(Kortti paallimmaisin, String vari) {
        return kasi.stream()
                .filter(k -> k.saaPelataKortin(paallimmaisin, vari))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Integer> sopivienIndeksit(Kortti paallimmaisin, String vari) {
        ArrayList<Integer> sopivienIndeksit = new ArrayList<>();
        kasi.stream()
                .filter(k -> k.saaPelataKortin(paallimmaisin, vari))
                .forEach(k -> sopivienIndeksit.add(kasi.indexOf(k)));
        return sopivienIndeksit;
    }
    
    public int sopivienIsoimmanNumeronIndeksi() {
        ArrayList<Integer> isoimmanIndeksi = new ArrayList<>();
        sopivat.stream()
                .filter(k -> k.getKorttityyppi().equals("Numero"))
                .sorted((k1, k2) -> {
                    return k2.getNumero() - k1.getNumero();
                }).forEach(k -> isoimmanIndeksi.add(sopivat.indexOf(k)));
        if (isoimmanIndeksi.isEmpty()) {
            return 666;
        } else {
            return isoimmanIndeksi.get(0);
        }                
    }

    public ArrayList<Integer> villienIndeksit() {
        ArrayList<Integer> villienIndeksit = new ArrayList<>();
        sopivat.stream()
                .filter(k -> k.onVillikortti())
                .forEach(k -> villienIndeksit.add(kasi.indexOf(k)));
        return villienIndeksit;
    }
    
    public ArrayList<Integer> nostojenIndeksit() {
        ArrayList<Integer> nostojenIndeksit = new ArrayList<>();
        sopivat.stream()
                .filter(k -> k.onNosta())
                .forEach(k -> nostojenIndeksit.add(kasi.indexOf(k)));
        return nostojenIndeksit;
    }
    
    public ArrayList<Integer> ohituksienIndeksit() {
        ArrayList<Integer> ohituksienIndeksit = new ArrayList<>();
        sopivat.stream()
                .filter(k -> k.onOhitus())
                .forEach(k -> ohituksienIndeksit.add(kasi.indexOf(k)));
        return ohituksienIndeksit;
    }
    
    public ArrayList<Integer>suunnanvaihtojenIndeksit() {
        ArrayList<Integer> suunnanvaihtojenIndeksit = new ArrayList<>();
        sopivat.stream()
                .filter(k -> k.onSuunnanvaihto())
                .forEach(k -> suunnanvaihtojenIndeksit.add(kasi.indexOf(k)));
        return suunnanvaihtojenIndeksit;
    }
    
    public ArrayList<String> yleisimmatVaritNimina() {
        ArrayList<String> yleisimmatVarit = kasi.stream()
                .filter(k -> !k.onVillikortti())
                .map(k -> k.getVari())
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        return yleisimmatVarit;
    }
    
    public ArrayList<Integer> yleisimmatVaritIndekseina() {
        ArrayList<String> yleisimmatVarit = yleisimmatVaritNimina();
        
        String[] vari = {"Punainen", "Vihreä", "Sininen", "Keltainen"};
        
        ArrayList<Integer> yleisyys = new ArrayList<>();
        
        for (int i = 0; i < vari.length; i++) {
            yleisyys.add(0);
        }
        
        for (int i = 0; i < yleisimmatVarit.size(); i++) {
            for (int j = 0; j < vari.length; j++) {
                if (yleisimmatVarit.get(i).equals(vari[j])) {
                    yleisyys.set(j, yleisyys.get(j) + 1);
                }
            }
        }
        return yleisyys;
    }
    
    public String yleisimmanVarinNimi() {
        String[] vari = {"Punainen", "Vihreä", "Sininen", "Keltainen"};
        return vari[yleisimmanVarinIndeksi()];
    }
    
    public int yleisimmanVarinIndeksi() {
        ArrayList<Integer> yleisyys = yleisimmatVaritIndekseina();
        int yleisimmanVarinIndeksi = 0;
        for (int i = 0, korkein = 0; i < yleisyys.size(); i++) {
            if (yleisyys.get(i) > korkein) {
                yleisimmanVarinIndeksi = i;
                korkein = yleisyys.get(i);
            }
        }
        return yleisimmanVarinIndeksi;
    }
}
