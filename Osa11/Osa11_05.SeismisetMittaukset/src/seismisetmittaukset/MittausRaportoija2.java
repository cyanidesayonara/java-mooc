package seismisetmittaukset;

import java.util.*;
import java.util.stream.Collectors;

public class MittausRaportoija2 implements SeismisenToiminnanMittaaja {

    MittausRaportoija2() {
    }

    public List<SuurinTaajuusRaportti> paivittaisetMaksimit(List<Double> mittausData,
            int kuukausi) {
        List<SuurinTaajuusRaportti> rapo = new ArrayList();
        List<Double> korkein = new ArrayList();

        int paiva = 0;
        int i = 0;
        
        while (true) {
            Double md = mittausData.get(i);
            String arvo = "" + md.intValue();
            
            if (arvo.length() == 8) {
                if (!korkein.isEmpty()) {
                    rapo.add(new SuurinTaajuusRaportti(paiva, korkein.stream()
                            .mapToDouble(k -> k)
                            .max()
                            .getAsDouble()));
                }
                korkein.clear();
                paiva = md.intValue();
            } else {
                korkein.add(md);
            }
            
            i++;
            
            if (i == mittausData.size()) {
                    rapo.add(new SuurinTaajuusRaportti(paiva, korkein.stream()
                                .mapToDouble(k -> k)
                                .max()
                                .getAsDouble()));
                break;
            }
        }
        return rapo.stream().filter(r -> Integer.parseInt(Integer.toString(r.getPaiva()).substring(4, 6)) == kuukausi)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
