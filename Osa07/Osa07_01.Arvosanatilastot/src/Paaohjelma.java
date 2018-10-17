import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Arvosanat arvosanat = new Arvosanat();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija, arvosanat);
        kayttoliittyma.kaynnista();
    }
}
