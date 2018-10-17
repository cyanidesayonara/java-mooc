/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

/**
 *
 * @author Santtu
 */
import java.util.Random;

public class Lampomittari implements Sensori {
    private boolean paalla;
    private int mittaus;
    
    public Lampomittari() {
        paalla = false;
    }
    
    @Override
    public boolean onPaalla() {
        return paalla;
    }
    
    @Override
    public void paalle() {
        paalla = true;
    }
    
    @Override
    public void poisPaalta() {
        paalla = false;
    }
    
    @Override
    public int mittaa() {
        if (paalla == false) {
            throw new IllegalStateException("Ei päällä");
        }
        mittaus = -30 + new Random().nextInt(61);
        return mittaus;
    }
}
