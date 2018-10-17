

public class Tulostin {

    public void tulostaTaulukkoTahtina(int[] taulukko) {
        // Kirjoita tulostuskoodi tänne
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
