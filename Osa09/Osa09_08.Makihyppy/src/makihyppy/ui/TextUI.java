/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy.ui;

/**
 *
 * @author Santtu
 */
import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    
    public TextUI(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void welcome() {
        System.out.println("Kumpulan mäkiviikot\n");
        System.out.println("Syötä kilpailun osallistujat yksi kerrallaan, " +
                            "tyhjällä merkkijonolla siirtyy hyppyvaiheeseen.");
    }
    
    public String jumpers() {
        System.out.print("  Osallistujan nimi: ");
        String jumper = scanner.nextLine();
        return jumper;
    }
    
    public void intro() {
        System.out.println("\nKilpailu alkaa!\n");
    }
    
    public String select() {
        System.out.print("Kirjoita \"hyppaa\" niin hypätään, muuten lopetetaan: ");
        String command = scanner.nextLine();
        return command;
    }
    
    public void round(int round) {
        System.out.println("\n" + round + ". kierros\n");
        System.out.println("Hyppyjärjestys:");
    }
    
    public void end() {
        System.out.println("\nKiitos!\n");
        System.out.println("Kilpailun lopputulokset:");
        System.out.println("Sija    Nimi");
    }

}
