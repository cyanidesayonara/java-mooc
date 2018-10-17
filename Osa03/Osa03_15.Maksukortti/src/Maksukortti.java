/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Maksukortti {
    
    private double saldo;
    
    public Maksukortti (double alkusaldo) {
        this.saldo = alkusaldo;
    }
    
    public String toString() {
        return "Kortilla on rahaa " + this.saldo + " euroa";
    }
    
    public void syoEdullisesti() {
        if (saldo >= 2.60) {
            this.saldo = saldo - 2.60;
        }
    }
    
    public void syoMaukkaasti() {
        if (saldo >= 4.60) {
            this.saldo = saldo - 4.60;
        }
    }
    
    public void lataaRahaa(double rahamaara) {
        if (rahamaara > 0) {
            if (saldo + rahamaara <= 150) {
                this.saldo = saldo + rahamaara;
            } else {
                this.saldo = 150;
            }
        }
    }
}
