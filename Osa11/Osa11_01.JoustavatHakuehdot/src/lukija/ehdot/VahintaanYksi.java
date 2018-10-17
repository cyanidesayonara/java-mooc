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
import java.util.*;

public class VahintaanYksi implements Predicate<String> {
    private Predicate<String>[] ehdot;
    
    public VahintaanYksi(Predicate<String>... ehdot) {
        this.ehdot = ehdot;
    }
    
    @Override
    public boolean test(String rivi) {
        for (int i = 0; i < ehdot.length; i++) {
            if (ehdot[i].test(rivi)) {
                return true;
            }
        }
        return false;
    }
    
}
