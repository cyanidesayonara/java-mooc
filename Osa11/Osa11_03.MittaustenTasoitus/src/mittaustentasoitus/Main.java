package mittaustentasoitus;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        List<Henkilo> henkilot = new ArrayList();
        henkilot.add(new Henkilo("Jaska", 1.48, 135.7, 95));
        henkilot.add(new Henkilo("Jaska", 1.48, 135.7, 102));
        henkilot.add(new Henkilo("Jaska", 1.48, 135.7, 98));
        henkilot.add(new Henkilo("Jaska", 1.48, 135.7, 88));
        henkilot.add(new Henkilo("Jaska", 1.48, 135.7, 105));
        
        MittaustenTasoittaja1 mt1 = new MittaustenTasoittaja1();
        System.out.println(mt1.tasoita(henkilot));
        MittaustenTasoittaja2 mt2 = new MittaustenTasoittaja2();
    }

}
