/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Korkein {
    private String nimi;
    private double lukutaito;
    
    public Korkein(String nimi, double lukutaito) {
        this.nimi = nimi;
        this.lukutaito = lukutaito;
    }
    
    public double haeLukutaito() {
        return lukutaito;
    }
    
    public String haeMaa() {
        return nimi;
    }
}
