import java.util.Scanner;

public class Kertoma {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        int i = 1;
        int tulo = 1;
        
        while (i < luku) {
            i++;
            tulo *= i;
        }
        
        System.out.println(tulo);
    }
}
