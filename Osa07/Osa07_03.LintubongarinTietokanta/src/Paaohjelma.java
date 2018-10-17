import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        // HUOM! Älä luo ohjelmassa muita Scanner-olioita. Jos ja toivottavasti
        // kun teet muita luokkia, anna allaoleva Scanner-olio niille
        // tarvittaessa parametrina.
        
        Scanner lukija = new Scanner(System.in);
        Havainnot havainnot = new Havainnot();
        Lintukirja linnut = new Lintukirja();
        Kontrolleri kontrolleri = new Kontrolleri(lukija, havainnot, linnut);
        
        while (true) {
            System.out.print("? ");
            kontrolleri.lueKomento();
            if (kontrolleri.onOff() == 0) {
                break;
            }
        }
    }
}
