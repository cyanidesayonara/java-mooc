
import java.util.Scanner;

public class MihinJaMista {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // KIRJOITA OHJELMASI TÄNNE
        System.out.print("Mihin asti? ");
        int asti = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Mistä lähtien? ");
        int lahti = Integer.parseInt(lukija.nextLine());

        
        while (lahti <= asti) {
            System.out.println(+ lahti);
            lahti++;
        }   
    }
}
