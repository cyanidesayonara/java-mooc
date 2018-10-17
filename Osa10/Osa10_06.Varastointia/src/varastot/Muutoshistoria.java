/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

/**
 *
 * @author Santtu
 */
import java.util.*;
import java.util.stream.Collectors;

public class Muutoshistoria {
private List<Double> historia;
    
    public Muutoshistoria() {
        historia = new ArrayList();
    }
    
    public void lisaa(double tilanne) {
        historia.add(tilanne);
    }
    
    public void nollaa() {
        historia.clear();
    }
    
    public double maxArvo() {
        return Collections.max(historia);
    }
    
    public double minArvo() {
        if (historia.isEmpty()) {
            return 0;
        }
        return historia.stream().mapToDouble(h -> h).min().getAsDouble();
    }
    
    public double keskiarvo() {
        if (historia.isEmpty()) {
            return 0;
        }
        return historia.stream().mapToDouble(h -> h).average().getAsDouble();
    }
    
    public double suurinMuutos() {
        double max = 0;
        for (int i = 0; i < historia.size() - 1; i++) {
            if (Math.abs(historia.get(i) - historia.get(i + 1)) > max) {
                max = Math.abs(historia.get(i) - historia.get(i + 1));
            }
        }
        return max;
    }
    
    public double varianssi() {
        double ka = keskiarvo();
        double x = 0;
        for (int i = 0; i < historia.size(); i++) {
            x += Math.pow((historia.get(i) - ka), 2);
        }
        return x / (historia.size() - 1);
    }
    
    @Override
    public String toString() {
        return historia.toString();
    }
}
