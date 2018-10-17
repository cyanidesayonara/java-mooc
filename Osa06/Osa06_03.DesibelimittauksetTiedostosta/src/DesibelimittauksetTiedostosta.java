
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DesibelimittauksetTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Tiedosto? ");
        String tiedosto = lukija.nextLine();
        System.out.print("Alaraja? ");
        int alaraja = Integer.parseInt(lukija.nextLine());
        System.out.print("Yläraja? ");
        int ylaraja = Integer.parseInt(lukija.nextLine());
        
        try {
            long lukuja = Files.lines(Paths.get(tiedosto)).filter(rivi->Integer.parseInt(rivi) <= ylaraja && Integer.parseInt(rivi) >= alaraja).count();
            System.out.println("Lukuja: "+ lukuja);
        } catch (Exception e) {
            System.out.println("Virhe");
        }

    }

}
