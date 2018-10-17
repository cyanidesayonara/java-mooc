package arviot;

import java.util.*;

public class TunteikkaatArviot {
    private Map<String, Integer> sanojenYleisyys;
    private Map<String, Double> sanojenTunteet;
    
    // Huom! Älä muuta konstruktorin parametrien määrää -- konstruktoria
    // saa toki muuten muuttaa
    public TunteikkaatArviot(List<String> rivit) {
        lataaSanat(rivit);
    }
    
    public void lataaSanat(List<String> arviot) {
        Map<String, List<Integer>> sanatJaTunteet = new HashMap();
        sanojenTunteet = new HashMap();
        sanojenYleisyys = new HashMap();
        Iterator<String> iter = arviot.iterator();
        while (iter.hasNext()) {
            String lause = iter.next();
            String[] palat = lause.split(" ");
            lataaSanatJaTunteet(palat, sanatJaTunteet);
        }
        lataaSanojenTunteet(sanatJaTunteet);
    }
    
    public void lataaSanatJaTunteet(String[] palat, Map<String, List<Integer>> sanatJaTunteet) {
        for (int i = 1; i < palat.length; i++) {
            String pala = palat[i].toLowerCase();
            if (pala.matches("[(-)*[0-9]*a-z]{2,}|a|i")) {
                sanatJaTunteet.putIfAbsent(pala, new ArrayList<Integer>());
                List<Integer> tunteet = sanatJaTunteet.get(pala);
                tunteet.add(Integer.parseInt(palat[0]));
                lataaSanojenLukumaarat(pala); 
            }
        }
        
    }
        
    public void lataaSanojenTunteet(Map<String, List<Integer>> sanatJaTunteet) {
        Iterator <Map.Entry<String, List<Integer>>> iter = sanatJaTunteet
                .entrySet()
                .iterator();
        
        while (iter.hasNext()) {
            Map.Entry<String, List<Integer>> mappi = iter.next();
            double tunne = mappi.getValue().stream().mapToInt(i -> i)
                    .average()
                    .getAsDouble();
            sanojenTunteet.put(mappi.getKey(), tunne);
        }
    }
    
    public void lataaSanojenLukumaarat(String pala) {
        sanojenYleisyys.putIfAbsent(pala, 0);
        sanojenYleisyys.replace(pala, sanojenYleisyys.get(pala) + 1);
    }

    public int sanojenLukumaara(String sana) {
        return sanojenYleisyys.getOrDefault(sana, 0);
    }

    public double sananTunne(String sana) {
        return sanojenTunteet.getOrDefault(sana, 2.0);
    }

    public String sananTunneMerkkijonona(String sana) {
        double arvo = sananTunne(sana.toLowerCase());
        return tunne(arvo);
    }
    
    public String tunne(Double arvo) {
        if (arvo <= 1.9) {
            return "negatiivinen";
        }
        if (arvo <= 2.1) {
            return "neutraali";
        }
        return "positiivinen";
    }

    public double lauseenTunne(String lause) {
        double sum = 0.0;
        String[] sanat = lause.toLowerCase().split(" ");
        for (String sana : sanat) {
            sum += sananTunne(sana);
        }
        return sum == 0 ? sum : sum / sanat.length;
    }

    public String lauseenTunneMerkkijonona(String lause) {
        return tunne(lauseenTunne(lause));
    }

}
