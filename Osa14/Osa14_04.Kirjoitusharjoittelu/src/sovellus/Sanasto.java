package sovellus;

import java.util.*;

public class Sanasto {
    private List<String> sanat;
    private int viimeksiAnnetunSananIndeksi;
    private Queue<String> sanaBufferi;
    private Random rnd;

    public Sanasto() {
        this.sanat = new ArrayList<>();
        try {
            BonusSanasto bs = new BonusSanasto();
            bs.getSanasto().forEach(s -> sanat.add(s));
        } catch (Exception e) {
            System.out.println("Sanaston lataus epäonnistui");
        }
        
        if (sanat.isEmpty()) {
            this.sanat.add("never");
            this.sanat.add("gonna");
            this.sanat.add("give");
            this.sanat.add("you");
            this.sanat.add("up");
        }

        viimeksiAnnetunSananIndeksi = -1;
        rnd = new Random();
        sanaBufferi = new LinkedList();
        populoitaBufferi();
    }

    public Queue<String> annaSanat() {
        sanaBufferi.remove();
        int annettavanSananIndeksi = rnd.nextInt(sanat.size());
        while (annettavanSananIndeksi == viimeksiAnnetunSananIndeksi) {
            annettavanSananIndeksi = rnd.nextInt(sanat.size());
        }
        this.viimeksiAnnetunSananIndeksi = annettavanSananIndeksi;
        sanaBufferi.add(sanat.get(annettavanSananIndeksi));
        Queue<String> annettavatSanat = new LinkedList();
        sanaBufferi.stream().forEach(s -> annettavatSanat.add(s));
        return annettavatSanat;      
    }
    
    public void populoitaBufferi() {
        for (int i = 0; i < 10; i++) {
            int annettavanSananIndeksi = rnd.nextInt(sanat.size());
            while (annettavanSananIndeksi == viimeksiAnnetunSananIndeksi) {
                annettavanSananIndeksi = rnd.nextInt(sanat.size());
            }
            this.viimeksiAnnetunSananIndeksi = annettavanSananIndeksi;
            sanaBufferi.add(sanat.get(annettavanSananIndeksi));
        }
    }
}
