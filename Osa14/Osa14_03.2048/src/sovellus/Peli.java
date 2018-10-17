package sovellus;

import java.util.Scanner;

public class Peli {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tekstikayttoliittyma tkl = new Tekstikayttoliittyma(sc);
        Peliruudukko ruudukko = new Peliruudukko();
        while (ruudukko.peliKaynnissa()) {
            tkl.piirra(ruudukko.getTaulukko());
            char x = tkl.komento();
            if (x == 'x') {
                break;
            }
            switch (x) {
                case 'o':
                    ruudukko.siirraOikealle();
                    break;
                case 'v':
                    ruudukko.siirraVasemmalle();
                    break;
                case 'y':
                    ruudukko.siirraYlos();
                    break;
                case 'a':
                    ruudukko.siirraAlas();
                    break;
            }
            ruudukko.lisaa();
        }   
    }
}
