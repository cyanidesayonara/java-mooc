
public class Paaohjelma {

    public static void main(String[] args) {

        String lahdeTiedosto = "src/eka.txt";
        String kohdeTiedosto = "src/eka-out.txt";
        // kaikki sanat tiedostossa src/sanalista.txt

        // Voit kokeilla sensurointia seuraavalla esimerkillä kun olet
        // toteuttanut luokan Sensuroija
        Sensuroija sensuroija = new Sensuroija("sana1");
        sensuroija.sensuroi(lahdeTiedosto, kohdeTiedosto);
    }
}
