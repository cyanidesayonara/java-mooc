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
public class Tuotevarasto extends Varasto {
    private String tuotenimi;
    
    public Tuotevarasto(String tuotenimi, double tilavuus) {
        super(tilavuus);
        this.tuotenimi = tuotenimi;
    }
    
    public String getNimi() {
        return tuotenimi;
    }
    
    public void setNimi(String uusiNimi) {
        tuotenimi = uusiNimi;
    }
    
    @Override
    public String toString() {
        return tuotenimi + ": " + super.toString();
    }
    
}
