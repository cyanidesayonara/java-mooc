
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // voit tehdä testikoodia tänne
        // poista kaikki ylimääräinen koodi kuitenkin tehtävän viimeisiä osia tehdessäsi

        // Jotta testi toimisi, on oliot luotava pääohjelmassa oikeassa järjestyksessä 
        //  eli ensin kaikkien summan laskeva olio, toisena parillisten summan laskeva 
        //  ja viimeisenä parittomien summan laskeva olio)!
        Lukutilasto tilasto1 = new Lukutilasto();
        Lukutilasto tilasto2 = new Lukutilasto();
        Lukutilasto tilasto3 = new Lukutilasto();
        //tilasto.lisaaLuku(3);
        //tilasto.lisaaLuku(5);
        //tilasto.lisaaLuku(1);
        //tilasto.lisaaLuku(2);
        
        System.out.println("Anna lukuja");
        
        while (true) {
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == -1) {
                System.out.println("Summa: " + tilasto1.summa());
                System.out.println("Parillisten summa: " + tilasto2.summa());
                System.out.println("Parittomien summa: " + tilasto3.summa());
                break;
            } else if (luku % 2 == 0) {
                tilasto1.lisaaLuku(luku);
                tilasto2.lisaaLuku(luku);
            } else if (luku % 2 != 0) {
                tilasto1.lisaaLuku(luku);
                tilasto3.lisaaLuku(luku);
            }
        }
    }
}
