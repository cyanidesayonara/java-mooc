
import java.util.ArrayList;
import java.util.Scanner;

public class ListanSuurinLuku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<Integer> lista = new ArrayList<>();
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == -1) {
                break;
            }

            lista.add(luettu);
        }
        
        System.out.println("");

        // toteuta listan lukujen summan laskeminen tänne
        int suurin = lista.get(0);
        int i = 0;
        
        while (i < lista.size()) {
            int luku = lista.get(i);
            if (suurin < luku) {
                suurin = luku;
            }
            i++;
        }
        System.out.println("Listan suurin luku: " + suurin);
    }
}
