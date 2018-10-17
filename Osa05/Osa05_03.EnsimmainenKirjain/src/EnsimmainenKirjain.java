
import java.util.Scanner;

public class EnsimmainenKirjain {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna nimi: ");
        String nimi = lukija.nextLine();
        System.out.println("Ensimmäinen kirjain: " + nimi.charAt(0));
    }
}
