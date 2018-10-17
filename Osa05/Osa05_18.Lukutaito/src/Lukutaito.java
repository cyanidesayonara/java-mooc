
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lukutaito {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        TiedostonLukija tiedLukija = new TiedostonLukija();
        ArrayList<String> luetut = tiedLukija.lueTiedosto("lukutaito.csv");
         
        double miehet = 
                luetut.stream()
                    .map(rivi -> rivi.split(","))
                    .filter(taulukko -> !taulukko[2].contains("female"))
                    .mapToDouble(taulukko -> Double.parseDouble(taulukko[5]))
                    .average()
                    .getAsDouble();
        
        double naiset =
                luetut.stream()
                    .map(rivi -> rivi.split(","))
                    .filter(taulukko -> taulukko[2].contains("female"))
                    .mapToDouble(taulukko -> Double.parseDouble(taulukko[5]))
                    .average()
                    .getAsDouble();
        
        ArrayList<Korkein> korkein =
                luetut.stream()
                    .map(rivi -> rivi.split(","))
                    .map(rivi -> new Korkein(rivi[3], Double.parseDouble(rivi[5])))
                    .collect(Collectors.toCollection(ArrayList::new));
        
        Korkein max = korkein.get(0);
        
        int i = 1;
        while (i < korkein.size()) {
            if (korkein.get(i).haeLukutaito() > max.haeLukutaito()) {
                max = korkein.get(i);
            }
            i++;
        }
        
        System.out.println("Miesten lukutaidon keskiarvo: " + miehet);
        System.out.println("Naisten lukutaidon keskiarvo: " + naiset);
        System.out.println("Korkein lukutaito on maassa: " + max.haeMaa());
    }
}
