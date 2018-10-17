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

public class Ei implements Predicate<String> {
    private Predicate<String> ehto;
    
    public Ei(Predicate<String> ehto) {
        this.ehto = ehto;
    }
    
    @Override
    public boolean test(String rivi) {
        if (!ehto.test(rivi)) {
            return true;
        }
        return false;
    }
    
    
}
