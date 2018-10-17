
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // toteuta tänne toiminnallisuus, jonka avulla käyttäjä voi syöttää
        // kirjoja sekä tarkastella niitä
        Scanner lukija = new Scanner(System.in);
        ArrayList<Kirja> kirjat = new ArrayList<>();
        
        while (true) {
            //System.out.print("Nimi: ");
            String nimi = lukija.nextLine();
            if (nimi.isEmpty()) {
                break;
            }
            //System.out.print("Sivuja: ");
            int sivuja = Integer.parseInt(lukija.nextLine());
            //System.out.print("Kirjoitusvuosi: ");
            int kirjoitusvuosi = Integer.parseInt(lukija.nextLine());
            Kirja kirja = new Kirja(nimi, sivuja, kirjoitusvuosi);
            kirjat.add(kirja);            
        }
        
        //System.out.print("\nMitä tulostetaan? ");
        String komento = lukija.nextLine();
        
        int i = 0;
        
        while (i < kirjat.size()) {
            Kirja kirja = kirjat.get(i);
            if (komento.equals("kaikki")) {
                System.out.println(kirja.toString());
            }
            
            if (komento.equals("nimi")) {
                System.out.println(kirja.getNimi());
            }
            i++;
        }
    }
}
