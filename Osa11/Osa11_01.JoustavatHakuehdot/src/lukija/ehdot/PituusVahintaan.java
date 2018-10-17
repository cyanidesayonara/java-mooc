/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukija.ehdot;

/**
 *
 * @author Santtu
 */
import java.util.function.Predicate;

public class PituusVahintaan implements Predicate<String>{
    private int vahintaan;
    
    public PituusVahintaan(int vahintaan) {
        this.vahintaan = vahintaan;
    }
    
    @Override
    public boolean test(String rivi) {
        if (rivi.length() >= vahintaan) {
            return true;
        }
        return false;
    }
    
}
