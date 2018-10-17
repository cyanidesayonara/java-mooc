/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiekkaranta;

import java.util.Random;

/**
 *
 * @author Santtu
 */
public class Simulaatio {
    private Tyyppi[][] sim;
    private Random random;
    
    public Simulaatio(int leveys, int korkeus) {
        sim = new Tyyppi[leveys][korkeus];
        Random random = new Random();
        
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                sim[i][j] = Tyyppi.TYHJA;
            }
        }
    }
    
    public void lisaa(int x, int y, Tyyppi tyyppi) {
        sim[x][y] = tyyppi;
    }
    
    public Tyyppi sisalto(int x, int y) {
        if (x < 0 || x >= sim.length) {
            return Tyyppi.METALLI;
        }
        if (y < 0 || y >= sim[x].length) {
            return Tyyppi.METALLI;
        }
        return sim[x][y];
    }
    
    public void paivita() {
        for (int i = 0; i < sim.length; i++) {
            for (int j = 0; j < sim[i].length; j++) {
                if (i > 0 &&
                    i < sim.length - 1 &&
                    j < sim[i].length - 1 &&
                    random.nextInt(100) > 5) {
                    if (sim[i][j].equals(Tyyppi.HIEKKA)) {
                        if (sim[i][j + 1].equals(Tyyppi.TYHJA)) {
                            sim[i][j] = Tyyppi.TYHJA;
                            sim[i][j + 1] = Tyyppi.HIEKKA;
                        } else {
                            if (sim[i + 1][j + 1].equals(Tyyppi.TYHJA)) {
                                sim[i][j] = Tyyppi.TYHJA;
                                sim[i + 1][j + 1] = Tyyppi.HIEKKA;
                            } else if (sim[i - 1][j + 1].equals(Tyyppi.TYHJA)) {
                                sim[i][j] = Tyyppi.TYHJA;
                                sim[i - 1][j + 1] = Tyyppi.HIEKKA;
                            } else if (sim[i][j + 1].equals(Tyyppi.VESI)) {
                                sim[i][j] = Tyyppi.VESI;
                                sim[i][j + 1] = Tyyppi.HIEKKA;
                            } else if (sim[i + 1][j + 1].equals(Tyyppi.VESI)) {
                                sim[i][j] = Tyyppi.VESI;
                                sim[i + 1][j + 1] = Tyyppi.HIEKKA;
                            } else if (sim[i - 1][j + 1].equals(Tyyppi.VESI)) {
                                sim[i][j] = Tyyppi.VESI;
                                sim[i - 1][j + 1] = Tyyppi.HIEKKA;
                            }
                        }
                    }
                    
                    if (sim[i][j].equals(Tyyppi.VESI)) {
                        if (sim[i][j + 1].equals(Tyyppi.TYHJA)) {
                            sim[i][j] = Tyyppi.TYHJA;
                            sim[i][j + 1] = Tyyppi.VESI;
                        } else  {
                            if (sim[i + 1][j + 1].equals(Tyyppi.TYHJA)) {
                                sim[i][j] = Tyyppi.TYHJA;
                                sim[i + 1][j + 1] = Tyyppi.VESI;
                            } else if (sim[i - 1][j + 1].equals(Tyyppi.TYHJA)) {
                                sim[i][j] = Tyyppi.TYHJA;
                                sim[i - 1][j + 1] = Tyyppi.VESI;
                            } else {
                                int z = random.nextInt(2);
                                if (sim[i - 1][j].equals(Tyyppi.TYHJA) &&
                                    z == 0) {
                                    sim[i][j] = Tyyppi.TYHJA;
                                    sim[i - 1][j] = Tyyppi.VESI;
                                } if (sim[i + 1][j].equals(Tyyppi.TYHJA) &&
                                    z == 1) {
                                    sim[i][j] = Tyyppi.TYHJA;
                                    sim[i + 1][j] = Tyyppi.VESI;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
