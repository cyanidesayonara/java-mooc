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

public class PainoindeksiOnYli implements Predicate<Double> {
    private double yli;
    
    public PainoindeksiOnYli(double yli) {
        this.yli = yli;
    }
    
    @Override
    public boolean test(Double painoindeksi) {
        return painoindeksi >= yli;
    }
}