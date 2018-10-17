/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muuttaminen.domain;

/**
 *
 * @author Santtu
 */
public class Esine implements Tavara, Comparable<Esine> {
    private String nimi;
    private int tilavuus;
    
    public Esine(String nimi, int tilavuus) {
        this.nimi = nimi;
        this.tilavuus = tilavuus;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    @Override
    public int getTilavuus() {
        return tilavuus;
    }
    
    @Override
    public String toString() {
        return nimi + " (" + tilavuus + " dm^3)";
    }
    
    @Override
    public int compareTo(Esine verrattava) {
        return tilavuus - verrattava.getTilavuus();
    }
}
