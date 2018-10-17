
import java.util.ArrayList;
import java.util.Scanner;

public class KysytynLuvunIndeksi {

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

        // toteuta tänne toiminnallisuus luvun etsimiseen
        System.out.print("Mitä etsitään? ");
        int haku = Integer.parseInt(lukija.nextLine());
        int i = 0;
        
        while (i < lista.size()) {
            int luku = lista.get(i);
            
            if (!lista.contains(haku)) {
                System.out.println("Lukua " + haku + " ei löydy.");
                break;
            }
            
            if (luku == haku) {
                System.out.println("Luku " + haku + " on indeksissä " + i);
            }
            i++;
        }

    }
}
