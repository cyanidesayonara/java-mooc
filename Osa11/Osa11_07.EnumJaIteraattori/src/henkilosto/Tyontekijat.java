/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilosto;

/**
 *
 * @author Santtu
 */
import java.util.*;

public class Tyontekijat {
    private List<Henkilo> tyontekijat;
    
    public Tyontekijat() {
        tyontekijat = new ArrayList();
    }
    
    public void lisaa(Henkilo lisa) {
        tyontekijat.add(lisa);
    }
    
    public void lisaa(List<Henkilo> lisat) {
        Iterator<Henkilo> iter = lisat.iterator();
        
        while(iter.hasNext()) {
            tyontekijat.add(iter.next());
        }
    }
    
    public void tulosta() {
        Iterator<Henkilo> iter = tyontekijat.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    
    public void tulosta(Koulutus koulutus) {
        Iterator<Henkilo> iter = tyontekijat.iterator();
        while(iter.hasNext()) {
            Henkilo t = iter.next();
            if (t.getKoulutus().equals(koulutus)) {
                System.out.println(t);
            }
        }
    }
    
    public void irtisano(Koulutus koulutus) {
        Iterator<Henkilo> iter = tyontekijat.iterator();
        while(iter.hasNext()) {
            if (iter.next().getKoulutus().equals(koulutus)) {
                iter.remove();
            }
        }
    }
}
