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
import suosittelija.domain.*;
import java.util.*;

public class HenkiloComparator implements Comparator<Henkilo> {
    private Map<Henkilo, Integer> henkiloidenSamuudet;
            
    public HenkiloComparator(Map<Henkilo, Integer> henkiloidenSamuudet) {
        this.henkiloidenSamuudet = henkiloidenSamuudet;
    }

    @Override
    public int compare(Henkilo h1, Henkilo h2) {
        return henkiloidenSamuudet.getOrDefault(h2, 0)
                .compareTo(henkiloidenSamuudet.getOrDefault(h1, 0));
    }
    
    
    
}
