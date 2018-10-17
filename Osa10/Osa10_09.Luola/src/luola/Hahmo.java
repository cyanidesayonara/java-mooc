/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

/**
 *
 * @author Santtu
 */
public class Hahmo extends Liikkuva {
    protected char merkki;
    
    public Hahmo(int x, int y, char merkki, int leveys, int korkeus) {
        super(x, y, leveys, korkeus);
        this.merkki = merkki;
    }
    
    public char getMerkki() {
        return merkki;
    }

    @Override
    public String toString() {
        return merkki + " " + super.toString();
    }
}

