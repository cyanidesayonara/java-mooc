/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija;

/**
 *
 * @author Santtu
 */
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;
import suosittelija.domain.Henkilo;
import java.util.*;
import java.util.stream.Collectors;

public class ArvioRekisteri {
    private Map<Elokuva, List<Arvio>> elokuvanArviot;
    private Map<Henkilo, Map<Elokuva, Arvio>> henkiloArviot;
    
    public ArvioRekisteri() {
        elokuvanArviot = new HashMap();
        henkiloArviot = new HashMap();
    }
    
    public void lisaaArvio(Elokuva elokuva, Arvio arvio) {
        List<Arvio> arviot = elokuvanArviot.getOrDefault(elokuva, new ArrayList());
        arviot.add(arvio);
        elokuvanArviot.put(elokuva, arviot);
    }
    
    public void lisaaArvio(Henkilo henkilo, Elokuva elokuva, Arvio arvio) {
        henkiloArviot.putIfAbsent(henkilo, new HashMap());
        henkiloArviot.get(henkilo).putIfAbsent(elokuva, arvio);
        lisaaArvio(elokuva, arvio);
    } 
    
    public List<Arvio> annaArviot (Elokuva elokuva) {
        return elokuvanArviot.get(elokuva);
    }
    
    public Map<Elokuva, List<Arvio>> elokuvienArviot() {
        return elokuvanArviot;
    }
    
    public Arvio haeArvio(Henkilo henkilo, Elokuva elokuva) {
        if (henkiloArviot.containsKey(henkilo)) {
            return henkiloArviot.get(henkilo).getOrDefault(elokuva, Arvio.EI_NAHNYT);
        }
        return Arvio.EI_NAHNYT;
    }
    
    public Map<Elokuva, Arvio> annaHenkilonArviot(Henkilo henkilo) {       
        return henkiloArviot.getOrDefault(henkilo, new HashMap());
    }
    
    public List<Henkilo> arvioijat() {
        return henkiloArviot.keySet().stream()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}