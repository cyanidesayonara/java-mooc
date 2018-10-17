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

public class KaikkiRivit implements Predicate<String> {
    
    public KaikkiRivit(){
        
    }
    
    public boolean test(String rivi) {
        return true;
    }
}
