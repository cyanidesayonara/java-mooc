/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surface
 */
public class Lukutulostin {
    
    public void lukuporras(int luku) {
        int i = 1;
        while(i <= luku) {
            int j = 1;
            while(j <= i) {
                System.out.print(j + " ");
                j++;
            }
        System.out.println();
        i++;
        }
    }
    
    public void jatkuvaLukuporras(int luku) {
        int i = 1;
        int j = 1;
        while(i <= luku) {
            int k = 1;
            while(k <= i) {
                System.out.print(j + " ");
                j++;
                k++;
            }
        System.out.println();
        i++;
        }
    }
    
    public void kertokolmio(int luku) {
        int i = 1;
        while(i <= luku) {
            int j = 1;
            while(j <= i) {
                System.out.print(j * i + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
