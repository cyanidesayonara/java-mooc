/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.domain;

/**
 *
 * @author Santtu
 */
public class Pala {
    private int x;
    private int y;
    
    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public boolean osuu(Pala pala) {
        return this.toString().equals(pala.toString());
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
