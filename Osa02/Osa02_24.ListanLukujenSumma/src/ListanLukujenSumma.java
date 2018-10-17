
import java.util.ArrayList;
import java.util.Scanner;

public class ListanLukujenSumma {

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
        int i = 0;
        int sum = 0;
        
        while (i < lista.size()) {
            sum += lista.get(i);
            i++;
        }
        System.out.println("Summa: " + sum);
    }
}
