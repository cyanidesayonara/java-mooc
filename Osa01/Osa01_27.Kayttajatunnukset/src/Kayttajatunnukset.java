
import java.util.Scanner;

public class Kayttajatunnukset {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna tunnus: ");
        String tun = lukija.nextLine();
        
        System.out.print("Anna salasana: ");
        String sal = lukija.nextLine();
        
        if (tun.equals("aleksi") && sal.equals("tappara")) {
            System.out.println("Hei " + tun + ", olet kirjatunut järjestelmään");
        }   else if (tun.equals("elina") && sal.equals("kissa")) {
            System.out.println("Hei " + tun + ", olet kirjatunut järjestelmään");
        } else {
            System.out.println("Virheellinen tunnus tai salasana!");
        }
        
    }
}
