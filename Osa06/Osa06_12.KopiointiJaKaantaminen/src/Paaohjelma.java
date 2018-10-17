import java.util.Arrays;

public class Paaohjelma {

    public static void main(String[] args) {
    int[] alkuperainen = {1, 2, 3, 4};
    int[] kaannetty = new Taulukot().kaanna(alkuperainen);

    // tulostetaan molemmat
    System.out.println("alkup: " +Arrays.toString(alkuperainen));
    System.out.println("käännetty: " +Arrays.toString(kaannetty));
    }
}
