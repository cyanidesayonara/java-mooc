
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class LoytyykoTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Minkä niminen tiedosto luetaan? ");
        String tiedosto = lukija.nextLine();

        System.out.println("Mitä etsitään?");
        String etsittava = lukija.nextLine();

        ArrayList<String> rivit = new ArrayList<>();
        
        try {
            Files.lines(Paths.get(tiedosto)).forEach(rivi->rivit.add(rivi));
        } catch (Exception e) {
            System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
        }
        
        if (rivit.contains(etsittava)) {
            System.out.println("Löytyi!");
        } else if (!rivit.isEmpty()) {
            System.out.println("Ei löytynyt.");
        }
        
    }
}
