/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muuttaminen.logiikka;

/**
 *
 * @author Santtu
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import muuttaminen.domain.*;

public class Pakkaaja {
    private int laatikoidenTilavuus;
    
    public Pakkaaja(int laatikoidenTilavuus) {
        this.laatikoidenTilavuus = laatikoidenTilavuus;
    }
    
    public List<Muuttolaatikko> pakkaaTavarat(List<Tavara> tavarat) {
        List<Muuttolaatikko> varasto = new ArrayList<>();
        ArrayList<Tavara> stuff = tavarat.stream().sorted()
                            .collect(Collectors.toCollection(ArrayList::new));
        
        int i = 0;
        
        while (i < stuff.size()) {
            Muuttolaatikko loota = new Muuttolaatikko(laatikoidenTilavuus);
            while (true) {
                Tavara tavara = stuff.get(i);
                if  (!loota.lisaaTavara(tavara)) {
                    break;
                }
                i++;
                if (i == stuff.size()) {
                    break;
                }
            }
            varasto.add(loota);
        }
        return varasto;
    }
}
