import java.util.Scanner;

public class Tekstikayttoliittyma {
    private Scanner lukija;
    private Sanakirja sanakirja;
    
    public Tekstikayttoliittyma(Scanner lukija, Sanakirja sanakirja) {
        this.lukija = lukija;
        this.sanakirja = sanakirja;
    }
    
    public void kaynnista() {
        System.out.println("Komennot:");
        System.out.println("  lisaa - lisää sanaparin sanakirjaan");
        System.out.println("  kaanna - kysyy sanan ja tulostaa sen käännöksen");
        System.out.println("  lopeta - poistuu käyttöliittymästä\n");
        komento();
    }
    
    public void komento() {
        while (true) {
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                System.out.println("Hei hei!");
                break;
            } else if (komento.equals("lisaa")) {
                System.out.print("Suomeksi: ");
                String suomeksi = lukija.nextLine();
                System.out.print("Käännös: ");
                String kaannos = lukija.nextLine();
                lisaa(suomeksi, kaannos);
                System.out.println("");
            } else if (komento.equals("kaanna")) {
                System.out.print("Anna sana: ");
                String sana = lukija.nextLine();
                System.out.println("Käännös: " + kaanna(sana));
                System.out.println("");
            } else {
                System.out.println("Tuntematon komento.\n");
            }
        }
    }
    
    public void lisaa(String sana, String kaannos) {
        sanakirja.lisaa(sana, kaannos);
    }
    
    public String kaanna(String sana) {
        return sanakirja.kaanna(sana);
    }
}  