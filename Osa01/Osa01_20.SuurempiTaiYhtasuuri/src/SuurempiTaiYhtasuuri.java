
import java.util.Scanner;

public class SuurempiTaiYhtasuuri {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna ensimmäinen luku: ");
        int eka = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Anna toinen luku: ");
        int toka = Integer.parseInt(lukija.nextLine());
        
        if (eka > toka) {
            System.out.println("\nSuurempi luku: "+ eka);            
        } else if (eka < toka) {
            System.out.println("\nSuurempi luku: "+ toka);
        } else {
            System.out.println("\nLuvut ovat yhtä suuret!");
        }
    }
}
