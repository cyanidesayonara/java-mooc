/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santtu
 */
public class Mato {
    private List<Pala> palat;
    private Suunta suunta;
    private boolean kasvetaanko;
    
    public Mato(int alkuX, int alkuY, Suunta alkusuunta) {
        palat = new ArrayList();
        palat.add(new Pala(alkuX, alkuY));
        this.suunta = alkusuunta;
        kasvetaanko = true;
    }
    
    public Suunta getSuunta() {
        return suunta;
    }
    
    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }
    
    public int getPituus() {
        return palat.size();
    }
    
    public List<Pala> getPalat() {
        return palat;
    }
    
    public void liiku() {
        Pala paa = palat.get(palat.size() - 1);
        
        switch (suunta) {
            case YLOS:
                palat.add(new Pala(paa.getX(), paa.getY() - 1));
                break;
            case OIKEA:
                palat.add(new Pala(paa.getX() + 1, paa.getY()));
                break;
            case ALAS:
                palat.add(new Pala(paa.getX(), paa.getY() + 1));
                break;
            default:
                palat.add(new Pala(paa.getX() - 1, paa.getY()));
        }
        
        if (kasvetaanko == false) {
            palat.remove(0);
        }
        
        if (palat.size() > 2) {
            kasvetaanko = false;
        }
    }
    
    public void kasva() {
        if (palat.size() > 2) {
            kasvetaanko = true;
        }
    }
    
    public boolean osuu(Pala pala) {
        for (int i = 0; i < palat.size(); i++) {
            if (palat.get(i).osuu(pala)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean osuuItseensa() {
        for (int i = 0; i < palat.size(); i++) {
            for (int j = 0; j < palat.size(); j++) {
                if (i != j && palat.get(i).osuu((palat.get(j)))) {
                    return true;
                }
            }
        }
        return false;
    }
}
