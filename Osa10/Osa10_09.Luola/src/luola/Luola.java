/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

/**
 *
 * @author Santtu
 */
import java.util.*;

public class Luola {
    private int leveys;
    private int korkeus;
    private int hirvioita;
    private int siirtoja;
    private boolean hirviotLiikkuvat;
    private Random random;
    private List<Hahmo> hirviot;
    private Hahmo pelaaja;

    public Luola(int leveys, int korkeus, int hirvioita, int siirtoja, boolean hirviotLiikkuvat) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.hirvioita = hirvioita;
        this.siirtoja = siirtoja;
        this.hirviotLiikkuvat = hirviotLiikkuvat;
        hirviot = new ArrayList();
        random = new Random();
    }

    
    public void run(Scanner lukija) {
        luoPelaaja();
        luoHirviot();
        while (true) {
            System.out.println(siirtoja + "\n");
            tulostaKoordinaatit();
            tulostaLuola();
            String liikkeet = lukija.nextLine();
            for (int i = 0; i < liikkeet.length(); i++) {
                pelaaja.liiku(liikkeet.charAt(i));
                hirviotLiikkuu();
                tallaaHirviot();
            } 
            if (hirviot.isEmpty()) {
                System.out.println("VOITIT");
                break;
            }
            siirtoja--;
            if (siirtoja == 0) {
                System.out.println("HÄVISIT");
                break;
            }
        }
        
    }
    
    public void luoPelaaja() {
        pelaaja = new Hahmo(0, 0, '@', leveys, korkeus);
    }
    
    public void luoHirviot() {
        for (int i = 0; i < hirvioita; i++) {
            while (true) {
                Hahmo hirvio = new Hahmo(1 + random.nextInt(leveys - 2),
                    1 + random.nextInt(korkeus - 2), 'h',
                    leveys, korkeus);
                if (!hirviot.contains(hirvio)) {
                    hirviot.add(hirvio);
                    break;
                }
            }
        }
    }
    
    public void tulostaKoordinaatit() {
        System.out.println(pelaaja);
        hirviot.stream().forEach(h -> System.out.println(h));
        System.out.println("");
    }
    
    public void tulostaLuola() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j ++) {
                boolean tulostaHahmo = false;
                for (int k = 0; k < hirviot.size(); k++) {
                    if (hirviot.get(k).onKoordinaateissa(j, i)) {
                        System.out.print(hirviot.get(k).getMerkki());
                        tulostaHahmo = true;
                        break;
                    }
                }
                if (pelaaja.onKoordinaateissa(j, i)) {
                    System.out.print(pelaaja.getMerkki());
                    tulostaHahmo = true;
                }
                if (!tulostaHahmo) {
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
    
    public void hirviotLiikkuu() {
        if (hirviotLiikkuvat) {
            for (int j = 0; j < hirviot.size(); j++) {
                int uusiXY[] = hirviot.get(j).liiku(random);
                Hahmo uusiHirvio = new Hahmo(uusiXY[0], uusiXY[1], 'h', leveys, korkeus);
                if (!hirviot.contains(uusiHirvio)) {      
                    hirviot.set(j, uusiHirvio);
                }
            }
        }
    }
    
    public void tallaaHirviot() {
        for (int k = 0; k < hirviot.size(); k++) {
            if (pelaaja.onSamassaRuudussa(hirviot.get(k))) {
                hirviot.remove(k);
                break;
            }
        }
    }
}
