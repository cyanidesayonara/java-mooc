/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surface
 */
public class Tuote {
    private double hinta;
    private int lukumaara;
    private String nimi;
    
    public Tuote(String nimiAlussa, double hintaAlussa, int lukumaaraAlussa) {
        this.hinta = hintaAlussa;
        this.lukumaara = lukumaaraAlussa;
        this.nimi = nimiAlussa;
    }
    
    public void tulostaTuote() {
        System.out.println(this.nimi + ", hinta " + this.hinta + this.lukumaara + " kpl");
    }
}
