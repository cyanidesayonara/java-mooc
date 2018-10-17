
import java.util.Scanner;

public class IkienSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän.
        System.out.print("Kerro nimi: ");
        String nimi1 = lukija.nextLine();
        
        System.out.print("Kerro ikä: ");
        int ika1 = Integer.parseInt(lukija.nextLine());
        
        System.out.print("\nKerro nimi: ");
        String nimi2 = lukija.nextLine();
        
        System.out.print("Kerro ikä: ");
        int ika2 = Integer.parseInt(lukija.nextLine());
        
        System.out.println("\n" + nimi1 + " ja " + nimi2 + " ovat yhteensä " + (ika1 + ika2) + " vuotta vanhoja.");
    }
}
