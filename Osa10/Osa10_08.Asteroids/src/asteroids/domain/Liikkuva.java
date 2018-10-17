/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.domain;

/**
 *
 * @author Santtu
 */
public class Liikkuva {
    protected Piste sijainti;
    protected Piste liike;
    protected double kaannosAsteina;
    protected double kaannosliike;
    
    public Liikkuva(Piste sijainti, Piste liike, double kaannosAsteina, double kaannosliike) {
        this.sijainti = sijainti;
        this.liike = liike;
        this.kaannosAsteina = kaannosAsteina;
        this.kaannosliike = kaannosliike;
    }

    public void liiku(long nanosekuntiaViimePaivityksesta) {
        this.sijainti.setX(this.sijainti.getX() + this.liike.getX());
        this.sijainti.setY(this.sijainti.getY() + this.liike.getY());

        kaanna(kaannosliike);
    }
    
    public void liiku(long nanosekuntiaViimeLiikkeesta, double nopeusKerroin) {
        double nopeus = nopeusKerroin * nanosekuntiaViimeLiikkeesta;
        this.sijainti.setX(this.sijainti.getX() + nopeus * Math.cos(Math.toRadians(kaannosAsteina)));
        this.sijainti.setY(this.sijainti.getY() + nopeus * Math.sin(Math.toRadians(kaannosAsteina)));
    }
    
    public Piste getSijainti() {
        return sijainti;
    }
    
    public void kaanna(double astetta) {
        kaannosAsteina = (kaannosAsteina + astetta) % 360;
    }
    
    public double getKaannosAsteina() {
        return kaannosAsteina;
    }

    public Piste getLiike() {
        return liike;
    }

    public void kiihdyta(double kiihdytys) {
        liike.setX(liike.getX() + kiihdytys * Math.cos(Math.toRadians(kaannosAsteina)));
        liike.setY(liike.getY() + kiihdytys * Math.sin(Math.toRadians(kaannosAsteina)));
    }

    public void kaannaVasemmalle(double paljonko) {
        this.kaannosAsteina += paljonko;
    }

    public void kaannaOikealle(double paljonko) {
        this.kaannosAsteina -= paljonko;
    }
    
}
