
import java.util.ArrayList;
import java.util.Scanner;

public class ListanLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // toteuta tänne ohjelma, joka ensin lukee käyttäjältä
        // lukuja listalle kunnes käyttäjä syöttää luvun -1.
        // ohjelma laskee tämän jälkeen listalla olevien lukujen
        // keskiarvon, ja tulostaa sen käyttäjän näkyville
        ArrayList<Integer> lista = new ArrayList<>();
        
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == -1) {
                break;
            }
            lista.add(luettu);
        }
        System.out.println("");
        
        int i = 0;
        int sum = 0;
        
        while (i < lista.size()) {
            sum += lista.get(i);
            i++;
        }
        System.out.println("Keskiarvo: " + ((double) sum / i));
    }
}
