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
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MuistavaSanakirja {
    private Map<String, String> sanakirja;
    private String tiedosto;
    
    public MuistavaSanakirja() {
        sanakirja = new HashMap();
    }
    
    public MuistavaSanakirja(String tiedosto) {
        sanakirja = new HashMap();
        this.tiedosto = tiedosto;
    }
    
    public void lisaa(String sana, String kaannos) {
        sanakirja.putIfAbsent(sana, kaannos);  
    }
    
    public boolean lataa() {
        try {
            File file = new File(tiedosto);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] x = sc.nextLine().split(":");
                lisaa(x[0], x[1]);
            }
            sc.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean tallenna() {
        List<String> rivit = new ArrayList();
        for (Map.Entry<String, String> map : sanakirja.entrySet()) {
            rivit.add(map.getKey() + ":" + map.getValue());
        }
        try {
            Files.write(Paths.get(tiedosto), rivit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String kaanna(String sana) {
        for (Map.Entry<String, String> map : sanakirja.entrySet()) {
            String key = map.getKey();
            String val = map.getValue();
            if (sana.equals(key)) {
                return val;
            }
            if (sana.equals(val)) {
                return key;
            }
        }
        return null;
    }
    
    public void poista(String sana) {
        Iterator<Map.Entry<String, String>> iter = sanakirja.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> map = iter.next();
            String key = map.getKey();
            String val = map.getValue();
            if (sana.equals(key) || sana.equals(val)) {
                iter.remove();
            }
        }
    }
}
