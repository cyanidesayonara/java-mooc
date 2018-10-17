

public class Paaohjelma {

    public static void main(String[] args) {
        // testaa luokkasi toimintaa täällä

        String tiedosto = "src/sanalista.txt";
        // kaikki sanat tiedostossa src/sanalista.txt

        Sanatutkimus sanatutkimus = new Sanatutkimus(tiedosto);
        System.out.println(sanatutkimus.sanojenMaara());
        System.out.println(sanatutkimus.kirjaimenZSisaltavatSanat());
        System.out.println(sanatutkimus.kirjaimeenNPaattyvatSanat());
        System.out.println(sanatutkimus.palindromit());
        System.out.println(sanatutkimus.kaikkiVokaalitSisaltavatSanat());
    }
}
