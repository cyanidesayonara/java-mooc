/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painoindeksi;

/**
 *
 * @author Santtu
 */
import java.util.function.Predicate;

public class Molemmat implements Predicate<Double>{
    private Predicate<Double> eka;
    private Predicate<Double> toka;
    
    public Molemmat(Predicate<Double> eka, Predicate<Double> toka) {
        this.eka = eka;
        this.toka = toka;
    }
    
    @Override
    public boolean test(Double painoindeksi) {
        return eka.test(painoindeksi) && toka.test(painoindeksi);
    }
}
