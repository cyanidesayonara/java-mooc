/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

/**
 *
 * @author Santtu
 */
public class MuistavaTuotevarasto extends Tuotevarasto {
    private Muutoshistoria historia;
    
    public MuistavaTuotevarasto(String tuotenimi, double tilavuus, double alkuSaldo) {
        super(tuotenimi, tilavuus);
        historia = new Muutoshistoria();
        lisaaVarastoon(alkuSaldo);
    }
    
    public String historia() {
        return historia.toString();
    }
    
    @Override
    public void lisaaVarastoon(double maara) {
        super.lisaaVarastoon(maara);
        historia.lisaa(getSaldo());
    }
    
    @Override
    public double otaVarastosta(double maara) {
        double x = super.otaVarastosta(maara);
        historia.lisaa(getSaldo());
        return x;
    }
    
    public void tulostaAnalyysi() {
        System.out.println("Tuote: " + getNimi());
        System.out.println("Historia: " + historia());
        System.out.println("Suurin tuotemäärä: " + historia.maxArvo());
        System.out.println("Pienin tuotemäärä: " + historia.minArvo());
        System.out.println("Keskiarvo: " + historia.keskiarvo());
        System.out.println("Suurin muutos: " + historia.suurinMuutos());
        System.out.println("Varianssi: " + historia.varianssi());
    }
}
