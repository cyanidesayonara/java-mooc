/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija;

import java.util.stream.Collectors;
import java.util.*;
import suosittelija.comparator.*;
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;
import suosittelija.domain.Henkilo;
import suosittelija.ArvioRekisteri;

/**
 *
 * @author Santtu
 */
public class Suosittelija {
    private ArvioRekisteri ar;
    
    public Suosittelija(ArvioRekisteri ar) {
        this.ar = ar;
    }
    
    public Elokuva suositteleElokuva(Henkilo henkilo) {
        
        // henkilön arviomat elokuvat + arviot
        Map<Elokuva, Arvio> henkilonArviot = ar.annaHenkilonArviot(henkilo);
        
        // jos ei nähtyjä leffoja, tarjoa korkeimmin arvioitu seuraavasti:
        if (henkilonArviot.isEmpty()) {
            
            // kaikki arvioidut leffat listana
            List<Elokuva> kaikki = ar.elokuvienArviot().keySet().stream()
                    .collect(Collectors.toCollection(ArrayList::new));
            
            // palauta listan korkeimman ka:n omaava leffa
            // (jotain on vähän hauskasti, koska min antaa kärkituloksen)
            // (testi kuitenkin sanoo että compare toimii oikein)
            // (Collections.sortin 0. indeksi on siis suurin)
            return Collections.min(kaikki, new ElokuvaComparator(ar.elokuvienArviot()));
        } else {
            
            // kaikki arvioijat listana
            List<Henkilo> arvioijat = ar.arvioijat();
            
            // poistetaan listalta henkilö jolle suositellaan
            arvioijat.remove(henkilo);
            
            // mappi samuuksien listaamiseen
            Map<Henkilo, Integer> samuudet = new HashMap();
            
            // jokaiselle arviojalle suoritetaan:
            arvioijat.forEach(a -> {
                int samuus = 0;
                
                // arvioijan arvioimat leffat settinä
                Set<Elokuva> hArv = ar.annaHenkilonArviot(a).keySet();
                
                // listana yhteiset suosituksen kohteen kanssa nähdyt leffat
                List<Elokuva> yhteiset = hArv.stream()
                        .filter(e -> henkilonArviot.containsKey(e))
                        .collect(Collectors.toCollection(ArrayList::new));
                
                // jos yhteisiä on:
                if (!yhteiset.isEmpty()) {
                    
                    
                    // iteraattori yhteisille
                    Iterator<Elokuva> iter = yhteiset.iterator();
                    while(iter.hasNext()) {

                        // iteroi yhteisten leffojen lista
                        Elokuva e = iter.next();

                        // per leffa, lisää samuuteen kummankin arvion tulo
                        samuus += ar.haeArvio(henkilo, e).getArvo() *
                                ar.haeArvio(a, e).getArvo();
                    }

                    // laita samuus mappiin avaimella arvostelija
                    samuudet.put(a, samuus);
                }
            });
            
            // suosittelija on korkeimman samuuden omaava
            Henkilo suosittelija = Collections.min(arvioijat, new HenkiloComparator(samuudet));
            
            // suosittelijan näkemät leffat listana
            List<Elokuva> suosittelijanNakemat = ar.annaHenkilonArviot(suosittelija)
                    .keySet()
                    .stream()
                    .collect(Collectors.toCollection(ArrayList::new));
            
            // listana suosittelijan näkemät ja positiivisen arvion saaneet,
            // joita suosittelun kohde ei ole nähnyt (tai ainakaan arvostellut)
            List<Elokuva> suositellutNakemattomat = suosittelijanNakemat.stream()
                    .filter(e -> ar.haeArvio(suosittelija, e).getArvo() > 0 &&
                            !henkilonArviot.containsKey(e))
                    .collect(Collectors.toCollection(ArrayList::new));
            
            // jos tyhjä, null
            if (suositellutNakemattomat.isEmpty()) {
                return null;
            }
            
            // palautetaan listan korkeimman keskiarvon omaava
            return Collections.min(suositellutNakemattomat, new ElokuvaComparator(ar.elokuvienArviot()));
        }  
    }
}
