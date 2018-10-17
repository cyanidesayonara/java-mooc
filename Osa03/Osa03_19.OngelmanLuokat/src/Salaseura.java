/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Salaseura {
    private String nimi;
    private String koodi;
    private int kaynnit;
    private int palkinnot;
    
    public Salaseura (String nimi, String koodi) {
        this.nimi = nimi;
        this.koodi = koodi;
        this.kaynnit = 0;
        this.palkinnot = 0;
    }    
    
    public void kaynti() {
        this.kaynnit++;
    }
    
    public void palkinto() {
        this.palkinnot++;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public String getKoodi() {
        return this.koodi;
    }
    
    public int getKaynnit() {
        return this.kaynnit;
    }
    
    public int getPalkinnot() {
        return this.palkinnot;
    }
    
    public String toString() {
        return "Nimi: " + this.nimi + ", käynnit: " + this.kaynnit + ", palkinnot: " + this.palkinnot;
    }
}
