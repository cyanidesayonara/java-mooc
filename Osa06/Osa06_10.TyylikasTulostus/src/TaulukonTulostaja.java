
public class TaulukonTulostaja {

    public void tulostaTyylikkaasti(int[] taulukko) {
        // Kirjoita koodia tänne
        for (int i = 0; i < taulukko.length - 1; i++) {
            System.out.print(taulukko[i] + ", ");
        }
        System.out.println(taulukko[taulukko.length - 1]);
    }
}
