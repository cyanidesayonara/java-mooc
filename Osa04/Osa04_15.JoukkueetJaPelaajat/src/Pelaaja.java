/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Pelaaja {
    private String nimi;
    private int maalit;
    
    public Pelaaja(String pelaaja) {
        nimi = pelaaja;
    }
    
    public Pelaaja(String pelaaja, int maara) {
        nimi = pelaaja;
        maalit = maara;
    }
    
    public String haeNimi() {
        return nimi;
    }
    
    public int maalit() {
        return maalit;
    }
    
    public String toString() {
        return nimi + ", maaleja " + maalit;
    }
}
