/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.domain;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Santtu
 */
public class Yksipisteinen extends Liikkuva {
    protected double sade;
    private Color vari;
    
    public Yksipisteinen(Piste sijainti, double sade, Color vari, double suuntaAsteina) {
        super(sijainti, new Piste(0, 0), suuntaAsteina, 0.0);
        this.sade = sade;
        this.vari = vari;
    }
    
    public boolean sisaltaa(Piste piste) {
        Piste keskipiste = keskipiste();

        return this.sade <= Math.sqrt((piste.getX() - keskipiste.getX()) * (piste.getX() - keskipiste.getX())
                + (piste.getY() - keskipiste.getY()) * (piste.getY() - keskipiste.getY()));
    }
    
    public Piste keskipiste() {
        return new Piste(this.sijainti.getX() + this.sade, this.sijainti.getY() + this.sade);
    }
    
    public void piirra(GraphicsContext gc) {
        gc.setFill(vari);
        gc.fillOval(this.sijainti.getX(), this.sijainti.getY(), this.sade, this.sade);
    }
    
}
