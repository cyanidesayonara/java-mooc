
import java.util.Scanner;

public class Orwell {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. 
        System.out.print("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        
        if (luku == 1984){
            System.out.println("\nOrwell");
        }
    }
}
