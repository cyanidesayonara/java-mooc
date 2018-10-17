/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

/**
 *
 * @author Santtu
 */
import java.util.ArrayList;
import java.util.List;

public class Keskiarvosensori implements Sensori {
    private List<Sensori> sensorit;
    private List<Integer> mittaukset;
    
    public Keskiarvosensori() {
        sensorit = new ArrayList<>();
        mittaukset = new ArrayList<>();
    }
    
    @Override
    public boolean onPaalla() {
        return sensorit.stream().filter(s -> !s.onPaalla()).count() == 0;
    }
    
    @Override
    public void paalle() {
        sensorit.forEach(s -> s.paalle());
    }
    
    @Override
    public void poisPaalta() {
        sensorit.forEach(s -> s.poisPaalta());
    }
    
    @Override
    public int mittaa() {
        if (!onPaalla() ||
            sensorit.isEmpty()) {
            throw new IllegalStateException("Nyt on joku vialla");
        }
        int sum = sensorit.stream().mapToInt(s -> s.mittaa()).sum();
        int ka = sum / sensorit.size();
        mittaukset.add(ka);
        return ka;
    }
    
    public void lisaaSensori(Sensori lisattava) {
        sensorit.add(lisattava);
    }
    
    public List<Integer> mittaukset() {
        return mittaukset;
    }
    
}
