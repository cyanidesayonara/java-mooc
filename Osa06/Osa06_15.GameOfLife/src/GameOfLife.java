
import java.util.Random;

public class GameOfLife {

    private int[][] taulukko;

    public GameOfLife(int leveys, int korkeus) {
        this.taulukko = new int[leveys][korkeus];
    }

    public void alustaSatunnaisesti() {
        Random satunnaistaja = new Random();

        int x = 0;
        while (x < taulukko.length) {

            int y = 0;
            while (y < taulukko[x].length) {
                if (satunnaistaja.nextDouble() < 0.2) {
                    taulukko[x][y] = 1;
                }

                y++;
            }
            x++;
        }
    }

    public void kehity() {
        // säännöt kehittymiselle:

        // 1. jokainen elossa oleva alkio, jolla on alle 2 elossa olevaa naapuria kuolee
        // 2. jokainen elossa oleva alkio, jolla on 2 tai 3 elossa olevaa naapuria pysyy hengissä
        // 3. jokainen elossa oleva alkio, jolla on 4 tai enemmän naapureita kuolee
        // 4. jokainen kuollut alkio, jolla on tasan 3 naapuria muuttuu eläväksi
        // taulukossa arvo 1 kuvaa elävää alkiota, arvo 0 kuollutta alkiota
        int[][] kopio = new int[this.taulukko.length][this.taulukko[0].length];
        
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[i].length; j++) {
                
                if (taulukko[i][j] == 1) {
                    if (elossaOleviaNaapureita(taulukko, i, j) < 2) {
                        kopio[i][j] = 0;
                    }
                    else if (elossaOleviaNaapureita(taulukko, i, j) > 3) {
                        kopio[i][j] = 0;
                    }
                    else {
                        kopio[i][j] = 1;
                        System.out.println("x:y: " + i + " " + j + " elossa: " + elossaOleviaNaapureita(taulukko, i, j));
                    }
                }
                else if (taulukko[i][j] == 0 && elossaOleviaNaapureita(taulukko, i, j) == 3) {
                    kopio[i][j] = 1;
                }
            }   
        }
        taulukko = kopio;
    }

    public int[][] getTaulukko() {
        return taulukko;
    }

    public void setTaulukko(int[][] taulukko) {
        this.taulukko = taulukko;
    }

    public int elossaOleviaNaapureita(int[][] taulukko, int x, int y) {
        int elossa = 0;
        if (x != 0 && y != 0) {
            if (taulukko[x - 1][y - 1] == 1) {
                elossa++;
            }
        }
        if (y != 0) {
            if (taulukko[x][y - 1] == 1) {
                elossa++;
            }
        }
        if (x < (taulukko[x].length - 1) && y != 0) {
            if (taulukko[x + 1][y - 1] == 1) {
                elossa++;
            }
        }
        if (x != 0) {
            if (taulukko[x - 1][y] == 1) {
                elossa++;
            }
        }
        if (x < (taulukko[x].length - 1)) {
            if (taulukko[x + 1][y] == 1) {
                elossa++;
            }
        }
        if (x != 0 && y < (taulukko[y].length - 1)) {
            if (taulukko[x - 1][y + 1] == 1) {
                elossa++;
            }
        }
        if (y < (taulukko[y].length - 1)) {
            if (taulukko[x][y + 1] == 1) {
                elossa++;
            }
        }
        if (x < (taulukko[x].length - 1) && y < (taulukko[y].length - 1)) {
            if (taulukko[x + 1][y + 1] == 1) {
                elossa++;
            }
        }   
        return elossa;
    }
}
