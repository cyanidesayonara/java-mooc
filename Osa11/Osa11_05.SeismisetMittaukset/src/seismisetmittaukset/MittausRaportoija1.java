package seismisetmittaukset;

import java.util.*;

public class MittausRaportoija1 implements SeismisenToiminnanMittaaja {

    MittausRaportoija1() {
    }

    @Override
    public List<SuurinTaajuusRaportti> paivittaisetMaksimit(List<Double> mittausData,
            int kuukausi) {
        List<SuurinTaajuusRaportti> rapo = new ArrayList();
        List<Double> korkein = new ArrayList();

        int paiva = 0;
        int i = 0;
        int kk = 0;
        
        while (true) {
            Double md = mittausData.get(i);
            String arvo = "" + md.intValue();
            
            if (arvo.length() == 8) {
                if (!korkein.isEmpty() && kk == kuukausi) {
                    rapo.add(new SuurinTaajuusRaportti(paiva, korkein.stream()
                            .mapToDouble(k -> k)
                            .max()
                            .getAsDouble()));
                }
                korkein.clear();
                paiva = md.intValue();
                kk = Integer.parseInt(Integer.toString(paiva).substring(4, 6));
            } else {
                korkein.add(md);
            }
            
            i++;
            
            if (i == mittausData.size()) {
                if (kk == kuukausi) {
                    rapo.add(new SuurinTaajuusRaportti(paiva, korkein.stream()
                                .mapToDouble(k -> k)
                                .max()
                                .getAsDouble()));
                }
                break;
            }
        }
        return rapo;
    }

}
