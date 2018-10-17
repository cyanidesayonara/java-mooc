package painoindeksi;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RaportinLuoja2 implements Raportoiva {
    Predicate<Double> alipaino = new PainoindeksiOnAlle(18.5);
    Predicate<Double> normaali = new Molemmat(
            new PainoindeksiOnAlle(25),
            new PainoindeksiOnYli(18.5)
    );
    Predicate<Double> ylipaino = new Molemmat(
            new PainoindeksiOnAlle(30),
            new PainoindeksiOnYli(25)
    );
    Predicate<Double> merkittava = new PainoindeksiOnYli(30);
    
    RaportinLuoja2() {
    }

    @Override
    public PainoindeksiRaportti painoindeksiRaportti(List<Henkilo> henkilotiedot) {
        List<String> alipainoiset = new ArrayList();
        List<String> normaalipainoiset = new ArrayList();
        List<String> ylipainoiset = new ArrayList();
        List<String> merkittavastiYlipainoiset = new ArrayList();
        
        // BINGO!
        
        alipainoiset = henkilotiedot.stream()
                .filter(h -> alipaino.test(h.getPaino() / (h.getPituus() * h.getPituus())))
                .map(h -> h.getNimi())
                .collect(Collectors.toList());
        normaalipainoiset = henkilotiedot.stream()
                .filter(h -> normaali.test(h.getPaino() / (h.getPituus() * h.getPituus())))
                .map(h -> h.getNimi())
                .collect(Collectors.toList());
        ylipainoiset = henkilotiedot.stream()
                .filter(h -> ylipaino.test(h.getPaino() / (h.getPituus() * h.getPituus())))
                .map(h -> h.getNimi())
                .collect(Collectors.toList());
        merkittavastiYlipainoiset = henkilotiedot.stream()
                .filter(h -> merkittava.test(h.getPaino() / (h.getPituus() * h.getPituus())))
                .map(h -> h.getNimi())
                .collect(Collectors.toList());
                
        PainoindeksiRaportti painoindeksiRaportti = new PainoindeksiRaportti(
                alipainoiset, normaalipainoiset, ylipainoiset, merkittavastiYlipainoiset);
        return painoindeksiRaportti;
    }
    
    

    
}
