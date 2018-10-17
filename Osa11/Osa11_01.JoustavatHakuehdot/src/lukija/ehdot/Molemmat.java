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

public class Molemmat implements Predicate<String> {
    private Predicate<String> loppuu;
    private Predicate<String> sisaltaa;
    
    public Molemmat(Predicate<String> loppuu, Predicate<String> sisaltaa) {
        this.loppuu = loppuu;
        this.sisaltaa = sisaltaa;
    }
    
    @Override
    public boolean test(String rivi) {
        if (loppuu.test(rivi) && sisaltaa.test(rivi)) {
            return true;
        }
        return false;
    }
    
}
