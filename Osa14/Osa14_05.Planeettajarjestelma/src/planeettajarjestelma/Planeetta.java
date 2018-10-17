/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeettajarjestelma;

import javafx.scene.paint.Color;

/**
 *
 * @author Santtu
 */
public class Planeetta {
    private double xSijainti;
    private double ySijainti;
    private double xNopeus;
    private double yNopeus;
    private double massa;
    private Color vari;
    
    public Planeetta(double xSijainti, double ySijainti, double xNopeus, double yNopeus, double massa) {
        this.xSijainti = xSijainti;
        this.ySijainti = ySijainti;
        this.xNopeus = xNopeus;
        this.yNopeus = yNopeus;
        this.massa = massa;
        this.vari = Color.BLACK;
    }
    
    public Planeetta(double xSijainti, double ySijainti, double xNopeus, double yNopeus, double massa, Color vari) {
        this.xSijainti = xSijainti;
        this.ySijainti = ySijainti;
        this.xNopeus = xNopeus;
        this.yNopeus = yNopeus;
        this.massa = massa;
        this.vari = vari;
    }
    
    public Color getVari() {
        return this.vari;
    }

    public double getSijaintiX() {
        return xSijainti;
    }

    public double getSijaintiY() {
        return ySijainti;
    }

    public double getNopeusX() {
        return xNopeus;
    }

    public double getNopeusY() {
        return yNopeus;
    }

    public double getMassa() {
        return massa;
    }

    public void setxSijainti(double xSijainti) {
        this.xSijainti = xSijainti;
    }

    public void setySijainti(double ySijainti) {
        this.ySijainti = ySijainti;
    }

    public void setxNopeus(double xNopeus) {
        this.xNopeus = xNopeus;
    }

    public void setyNopeus(double yNopeus) {
        this.yNopeus = yNopeus;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double etaisyys(Planeetta toinen) {
        Planeetta kolmas = new Planeetta(this.xSijainti, toinen.ySijainti, 0, 0, 0);
        double etaisyysA = this.ySijainti - kolmas.ySijainti;
        double etaisyysB = toinen.xSijainti - kolmas.xSijainti;
        return Math.hypot(etaisyysA, etaisyysB);
    }
    
    public double vetovoima(Planeetta toinen) {
        return 6.67384E-11 * (this.massa * toinen.massa) /
                (toinen.etaisyys(this) * toinen.etaisyys(this));
    }
    
    public double vetovoimaX(Planeetta toinen) {
        return toinen.vetovoima(this) *
                (toinen.xSijainti - this.xSijainti) / 
                toinen.etaisyys(this);
    }

    public double vetovoimaY(Planeetta toinen) {
        return toinen.vetovoima(this) *
                (toinen.ySijainti - this.ySijainti) / 
                toinen.etaisyys(this);
    }
}
