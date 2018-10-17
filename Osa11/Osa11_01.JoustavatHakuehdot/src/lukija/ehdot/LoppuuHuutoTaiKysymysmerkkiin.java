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

public class LoppuuHuutoTaiKysymysmerkkiin implements Predicate<String> {

    
    public LoppuuHuutoTaiKysymysmerkkiin() {

    }
    
    @Override
    public boolean test(String rivi) {
        if (rivi.endsWith("?")) {
            return true;
        }
        if (!rivi.isEmpty()) {
            if (rivi.charAt(rivi.length() - 1) == '!') {
                return true;
            }
        }
        return false;
    }
}
