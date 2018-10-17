
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // kokeile täällä suunnittelemiesi ja toteuttamiesi 
        // luokkien toimintaa
        Scanner lukija = new Scanner(System.in);
        Salaseura jasen0 = new Salaseura("Jaska", "swordfish");
        //Salaseura jasen1 = new Salaseura("Ville", "salasana");
        
        int jasenluku = 2;
        
        System.out.print("Nimi? ");
        String nimi = lukija.nextLine();
        System.out.print("Koodi? ");
        String koodi = lukija.nextLine();
              
        for (int i = 0; i < jasenluku; i++) { //jasen[i] ?!?!?!?
            if (jasen0.getNimi().equals(nimi) && jasen0.getKoodi().equals(koodi)) {
                System.out.println("Tere tulemast, " + jasen0.getNimi() + "!");
                jasen0.kaynti(); 
                System.out.println(jasen0.toString());
                
                if (jasen0.getKaynnit() % 10 == 0 && jasen0.getPalkinnot() <= 2) {
                    jasen0.palkinto();
                    System.out.println("Onneksi olkoon!");
                }
                i++;
            }
        }
    }
}
