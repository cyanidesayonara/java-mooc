
import java.util.ArrayList;
import java.util.Scanner;

public class Peltipoliisit {

    public static void main(String[] args) {
        ArrayList<Lista> lista = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);
        
        int j = 0;
        while(true) {
            String input = lukija.nextLine();
            if(input.equals("")) {
                break;
            } else {

                String[] split = input.split(";");
                
                String rek = split[0];
                int nopeus = Integer.parseInt(split[1]);
                
                lista.add(new Lista(rek, nopeus));
            }
        }

        Lista eka = lista.get(0);
        int sum = eka.haeNopeus();
        int pienin = eka.haeNopeus();
        int suurin = eka.haeNopeus();
        String rek1 = eka.haeRekkari();
        String rek2 = eka.haeRekkari();
        int i = 1;
        while(i < lista.size()) {
            Lista seuraava = lista.get(i);
            sum += seuraava.haeNopeus();
            
            if(seuraava.haeNopeus() > suurin) {
                suurin = seuraava.haeNopeus();
                rek1 = seuraava.haeRekkari();
            }
            i++;
        }
        i = 1;
        while(i < lista.size()) {
            Lista seuraava = lista.get(i);
                        
            if(seuraava.haeNopeus() < pienin) {
                pienin = seuraava.haeNopeus();
                rek2 = seuraava.haeRekkari();
            }
            i++;
        }
        System.out.println("Suurin: " + rek1 + ", " + suurin);
        System.out.println("Pienin: " + rek2 + ", " + pienin);
        System.out.println("Keskiarvo: " + (double) sum / lista.size());
    }
}
