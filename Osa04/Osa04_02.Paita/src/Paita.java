/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Paita {
    private String vari;
    private int koko;
    private String materiaali;
    
    public Paita(String vari, int koko, String materiaali) {
        this.vari = vari;
        this.koko = koko;
        this.materiaali = materiaali;
    }
    
    public int getKoko() {
        return koko;
    }
    
    public String toString() {
        return "" + getKoko();
    }
}
