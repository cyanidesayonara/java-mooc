
import java.util.Scanner;

public class KelvollistenLukujenSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int sum = 0;
                
        while (true) {
            System.out.print("Syötä luku: ");
            int luettu = Integer.parseInt(lukija.nextLine());
             
            if (luettu == 9999) {
                break;
            } 
            
            if (luettu >= -140 && luettu <= 20) {
                sum += luettu;
                continue;
            }
             
            System.out.println("Kelvoton luku");     
        }
        System.out.println("Kelvollisten lukujen summa: " + sum);
    }
}
