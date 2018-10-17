
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        
        // Tee tänne koodia jolla testaat että YlhaaltaRajoitettuLaskuri toimii halutulla tavalla
        // muista kuitenkin pyyhkiä ylimääräinen koodi pois tehtävän viimeisissä osissa ja käyttää 
        // tehtävänannossa ehdotettua koodirunkoa
        Scanner lukija = new Scanner(System.in);
        
        YlhaaltaRajoitettuLaskuri sekunnit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri minuutit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri tunnit = new YlhaaltaRajoitettuLaskuri(23);

        System.out.print("sekunnit: ");
        int sek = Integer.parseInt(lukija.nextLine());
        System.out.print("minuutit: ");
        int min = Integer.parseInt(lukija.nextLine());
        System.out.print("tunnit: ");
        int tun = Integer.parseInt(lukija.nextLine());

        sekunnit.asetaArvo(sek);
        minuutit.asetaArvo(min);
        tunnit.asetaArvo(tun);

        int i = 0;
        while (i < 121) {
            System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);   // tulostetaan nykyinen aika
            // minuuttimäärä kasvaa
            // jos minuuttimäärä menee nollaan, tuntimäärä kasvaa
            if (minuutit.getArvo() == minuutit.getYlaraja() && sekunnit.getArvo() == sekunnit.getYlaraja()) {
                minuutit.seuraava();
                tunnit.seuraava();
            } else if (sekunnit.getArvo() == sekunnit.getYlaraja()) {
                minuutit.seuraava();
                
            }
            sekunnit.seuraava();

            i++;
        }
    }
}
