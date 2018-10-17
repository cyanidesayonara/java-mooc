/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyokalut;

import java.util.Set;

/**
 *
 * @author Santtu
 */
import java.util.*;
import java.util.stream.Collectors;

public class OmaDuplikaattienPoistaja implements DuplikaattienPoistaja {
    private Map<String, Integer> lista;
    
    public OmaDuplikaattienPoistaja() {
        lista = new HashMap();
    }
            
    @Override
    public void lisaa(String merkkijono) {
        if (lista.containsKey(merkkijono)) {
            lista.replace(merkkijono, lista.get(merkkijono) + 1);
        } else {
            lista.put(merkkijono, 0);
        }
    }

    @Override
    public int getHavaittujenDuplikaattienMaara() {
        return lista.values().stream().mapToInt(n -> n).sum();
    }

    @Override
    public Set<String> getUniikitMerkkijonot() {
        return lista.keySet().stream().collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public void tyhjenna() {
        lista.clear();
    }
    
}
