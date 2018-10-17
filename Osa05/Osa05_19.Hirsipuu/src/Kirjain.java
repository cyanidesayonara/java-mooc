/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Kirjain {
    private String arvo;
    private String piilo;
    
    public Kirjain(String arvo) {
        this.arvo = "_";
        this.piilo = arvo;
    }
    
    public String getKirjain() {
        return arvo;
    }
    
    public String getArvo() {
        return piilo;
    }
    
    public void switchKirjain() {
        String temp = this.arvo;
        this.arvo = this.piilo;
        this.piilo = temp;
    }
}
