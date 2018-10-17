
import java.util.ArrayList;
import java.util.Scanner;

public class FibonaccinLukujono {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(0);
        lista.add(1);
        
        // Toteuta tänne ohjelma, joka ensin laskee listalle 40 
        // ensimmäistä fibonaccin lukua. 
        
        // Tämän jälkeen ohjelma kysyy käyttäjältä lukuja, ja 
        // kertoo aina halutussa indeksissä olevan fibonaccin luvun.
        
        // Ohjelman suoritus päättyy kun käyttäjä syöttää luvun -1
        
        int i = 2;
        
        while (i < 40) {
            lista.add(lista.get(i - 1) + lista.get(i - 2));
            i++;
        }
          
        while (true) {
            System.out.print("Monesko luku? ");
            int mones = Integer.parseInt(lukija.nextLine());
            int j = 0;
            
            if (mones == -1) {
                break;
            }
            
            while (j < 40) {
                if (mones == j) {
                    System.out.println(lista.get(j));
                }
                j++;
            }
        }
        System.out.println("\nKiitos!");
    }
}
