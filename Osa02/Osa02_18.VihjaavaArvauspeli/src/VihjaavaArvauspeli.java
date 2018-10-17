
import java.util.Scanner;

public class VihjaavaArvauspeli {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int arvattava = 42;

        System.out.println("Minäpä tiedän luvun väliltä 1-100, jota sinä et tiedä!");
        
        int i = 0;

        while (true) {
            System.out.print("Arvaa luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            
            if (luku == 42) {
                i++;
                break;
            }
            
            if (luku >0 && luku <= 100) {
                i++;
                System.out.println("Ei ollut!");
                if (luku < 42) {
                    System.out.println("Lukuni on isompi!");
                } else {
                    System.out.println("Lukuni on pienempi!");
                }
            }
            
            System.out.println("Epäkelpo luku!");
        }
        System.out.println("Oikein! Arvauksia yhteensä: " + i);
    }
}
