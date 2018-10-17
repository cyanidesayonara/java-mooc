/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeettajarjestelma;

import java.util.*;
import planeettajarjestelma.Planeetta;

/**
 *
 * @author Santtu
 */
public class Planeettajarjestelma {
    private List<Planeetta> planeetat;
    private double halkaisija;
            
    public Planeettajarjestelma(List<Planeetta> planeetat, double halkaisija) {
        this.planeetat = planeetat;
        this.halkaisija = halkaisija;
    }
    
    public List<Planeetta> getPlaneetat() {
        return planeetat;
    }
    
    public void paivita(double ajanmuutos) {
        Map<Planeetta, double[]> planeettojenVoimat = new HashMap();
        Iterator iter = planeetat.iterator();
        while (iter.hasNext()) {
            Planeetta planeetta = (Planeetta) iter.next();
            double voimienSummaX = planeetat.stream()
                    .filter(p -> !p.equals(planeetta))
                    .mapToDouble(p -> planeetta.vetovoimaX(p))
                    .sum();
            double voimienSummaY = planeetat.stream()
                    .filter(p -> !p.equals(planeetta))
                    .mapToDouble(p -> planeetta.vetovoimaY(p))
                    .sum();
            double voimienSummat[] = new double [2];
            voimienSummat[0] = voimienSummaX;
            voimienSummat[1] = voimienSummaY;
            planeettojenVoimat.put(planeetta, voimienSummat);
        }
        
        planeetat.forEach(p -> {
            double kiihdytysX = planeettojenVoimat.get(p)[0] / p.getMassa();
            double kiihdytysY = planeettojenVoimat.get(p)[1] / p.getMassa();
            p.setxNopeus(p.getNopeusX() + ajanmuutos * kiihdytysX);
            p.setyNopeus(p.getNopeusY() + ajanmuutos * kiihdytysY);
            p.setxSijainti(p.getSijaintiX() + ajanmuutos * p.getNopeusX());
            p.setySijainti(p.getSijaintiY() + ajanmuutos * p.getNopeusY());
        });
    }
}
