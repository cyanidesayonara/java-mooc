
import java.util.Scanner;

public class KolmeEnsimmaistaKirjainta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna nimi: ");
        String nimi = lukija.nextLine();
        
        if (nimi.length() > 2) {
            int i = 0;
            while(i < 3) {
                System.out.println((i + 1) + ". kirjain: " + nimi.charAt(i));
                i++;
            }
        }
    }
}
