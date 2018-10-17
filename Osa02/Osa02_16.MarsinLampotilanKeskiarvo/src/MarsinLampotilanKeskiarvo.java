
import java.util.Scanner;

public class MarsinLampotilanKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int sum = 0;
        int i = 0;
                
        while (true) {
            System.out.print("Syötä luku: ");
            int luettu = Integer.parseInt(lukija.nextLine());
             
            if (luettu == 9999) {
                break;
            } 
            
            if (luettu >= -140 && luettu <= 20) {
                sum += luettu;
                i++;
                continue;
            }
             
            System.out.println("Kelvoton luku");     
        }
        System.out.println("Kelvollisten lukujen summa: " + ((double) sum / i));
    }
}
