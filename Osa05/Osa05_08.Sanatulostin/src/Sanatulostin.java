/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
public class Sanatulostin {
    private String sana;
    
    public Sanatulostin(String input) {
        sana = input;
    }
    
    public void sanaporras(int luku) {
        int i = 1;
        int j = 0;
        while(i <= luku) {
            int k = 1;
            while(k <= i) {
                if (j == sana.length()) {
                    j = 0;
                }
                System.out.print(sana.charAt(j));
                j++;
                k++;
            }
        System.out.println();
        i++;
        }
    }
    
    public void laskevaSanaporras(int luku) {
        int i = 1;
        int j = 0;
        while(i <= luku) {
            int k = luku;
            while(k >= i) {
                if (j == sana.length()) {
                    j = 0;
                }
                System.out.print(sana.charAt(j));
                j++;
                k--;
            }
        System.out.println();
        i++;
        }
    }
    
    public void sanapyramidi(int luku) {
        int i = 1;
        int j = 0;
        while(i <= luku) {
            int k = 1;
            while(k <= i) {
                
                if (j == sana.length()) {
                    j = 0;
                }
                System.out.print(sana.charAt(j));
                j++;
                k++;
                
            }
            System.out.println();
            i++;
            if (k == luku) {
                i = 1;
                while(i <= luku) {
                    k = luku;
                    while(k >= i) {
                        if (j == sana.length()) {
                            j = 0;
                        }
                        System.out.print(sana.charAt(j));
                        j++;
                        k--;
                    }
                System.out.println();
                i++;
                }
            }
        }
    }
}
