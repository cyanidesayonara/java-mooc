/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.Random;

/**
 *
 * @author Santtu
 */
public class Peliruudukko {
    private int[][] taulukko;
    private int koko;
    private Random random;
    
    public Peliruudukko() {
        koko = 4;
        taulukko = new int[koko][koko];
        taulukko[0][0] = 1;
        random = new Random();
    }
    
    public int[][] getTaulukko() {
        return taulukko;
    }
    
    public void setTaulukko(int[][] taulukko) {
        this.taulukko = taulukko;
    }
    
    public boolean peliKaynnissa() {
        // löytyykö nollia?
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (taulukko[i][j] == 0) {
                    return true;
                }
            }
        }
        // onko vierekkäisiä samansuuruisia?
        for (int i = 0; i < koko - 1; i++) {
            for (int j = 0; j < koko - 1; j++) {
                if (taulukko[i][j] == taulukko[i + 1][j] ||
                    taulukko[i][j] == taulukko[i][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void lisaa() {
        // laske nollien määrä
        int maara = 0;
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (taulukko[i][j] == 0) {
                    maara++;
                }
            }
        }
        // arvotaan satunnainen luku väliltä 0 - nollien määrä
        int lisattava = random.nextInt(maara);
        maara = 0;
        // lasketaan nollia edellä arvottuun satunnaislukuun asti
        // ja vaihdetaan saavutettu nolla ykköseksi
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (taulukko[i][j] == 0) {
                    if (lisattava == maara) {
                        taulukko[i][j] = 1;
                        return;
                    }
                maara++;
                }
            }
        }
    }

    public void siirraOikealle() {
        boolean flag;
        for (int y = 0; y < koko; y++) {
            do {
                flag = false;
                // käy riviä läpi vierekkäisiä lukuja vertaillen
                // (aloittaen siitä päästä jonka suuntaan siirretään)
                // kunnes flag != true (eli ei siirrettävää jäljellä)
                for (int x = koko - 2; x >= 0; x--) {
                    // siirrä...
                    if (taulukko[y][x] > 0 &&
                    taulukko[y][x + 1] == 0) {
                        taulukko[y][x + 1] = taulukko[y][x];
                        taulukko[y][x] = 0;
                        flag = true;
                    // ...tai tuplaa
                    } else if (taulukko[y][x] > 0 &&
                    taulukko[y][x] == taulukko[y][x + 1]) {
                        taulukko[y][x + 1] *= 2;
                        taulukko[y][x] = 0;
                        flag = true;
                    }
                }
            } while(flag);
        }
    }
    
    public void siirraYlos() {
        boolean flag;
        for (int x = 0; x < koko; x++) {
            do {
                flag = false;
                for (int y = 1; y < koko; y++) {
                    if (taulukko[y][x] > 0 &&
                    taulukko[y - 1][x] == 0) {
                        taulukko[y - 1][x] = taulukko[y][x];
                        taulukko[y][x] = 0;
                        flag = true;
                    } else if (taulukko[y][x] > 0 &&
                    taulukko[y][x] == taulukko[y - 1][x]) {
                        taulukko[y - 1][x] *= 2;
                        taulukko[y][x] = 0;
                        flag = true;
                    }
                }
            } while(flag);
        }
    }
    
    public void siirraVasemmalle() {
        boolean flag;
        for (int y = 0; y < koko; y++) {
            do {
                flag = false;
                for (int x = 1; x < koko; x++) {
                    if (taulukko[y][x] > 0 &&
                    taulukko[y][x - 1] == 0) {
                        taulukko[y][x - 1] = taulukko[y][x];
                        taulukko[y][x] = 0;
                        flag = true;
                    } else if (taulukko[y][x] > 0 &&
                    taulukko[y][x] == taulukko[y][x - 1]) {
                        taulukko[y][x - 1] *= 2;
                        taulukko[y][x] = 0;
                        flag = true;
                    }
                }
            } while(flag);
        }
    }
    
    public void siirraAlas() {
        boolean flag;
        for (int x = 0; x < koko; x++) {
            do {
                flag = false;
                for (int y = koko - 2; y >= 0; y--) {
                    if (taulukko[y][x] > 0 &&
                    taulukko[y + 1][x] == 0) {
                        taulukko[y + 1][x] = taulukko[y][x];
                        taulukko[y][x] = 0;
                        flag = true;
                    } else if (taulukko[y][x] > 0 &&
                    taulukko[y][x] == taulukko[y + 1][x]) {
                        taulukko[y + 1][x] *= 2;
                        taulukko[y][x] = 0;
                        flag = true;
                    }
                }
            } while(flag);
        }
    }
}