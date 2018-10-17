
import java.util.Scanner;

public class Debuggailua {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna merkkijono:");
        String merkkijono = lukija.nextLine();

        System.out.println("Anna luku:");
        int luku = Integer.parseInt(lukija.nextLine());

        for (int i = 0; i < merkkijono.length(); i++) {
            for (int k = 0; k < i % luku; k++) {
                System.out.print(" "); 
            }
            System.out.println(merkkijono.charAt(i));
        }
    }
}
