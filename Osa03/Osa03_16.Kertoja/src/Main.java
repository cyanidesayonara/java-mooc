
public class Main {

    public static void main(String[] args) {
        // Tämä on vain tyhjä main-metodi jossa voit kokeilla luokkasi toimintaa.
        // esimerkiksi: 

        Kertoja kolmellaKertoja = new Kertoja(3);

        System.out.println("kolmellaKertoja.kerro(2): " + kolmellaKertoja.kerro(2));

        Kertoja neljallaKertoja = new Kertoja(4);

        System.out.println("neljallaKertoja.kerro(2): " + neljallaKertoja.kerro(2));
        System.out.println("kolmellaKertoja.kerro(1): " + kolmellaKertoja.kerro(1));
        System.out.println("neljallaKertoja.kerro(1): " + neljallaKertoja.kerro(1));
    }
}
