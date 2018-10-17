
import java.util.ArrayList;
import java.util.Scanner;

public class FillarointiaBaanallaOsa2 {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);


        TiedostonLukija tiedLukija = new TiedostonLukija();
        ArrayList<String> pyorailijat = tiedLukija.lueTiedosto("helsingin-pyorailijamaarat.csv");

        String vuosi = lukija.nextLine();
        String kuu = lukija.nextLine();
        
        double keskiarvo
                = pyorailijat.stream()
                        .map(merkkijono -> merkkijono.split(";"))
                        .filter(taulukko -> taulukko[0].contains(vuosi))
                        .filter(taulukko -> taulukko[0].contains(kuu))
                        .filter(taulukko -> !taulukko[16].isEmpty())
                        .mapToInt(taulukko -> Integer.parseInt(taulukko[16]))
                        .average().getAsDouble();

        System.out.println();
        System.out.println("Pyöräilijöitä keskimäärin tunnissa: " + keskiarvo);
        System.out.println("Pyöräilijöitä keskimäärin päivässä: " + (24.0 * keskiarvo));
    }
}
