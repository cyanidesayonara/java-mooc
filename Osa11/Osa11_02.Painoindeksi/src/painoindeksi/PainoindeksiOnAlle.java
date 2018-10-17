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
import java.util.*;

public class PainoindeksiOnAlle implements Predicate<Double> {
    private Double alle;
    
    public PainoindeksiOnAlle(double alle) {
        this.alle = alle;
    }
    
    @Override
    public boolean test(Double painoindeksi) {
        return painoindeksi < alle;
    }
}
