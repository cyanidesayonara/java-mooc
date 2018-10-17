
import java.util.Scanner;

public class Arvauspeli {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int arvattava = 7;

        System.out.println("Minäpä tiedän luvun väliltä 1-10, jota sinä et tiedä!");
        
        int i = 0;

        while (true) {
            System.out.print("Arvaa luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            
            if (luku == 7) {
                i++;
                break;
            }
            
            if (luku >0 && luku <= 10) {
                i++;
                System.out.println("Ei ollut!");
            }
            
            System.out.println("Epäkelpo luku!");
        }
        System.out.println("Oikein! Arvauksia yhteensä: " + i);
    }
}
