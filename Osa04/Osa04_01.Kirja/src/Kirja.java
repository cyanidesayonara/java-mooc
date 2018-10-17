/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Kirja {
    private String kirjailija;
    private String nimi;
    private int sivuja;
    
    public Kirja (String kirjailija, String nimi, int sivuja) {
        this.kirjailija = kirjailija;
        this.nimi = nimi;
        this.sivuja = sivuja;
    }
    
    public String getKirjailija() {
        return kirjailija;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public int getSivuja() {
        return sivuja;
    }
    
    public String toString() {
        return (getKirjailija() + ", " + getNimi() + ", " + getSivuja() + " sivua");
    }
}
