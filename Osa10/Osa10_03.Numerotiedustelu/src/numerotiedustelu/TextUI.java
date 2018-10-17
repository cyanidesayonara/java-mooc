/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerotiedustelu;

/**
 *
 * @author Santtu
 */
import java.util.*;

public class TextUI {
    private Scanner scanner;
    
    public TextUI(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void welcome() {
        System.out.println("numerotiedustelu");
        System.out.println("käytettävissä olevat komennot:");
        System.out.println("1 lisää numero");
        System.out.println("2 hae numerot");
        System.out.println("3 hae puhelinnumeroa vastaava henkilö");
        System.out.println("4 lisää osoite");
        System.out.println("5 hae henkilön tiedot");
        System.out.println("6 poista henkilön tiedot");
        System.out.println("7 filtteröity listaus");
        System.out.println("x lopeta");
    }
    
    public String command() {
        System.out.print("\nkomento: ");
        return scanner.nextLine();
    }
    
    public String[] addNumber() {
        String[] number = new String [2];
        System.out.print("kenelle: ");
        number[0] = scanner.nextLine();
        System.out.print("numero: ");
        number[1] = scanner.nextLine();
        return number;
    }
    
    public String askName() {
        System.out.print("kenen: ");
        return scanner.nextLine();
    }
    
    public String askNameDel() {
        System.out.print("kenet: ");
        return scanner.nextLine();
    }
    
    public String askNumber() {
        System.out.print("numero: ");

        return scanner.nextLine();
    }
    
    public String[] addAddress() {
        String[] address = new String[2];
        System.out.print("kenelle: ");
        address[0] = scanner.nextLine();
        System.out.print("katu: ");
        address[1] = scanner.nextLine();
        System.out.print("kaupunki: ");
        address[1] += " " + scanner.nextLine();
        return address;
    }
    
    public String askKeyword() {
        System.out.print("hakusana (jos tyhjä, listataan kaikki): ");
        return scanner.nextLine();
    }

}
