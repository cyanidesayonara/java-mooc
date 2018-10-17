/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

/**
 *
 * @author Santtu
 */
import java.util.*;

public class OmaUseanKaannoksenSanakirja implements UseanKaannoksenSanakirja {
    private Map<String, Set<String>> dict;
            
    public OmaUseanKaannoksenSanakirja() {
        dict = new HashMap();
    }
    
    @Override
    public void lisaa(String sana, String kaannos) {
        dict.putIfAbsent(sana, new HashSet());
        Set<String> kaannokset = dict.get(sana);
        kaannokset.add(kaannos);
    }

    @Override
    public Set<String> kaanna(String sana) {
        
        return dict.getOrDefault(sana, new HashSet());
    }

    @Override
    public void poista(String sana) {
        dict.remove(sana);
    }
}
