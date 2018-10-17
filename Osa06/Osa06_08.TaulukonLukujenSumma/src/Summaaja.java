
public class Summaaja {

    public int laskeTaulukonLukujenSumma(int[] taulukko) {
        int sum = 0;
        for (int i = 0; i < taulukko.length; i++)
        {
            sum += taulukko[i];
        }
        return sum;
    }
}
