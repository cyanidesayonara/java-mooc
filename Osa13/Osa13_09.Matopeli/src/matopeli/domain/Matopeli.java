/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.domain;

import java.util.List;
import java.util.Random;
import matopeli.domain.*;

/**
 *
 * @author Santtu
 */
public class Matopeli {
    private int leveys;
    private int korkeus;
    private Random random;
    private Mato mato;
    private Omena omena;
    private int pojot;
    private boolean kasvoi;
    
    public Matopeli(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        random = new Random();
        mato = new Mato(leveys / 2, korkeus / 2, Suunta.ALAS);
        omena = new Omena(random.nextInt(leveys), random.nextInt(korkeus));
        while (mato.osuu(omena)) {
            omena = new Omena(random.nextInt(leveys), random.nextInt(korkeus));
        }
        pojot = 0;
        kasvoi = false;
    }
    
    public void paivita() {
        mato.liiku();
        kasvoi = false;
        if (mato.osuu(omena)) {
            mato.kasva();
            kasvoi = true;
            pojot++;
            while (mato.osuu(omena)) {
                setOmena(new Omena(random.nextInt(leveys), random.nextInt(korkeus)));
            }
        }
    }
    
    public boolean kasvoiko() {
        return kasvoi;
    }
    
    public Mato getMato() {
        return mato;
    }
    
    public void setMato(Mato mato) {
        this.mato = mato;
    }
    
    public Omena getOmena() {
        return omena;
    }
    
    public void setOmena(Omena omena) {
        this.omena = omena;
    }
    
    public int getPojot() {
        return pojot;
    }
    
    public boolean loppu() {
        if (mato.osuuItseensa()) {
            return true;
        }
        
        List<Pala> palat = mato.getPalat();
        
        for (int i = 0; i < palat.size(); i++) {
            Pala pala = palat.get(i);
            if (pala.getX() < 0 || pala.getX() >= leveys) {
                return true;
            }
            if (pala.getY() < 0 || pala.getY() >= korkeus) {
                return true;
            }
        }
        return false;
    }
}
