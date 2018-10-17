/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class YlhaaltaRajoitettuLaskuri {
    private int arvo;
    private int ylaraja;
    
    public YlhaaltaRajoitettuLaskuri(int ylarajanAlkuarvo) {
        this.arvo = 0;
        this.ylaraja = ylarajanAlkuarvo;
    }
    
    public void seuraava() {
        if (arvo < ylaraja) {
            this.arvo++;
        } else {
            this.arvo = 0;
        }
    }
    
    public void asetaArvo(int uusiArvo) {
        if (uusiArvo > 0 && uusiArvo <= ylaraja) {
            this.arvo = uusiArvo;
        }
    }
    
    public int arvo() {
        return this.arvo;
    }
    
    public int getYlaraja() {
        return this.ylaraja;
    }
    
    public int getArvo() {
        return this.arvo;
    }
    
    public String toString() {
        if (arvo < 10) {
            return "0" + this.arvo;
        } else {
            return "" + this.arvo;
        }    
    }
}
