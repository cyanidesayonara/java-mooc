import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private Arvosanat arvosanat;
    
    public Kayttoliittyma(Scanner lukija, Arvosanat arvosanat) {
        this.lukija = lukija;
        this.arvosanat = arvosanat;
    }
    
    public void kaynnista() {
        System.out.println("Syötä yhteispisteet, -1 lopettaa:");
        while(true) {
            int pisteet = Integer.parseInt(lukija.nextLine());
            
            if (pisteet == -1) {
                break;
            }
            
            arvosanat.lisaa(pisteet);
        }
        System.out.println("Pisteiden keskiarvo (kaikki): " + arvosanat.pisteidenKA());
        System.out.println("Pisteiden keskiarvo (hyväksytyt: " + arvosanat.hyvaksyttyjenPisteidenKA());
        System.out.println("Hyväksymisprosentti: " + arvosanat.hyvaksymisProsentti());
        arvosanat.arvosanaJakauma();
    }
}
