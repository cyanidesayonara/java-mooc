
import java.util.Scanner;

public class PositiivinenLuku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. 
        System.out.print("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        
        if (luku > 0){
            System.out.println("\nLuku on positiivinen.");
        } else {
            System.out.println("\nLuku ei ole positiivinen.");
        }
    }
}
