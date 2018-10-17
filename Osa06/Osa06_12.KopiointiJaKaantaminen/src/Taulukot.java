
public class Taulukot {
    // HUOM! Älä lisää luokalle Taulukot oliomuuttujia
    public int[] kopioi(int[] taulukko) {
        int kopio[] = new int[taulukko.length];
        for (int i = 0; i < taulukko.length; i++) {
            kopio[i] = taulukko[i];
        }
        return kopio;
    }
    
    public int[] kaanna(int[] taulukko) {
        int kopio[] = new int[taulukko.length];
        for (int i = 0; i < taulukko.length; i++) {
            kopio[i] = taulukko[taulukko.length - i - 1];
        }
        return kopio;
    }

}
