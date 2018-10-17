
public class KaikkiPINKoodit {

    public static void main(String[] args) {
        // Kirjoita tänne ohjelma joka tulostaa kaikki PIN-koodit
        for (int i = 0; i <= 9999; i++) {
            System.out.format("%04d", i);
            System.out.println("");
        }
    }
}
