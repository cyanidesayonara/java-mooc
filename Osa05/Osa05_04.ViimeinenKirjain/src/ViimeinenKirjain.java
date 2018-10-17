
import java.util.Scanner;

public class ViimeinenKirjain {


    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna nimi: ");
        String nimi = lukija.nextLine();
        System.out.println("Viimeinen kirjain: " + nimi.charAt(nimi.length() - 1));
    }
}
