
import java.util.ArrayList;
import java.util.Scanner;

public class LuettujenArvojenTulostaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add(lukija.nextLine());
        lista.add(lukija.nextLine());
        lista.add(lukija.nextLine());
        
        lista.stream().forEach(arvo ->
            System.out.println(arvo)
        );
    }
}
