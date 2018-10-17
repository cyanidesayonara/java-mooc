
import java.util.Scanner;

public class KolmenLuvunSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int summa = 0;

        // KIRJOITA OHJELMA TÄHÄN
        // ÄLÄ KÄYTÄ MUITA MUUTTUJIA KUIN lukija ja summa !
        System.out.print("Anna ensimmäinen luku: ");
        summa = summa + Integer.parseInt(lukija.nextLine());
        
        System.out.print("Anna toinen luku: ");
        summa = summa + Integer.parseInt(lukija.nextLine());
        
        System.out.print("Anna kolmas luku: ");
        summa = summa + Integer.parseInt(lukija.nextLine());
        
        System.out.println("Summa: " + summa);
    }
}
