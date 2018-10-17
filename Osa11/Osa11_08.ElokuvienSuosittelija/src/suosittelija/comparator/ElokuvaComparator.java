/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.comparator;

/**
 *
 * @author Santtu
 */
import java.util.*;
import suosittelija.domain.*;

public class ElokuvaComparator implements Comparator<Elokuva> {
    Map<Elokuva, Double> arviot;
    
    public ElokuvaComparator(Map<Elokuva, List<Arvio>> arviot) {
        this.arviot = new HashMap();
        Set<Elokuva> setti = arviot.keySet();
        for (Elokuva e : setti) {
            double ka = arviot.get(e).stream().mapToDouble(a -> a.getArvo())
                    .average()
                    .getAsDouble();
            this.arviot.put(e, ka);
        }
    }

    @Override
    public int compare(Elokuva e1, Elokuva e2) {
        double ka1 = arviot.getOrDefault(e1, (double) 0);
        double ka2 = arviot.getOrDefault(e2, (double) 0);
        return Double.compare(ka2, ka1);
    }
}
