package henkilot;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // tee tänne testikoodia
        List<Henkilo> henkilot = new ArrayList<Henkilo>();
        henkilot.add(new Opettaja("Ada Lovelace", "Korsontie 1 03100 Vantaa", 1200));
        henkilot.add(new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki"));

        new HenkiloTulostus().tulostaLaitoksenHenkilot(henkilot);
    }
}
