/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilot;

/**
 *
 * @author Santtu
 */
public class Opiskelija extends Henkilo {
    private int pojot;
    
    public Opiskelija(String nimi, String osoite) {
        super(nimi, osoite);
        pojot = 0;
    }
    
    public void opiskele() {
        pojot++;
    }
    
    public int opintopisteita() {
        return pojot;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n  opintopisteitä " + pojot;
    }
}
