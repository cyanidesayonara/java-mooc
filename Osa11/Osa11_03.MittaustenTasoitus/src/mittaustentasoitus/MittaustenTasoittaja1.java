package mittaustentasoitus;

import java.util.*;

public class MittaustenTasoittaja1 implements Tasoittava {
    
    public MittaustenTasoittaja1() {
        
    }

    public List<Double> tasoita(List<Henkilo> henkilotiedot) {
        
        List<Double> kopio =  new ArrayList(henkilotiedot.size());
        kopio.add((double) (henkilotiedot.get(0).getSyke()));
        for (int i = 1; i < henkilotiedot.size() - 1; i++) {
            kopio.add((double) (henkilotiedot.get(i - 1).getSyke() +
                        henkilotiedot.get(i).getSyke() +
                        henkilotiedot.get(i + 1).getSyke()) / 3);
        }
        kopio.add((double) (henkilotiedot.get(henkilotiedot.size() - 1).getSyke()));

        return kopio;
    }
}
