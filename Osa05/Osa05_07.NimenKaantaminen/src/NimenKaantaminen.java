
import java.util.Scanner;

public class NimenKaantaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Tee koodisi tänne
        System.out.print("Anna nimi: ");
        String nimi = lukija.nextLine();
        System.out.print("Väärinpäin: ");
        int i = nimi.length();
        while(i > 0) {
            System.out.print(nimi.charAt(i - 1));
            i--;
        }
        System.out.println();
    }
}
