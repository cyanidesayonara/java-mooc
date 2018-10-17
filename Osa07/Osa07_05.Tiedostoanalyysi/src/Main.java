
public class Main {

    public static void main(String[] args) {
        // testaa luokkasi toimintaa täällä

        String tiedosto = "src/testitiedosto.txt";
        
        Analyysi analyysi = new Analyysi(tiedosto);
        System.out.println("Rivejä: " + analyysi.rivimaara());
        System.out.println("Merkkejä: " + analyysi.merkkeja());
    }
}
