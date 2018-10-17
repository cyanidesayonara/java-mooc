/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lentokentta.ui;

/**
 *
 * @author Santtu
 */
import java.util.Scanner;

public class Text implements UI {
    private Scanner scanner;
    
    public Text(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void welcome() {
        System.out.println("Lentokentän hallinta");
        System.out.println("--------------------\n");
    }
    
    @Override
    public String airportControl() {
        System.out.println("Valitse toiminto:");
        System.out.println("[1] Lisää lentokone");
        System.out.println("[2] Lisää lento");
        System.out.println("[x] Poistu hallintamoodista");
        System.out.print("> ");
        return scanner.nextLine();
    }
    
    public String[] addPlane() {
        String[] plane = new String[2];
        System.out.print("Anna lentokoneen tunnus: ");
        plane[0] = scanner.nextLine();
        System.out.print("Anna lentokoneen kapasiteetti: ");
        plane[1] = scanner.nextLine();
        return plane;
    }
    
    public String[] addFlight() {
        String[] flight = new String[3];
        System.out.print("Anna lentokoneen tunnus: ");
        flight[0] = scanner.nextLine();
        System.out.print("Anna lähtöpaikan tunnus: ");
        flight[1] = scanner.nextLine();
        System.out.print("Anna kohdepaikan tunnus: ");
        flight[2] = scanner.nextLine();
        return flight;
    }
    
    public void header() {
        System.out.println("\nLentopalvelu");
        System.out.println("--------------------\n");
    }
    
    @Override
    public String flightService() {
        System.out.println("Valitse toiminto:");
        System.out.println("[1] Tulosta lentokoneet");
        System.out.println("[2] Tulosta lennot");
        System.out.println("[3] Tulosta lentokoneen tiedot");
        System.out.println("[x] Lopeta");
        System.out.print("> ");
        return scanner.nextLine();
    }
    
    public String printPlane() {
        System.out.print("Mikä kone: ");
        return scanner.nextLine();
    }
}
