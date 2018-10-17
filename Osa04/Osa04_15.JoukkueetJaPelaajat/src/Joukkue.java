/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
import java.util.ArrayList;

public class Joukkue {
    private String nimi;
    private int maksimikoko;
    private ArrayList<Pelaaja> pelaajat;
    
    public Joukkue(String joukkue) {
        this.nimi = joukkue;
        this.maksimikoko = 16;
        this.pelaajat = new ArrayList<>();
    }
    
    public String haeNimi() {
        return this.nimi;
    }
    
    public void lisaaPelaaja(Pelaaja pelaaja) {
        if (pelaajat.size() < this.maksimikoko) {
            this.pelaajat.add(pelaaja);
        }
    }
    
    public void tulostaPelaajat() {
        int i = 0;
        while (i < pelaajat.size()) {
            System.out.println(pelaajat.get(i));
            i++;
        }
    }
    
    public void asetaMaksimikoko(int max) {
        this.maksimikoko = max;
    }
    
    public int koko() {
        return pelaajat.size();
    }
    
    public int maalit() {
        int i = 0;
        int summa = 0;
        while (i < pelaajat.size()) {
            Pelaaja pelaaja = pelaajat.get(i);
            summa += pelaaja.maalit();
            i++;
        }
        return summa;
    }
}
