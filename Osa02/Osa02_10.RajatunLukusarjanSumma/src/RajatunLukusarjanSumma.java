
import java.util.Scanner;

public class RajatunLukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Ensimmäinen: ");
        int eka = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Viimeinen: ");
        int vika = Integer.parseInt(lukija.nextLine());
        
        int i = 0;
        int sum = 0;
        
        while (eka + i <= vika) {
            sum += eka + i;
            i++;
        }
        System.out.println("Summa on: " + sum);
    }
}
