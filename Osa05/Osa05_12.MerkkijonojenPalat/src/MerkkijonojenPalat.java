
import java.util.Scanner;

public class MerkkijonojenPalat {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        String lause = lukija.nextLine();
        
        String[] sanat = lause.split(" ");
        
        int i = 0;
        while(i < sanat.length) {
            String sana = sanat[i];
            System.out.println(sana);
            i++;
        }
    }
}
