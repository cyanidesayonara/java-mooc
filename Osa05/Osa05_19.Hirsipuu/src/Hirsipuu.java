
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hirsipuu {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> kirjaimet = new ArrayList<>();
        ArrayList<String> arvatut = new ArrayList<>();

        System.out.print("Mitä merkkijonoa arvataan? ");
        String jono = lukija.nextLine();
        
        int arvaukset = 9;
        int laskuri = 0;
        
        int i = 0;
        while (i < jono.length()) {
            String kirj = "" + jono.charAt(i);
            kirjaimet.add(kirj);
            i++;
        }
            
        ArrayList<Kirjain> kirjain =
                kirjaimet.stream()
                    .map(k -> new Kirjain(k))
                    .filter(k -> !k.equals(" "))
                    .collect(Collectors.toCollection(ArrayList::new));
                      
        while (true) {
            System.out.print("Sana:");
            
            int j = 0;
            while (j < kirjain.size()) {
                Kirjain k = kirjain.get(j);   
                System.out.print(" " + k.getKirjain());
                j++;
            }

            System.out.println("\nArvauksia jäljellä: " + arvaukset);
            System.out.print("Arvatut:");
            
            j = 0;
            while (j < arvatut.size()) {
                System.out.print(" " + arvatut.get(j));
                j++;
            }
            
            System.out.print("\nArvaus: ");
            String arvaus = lukija.nextLine();
            
            if (arvatut.contains(arvaus)) {
                System.out.println("\nOlet arvannut jo kyseisen merkin!");
            }
            
            if (arvaus.length() != 1) {
                System.out.println("Syötä yksi (1) kirjain!");
            } else {

                j = 0;

                int bool = 0;

                while (j < kirjain.size()) {

                    Kirjain k = kirjain.get(j);   
                    if (arvaus.equals(k.getArvo())) {
                        k.switchKirjain();
                        laskuri++;
                        bool = 1;
                    }
                    j++;
                }
                if (!arvatut.contains(arvaus)) {
                    if (bool == 0) {
                        arvaukset--;
                    }
                    arvatut.add(arvaus);
                }
            }
        System.out.println("");
        if (arvaukset == 0) {
            System.out.println("Hävisit!");
            break;
        }
        if (laskuri == kirjain.size()) {
            System.out.println("Voitit!");
            break;
        }
        }
    }
}
