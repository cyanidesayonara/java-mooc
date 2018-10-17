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
    private String nimi;
    private int sivuja;
    private int kirjoitusvuosi;
    
    public Kirja (String nimi, int sivuja, int kirjoitusvuosi) {
        this.nimi = nimi;
        this.sivuja = sivuja;
        this.kirjoitusvuosi = kirjoitusvuosi;
    } 
    
    public String getNimi() {
        return this.nimi;
    }
    
    public String toString() {
        return this.nimi + ", " + this.sivuja + " sivua, " + this.kirjoitusvuosi;
    }
}
