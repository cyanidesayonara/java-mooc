package arviot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Testaa tunteikkaat elokuva-arviot ohjelmaa täällä

        // alla on valmiina annettuna tiedoston lukemiseen tarvittava koodi
        // alla on valmiina annettuna tiedoston lukemiseen tarvittava koodi
        List<String> rivit = new ArrayList<>();
        try {
            rivit = Files.lines(Paths.get("src/arviot-lyhyt-2.txt")).collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println("Tiedoston lukeminen epäonnistui.");
        }
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);

        Scanner lukija = new Scanner(System.in);

        System.out.println(arviot.lauseenTunne("great job"));
        
        while (true) {
            System.out.println("~~ Emo-tions ~~");
            System.out.println("");
            System.out.println("Komennot: ");
            System.out.println("[1] Sanan yleisyys");
            System.out.println("[2] Sanan tunne");
            System.out.println("[3] Lauseen tunne");
            System.out.println("[x] Lopeta");

            System.out.print("> ");
            String komento = lukija.nextLine();
            if (komento.equals("x")) {
                break;
            }

            System.out.println("Anna syöte: ");
            String syote = lukija.nextLine();

            if (komento.equals("1")) {
                System.out.println("Sana '" + syote + "' esiintyy " + arviot.sanojenLukumaara(syote) + " kertaa.");
            } else if (komento.equals("2")) {
                System.out.println("Sanan '" + syote + "' tunne on " + arviot.sananTunneMerkkijonona(syote) + " (ka. " + arviot.sananTunne(syote) + ")");
            } else if (komento.equals("3")) {
                System.out.println("Lauseen '" + syote + "' tunne on " + arviot.lauseenTunneMerkkijonona(syote) + " (ka. " + arviot.lauseenTunne(syote) + ")");
            }

            System.out.println("");
        }
    }

}
