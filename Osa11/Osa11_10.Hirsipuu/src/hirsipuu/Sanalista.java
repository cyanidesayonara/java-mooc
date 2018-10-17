package hirsipuu;

import java.util.*;
import java.util.stream.Collectors;

public class Sanalista {

    private List<String> sanat;

    public Sanalista(List<String> sanat) {
        this.sanat = sanat;
    }

    public List<String> sanat() {
        return this.sanat;
    }

    public Sanalista sanatJoidenPituusOn(int pituus) {
        return new Sanalista(sanat.stream()
                .filter(s -> s.length() == pituus)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public Sanalista sanatJoissaEiEsiinnyKirjainta(char kirjain) {
        return new Sanalista(sanat.stream()
                .filter(s -> !s.contains(Character.toString(kirjain)))
                .collect(Collectors.toCollection(ArrayList::new)));           
    }

    public Sanalista sanatJoissaMerkit(String merkkijono) {
        /**
         * palauttaa sanalistan joka sisältää sanat jotka 
         * vastaavat muodoltaan arvattavaa sanaa, esim "--d-"
         */
        
        // listana oikean pituiset sanat
        List<String> sanatPituus = sanatJoidenPituusOn(merkkijono.length()).sanat();
        List<Integer> indx = new ArrayList();
        List<Character> ch = new ArrayList();
        
        // jos merkki on muu kuin "-", laita merkki ja sen indeksi listalle
        for (int i = 0; i < merkkijono.length(); i++) {
            if (merkkijono.charAt(i) != '-') {
                indx.add(i);
                ch.add(merkkijono.charAt(i));
            }
        }

        List<String> res = new ArrayList();
        
        // jos listalla oleva sana sisältää oikeat merkit oikeilla
        // indekseillä, lisää palautettavalle listalle
        for (int i = 0; i < sanatPituus.size(); i++) {
            boolean x = true;
            for (int j = 0; j < indx.size(); j++) {
                if (sanatPituus.get(i).charAt(indx.get(j)) != ch.get(j)) {
                    x = false;
                }
            }
            if (x == true) {
                res.add(sanatPituus.get(i));
            }
        }
       
        return new Sanalista(res);
    }

    public int koko() {
        return sanat.size();
    }
}
