
import java.util.Scanner;

public class LukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Mihin asti? ");
        int asti = Integer.parseInt(lukija.nextLine());
        int i = 0;
        int sum = 0;
        
        while (i < asti) {
            sum += i + 1; 
            i++;
        }
        System.out.println("Summa on: " + sum);
    }
}
