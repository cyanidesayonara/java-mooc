
import java.util.Scanner;

public class Laskin {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna ensimmäinen luku: ");
        int eka = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Anna toinen luku: ");
        int toka = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Anna operaatio: ");
        String ope = lukija.nextLine();
        
        if (ope.equals("+")) {
            System.out.println(eka + " " + ope + " " + toka + " = " + (eka + toka));
        } else if (ope.equals("-")) {
            System.out.println(eka + " " + ope + " " + toka + " = " + (eka - toka) );
        } else if (ope.equals("*")) {
            System.out.println(eka + " " + ope + " " + toka + " = " + (eka * toka) );
        } else if (ope.equals("/")) {
            System.out.println(eka + " " + ope + " " + toka + " = " + ((double) eka / toka) );
        }     
    }
}
