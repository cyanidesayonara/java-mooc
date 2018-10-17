/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Lista {
    private String rek;
    private int nopeus;
    
    public Lista(String rek, int nopeus) {
        this.rek = rek;
        this.nopeus = nopeus;
    }
    public int haeNopeus() {
        return this.nopeus;
    }
    public String haeRekkari() {
        return this.rek;
    }
}
