
import java.util.ArrayList;
import java.util.Scanner;

public class PienimmanLuvunIndeksi {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // toteuta tänne ohjelma, joka lukee käyttäjältä lukuja
        // kunnes käyttäjä syöttää luvun 9999
        
        // tämän jälkeen ohjelma tulostaa pienimmän luvun
        // sekä sen indeksin -- pienin luku voi esiintyä
        // useammassa indeksissä
        
        ArrayList<Integer> lista = new ArrayList<>();
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == 9999) {
                break;
            }

            lista.add(luettu);
        }

        System.out.println("");

        int i = 0;
        int j = 0;
        int pienin = lista.get(0);
        
        while (i < lista.size()) {
            int luku = lista.get(i);
            
            if (pienin > luku) {
                pienin = luku;
            }
            i++;
        }
        System.out.println("Pienin luku on " + pienin);
        
        while (j < lista.size()) {
            int luku = lista.get(j);
            
            if (luku == pienin) {
                System.out.println("Pienin luku löytyy indeksistä " + j);
            }
            j++;
        }

    }
}
