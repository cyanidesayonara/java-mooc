/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.domain;

/**
 *
 * @author Santtu
 */
public enum Arvio {
    HUONO(-5),
    VALTTAVA(-3),
    EI_NAHNYT(0),
    NEUTRAALI(1),
    OK(3),
    HYVA(5);
    
    private int arvo;
    
    private Arvio(int arvo) {
        this.arvo = arvo;
    }
    public int getArvo() {
        return arvo;
    }
}
