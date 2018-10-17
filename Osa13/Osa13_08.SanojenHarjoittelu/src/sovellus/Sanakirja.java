/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Santtu
 */
public class Sanakirja {
   private List<String> sanat;
   private Map<String, String> sanakirja;
   private Random random;
    
    public Sanakirja() {
        sanat = new ArrayList();
        sanakirja = new HashMap();
        random = new Random();
        lisaa("sana", "word");
    }
    
    public String haeKaannos(String sana) {
        return sanakirja.get(sana);
    }
    
    public void lisaa(String sana, String kaannos) {
        if (!sanakirja.containsKey(sana)) {
            sanat.add(sana);
            sanakirja.put(sana, kaannos);
        }
    }
    
    public String randomSana() {
        System.out.println(sanat.size());
        return sanat.get(random.nextInt(sanat.size()));
    }
}
