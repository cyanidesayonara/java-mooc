/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muuttaminen.domain;

/**
 *
 * @author Santtu
 */
import java.util.List;
import java.util.ArrayList;

public class Muuttolaatikko implements Tavara {
    private int maksimitilavuus;
    private List<Tavara> loota;

    public Muuttolaatikko(int maksimitilavuus) {
       this.maksimitilavuus = maksimitilavuus;
       this.loota = new ArrayList<>();
    }
    
    public boolean lisaaTavara(Tavara tavara) {
        if (getTilavuus() + tavara.getTilavuus() > maksimitilavuus) {
            return false;
        }
        loota.add(tavara);
        return true;
    }
    
    @Override
    public int getTilavuus() {
        return loota.stream().mapToInt(t -> t.getTilavuus()).sum();
    }
    
    @Override
    public String toString() {
        String x = "";
        loota.forEach(t -> x.concat(t.toString()));
        return x;
    }
}
