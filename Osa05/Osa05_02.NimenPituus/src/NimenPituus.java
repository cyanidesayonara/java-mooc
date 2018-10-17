
import java.util.Scanner;

public class NimenPituus {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna nimi: ");
        String nimi = lukija.nextLine();
        System.out.println("Kirjainmäärä: " + nimi.length());
    }

}
