
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Tässä voit testata metodia
        int[] taulukko = {5, 1, 3, 4, 2};
        System.out.println(Arrays.toString(taulukko));
        new LukujenKasvattaja().kasvata(taulukko, 3);
        System.out.println(Arrays.toString(taulukko));

    }

}
