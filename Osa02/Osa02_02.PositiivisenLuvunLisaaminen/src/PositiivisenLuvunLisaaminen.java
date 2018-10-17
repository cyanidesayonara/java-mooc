
import java.util.Scanner;

public class PositiivisenLuvunLisaaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int summa = Integer.parseInt(lukija.nextLine());
        
        int luettu = Integer.parseInt(lukija.nextLine());
        
        if (luettu > 0) {
            summa += luettu;
        }
        
        System.out.println("Summa: " + summa);
    }
}
