package hirsipuu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Hirsipuu {

    private Sanalista sanalista;
    private int arvauksiaJaljella;
    private String arvattava;
    private List<Character> arvaukset;

    public Hirsipuu(Sanalista sanalista, int arvauksiaAlussa) {
        this.sanalista = sanalista;
        this.arvauksiaJaljella = arvauksiaAlussa;
        arvaukset = new ArrayList();

        Collections.shuffle(this.sanalista.sanat());
        this.arvattava = this.sanalista.sanat().get(0);
    }

    public List<Character> arvaukset() {
        return arvaukset;
    }

    public int arvauksiaJaljella() {
        return this.arvauksiaJaljella;
    }

    public boolean arvaa(Character kirjain) {
        /**
         * tarkoitus on yksinkertaisesti väistellä arvattua kirjainta
         * vaihtamalla sanaa aina sellaiseen josta sitä ei löydy
         * kunnes vaihtoehtoja on jäljellä enää yksi
         */

        // listaa kaikki sopivat vaihtoehtoiset sanat
        List<String> vaihtoehdot = vaihtoehtoisetSanat(kirjain);
        

        // jos arvattu kirjain loytyy arvattavasta sanasta ja
        // vaihtoehtojen lista ei ole tyhjä, poimitaan satunnainen
        // sana (joka ei sisällä arvattua kirjainta) uudeksi arvattavaksi
        if (arvattava.contains(Character.toString(kirjain)) &&
                !vaihtoehdot.isEmpty()) {
            arvattava = vaihtoehdot.get(0);
        }
        
        // lisää kirjain arvattujen listalle jos ei jo ole
        if (!arvaukset.contains(kirjain)) {
            arvaukset.add(kirjain);
        }
        
        if (!arvattava.contains(Character.toString(kirjain))) {
            arvauksiaJaljella--;
            return false;
        }
        return true;
    }
    
    public List<String> vaihtoehtoisetSanat(Character kirjain) {
        /**
         * palauttaa kaikki sopivat sanat jotka eivät sisällä
         * arvattua kirjainta
         */
        
        // sanat joista löytyy jo paljastetut merkit
        Sanalista vaihtoSanat = sanalista.sanatJoissaMerkit(sana());
        
        // filtteröidään vielä sanat joiden piilotetut kirjaimet
        // eivät ole arvattujen listalla sekä sanat jotka
        // sisältävät arvatun kirjaimen
        List<String> vaihtoehtoisetSanat = vaihtoSanat.sanat().stream()
                .filter(s -> !puuttuvatMerkitSisaltaaArvatun(s))
                .filter(s -> !s.contains(Character.toString(kirjain)))
                .collect(Collectors.toCollection(ArrayList::new));

        return vaihtoehtoisetSanat;
    }

    public String sana() {
        String sana = arvattava;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sana.length(); i++) {
            if (arvaukset.contains(sana.charAt(i))) {
                sb.append(sana.charAt(i));
            } else {
                sb.append('-');
            }
        }
        
        return sb.toString();
    }

    public String oikeaSana() {
        return arvattava;
    }
    
    public List<Character> arvatutMerkit() {
        // palauttaa listana kaikki paljastetut kirjaimet
        List<Character> arvatut = new ArrayList();
        String sana = sana();
        for (int i = 0; i < sana.length(); i++) {
            if (sana.charAt(i) != '-') {
                arvatut.add(sana.charAt(i));
            }
        }
        return arvatut;
    }

    public boolean onLoppu() {
        return !sana().contains(Character.toString('-'));
    }
    
    public boolean puuttuvatMerkitSisaltaaArvatun(String sana) {
        String verrattava = sana();
        List<Character> piilomerkit = new ArrayList();
        
        // verrataan paljasta ja piilotettua sanaa
        // ja kerätään piilotetut kirjaimet listalle
        for (int i = 0; i < verrattava.length(); i++) {
            if (verrattava.charAt(i) != sana.charAt(i)) {
                piilomerkit.add(sana.charAt(i));
            }
        }
        
        // jos piilomerkki löytyy arvattujen listalta, true
        for (int i = 0; i < piilomerkit.size(); i++) {
            if (arvaukset.contains(piilomerkit.get(i))) {
                return true;
            }
        }
        return false;
    }
}
