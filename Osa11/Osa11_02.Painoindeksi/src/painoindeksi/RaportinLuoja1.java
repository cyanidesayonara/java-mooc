package painoindeksi;

import java.util.*;


public class RaportinLuoja1 implements Raportoiva {

    public RaportinLuoja1() {
    }


    @Override
    public PainoindeksiRaportti painoindeksiRaportti(List<Henkilo> henkilotiedot) {
        List<String> alipainoiset = new ArrayList();
        List<String> normaalipainoiset = new ArrayList();
        List<String> ylipainoiset = new ArrayList();
        List<String> merkittavastiYlipainoiset = new ArrayList();
        
        
        henkilotiedot.stream().forEach(h -> {
            if (h.getPaino() / (h.getPituus() * h.getPituus()) < 18.5) {
                alipainoiset.add(h.getNimi());
            } else if (h.getPaino() / (h.getPituus() * h.getPituus()) < 25) {
                normaalipainoiset.add(h.getNimi());
            } else if (h.getPaino() / (h.getPituus() * h.getPituus()) < 30) {
                ylipainoiset.add(h.getNimi());
            } else {
                merkittavastiYlipainoiset.add(h.getNimi());
            }
        });
        
        PainoindeksiRaportti painoindeksiRaportti = new PainoindeksiRaportti(
                alipainoiset, normaalipainoiset, ylipainoiset, merkittavastiYlipainoiset);
        return painoindeksiRaportti;
    }
}
