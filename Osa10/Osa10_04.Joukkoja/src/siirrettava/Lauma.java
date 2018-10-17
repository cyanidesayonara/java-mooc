/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siirrettava;

/**
 *
 * @author Santtu
 */
import java.util.*;

public class Lauma implements Siirrettava {
    private List<Siirrettava> lauma;
    
    public Lauma() {
        this.lauma = new ArrayList();
    }
    
    public void lisaaLaumaan(Siirrettava siirrettava) {
        lauma.add(siirrettava);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lauma.forEach(s -> sb.append(s).append("\n"));
        return sb.toString().trim();
    }
    
    @Override
    public void siirra(int dx, int dy) {
        lauma.forEach(s -> s.siirra(dx, dy));
    }
    
}
