/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.Scanner;

/**
 *
 * @author Santtu
 */
public class Tekstikayttoliittyma {
    Scanner sc;
    
    public Tekstikayttoliittyma(Scanner sc) {
        this.sc = sc;
    }
    
    public void piirra(int[][] taulukko) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(taulukko[i][j] + " ");
            }
            System.out.println(taulukko[i][3]);
        }
    }
    
    public char komento() {
        String kom;
        do {
            System.out.print("\n> ");
            kom = sc.next();
        } while (!kom.matches("o|v|y|a|x"));
        return kom.charAt(0);
    }
    
}
