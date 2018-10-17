package sovellus;

import java.util.*;
import java.util.stream.Collectors;

public class Kirjoitusnopeudet {

    private Map<String, List<Double>> sanojenKirjoitusnopeudet;
    private Queue<String> sanat;

    public Kirjoitusnopeudet() {
        this.sanojenKirjoitusnopeudet = new TreeMap<>();
        this.sanat = new LinkedList();
    }

    public void lisaa(String sana, double aika) {
        this.sanojenKirjoitusnopeudet.putIfAbsent(sana, new ArrayList<>());
        this.sanojenKirjoitusnopeudet.get(sana).add(aika);
        sanat.add(sana);
        if (sanat.size() > 10) {
            sanat.remove();
        }
    }

    public Map<String, Double> keskiarvot() {
        Map<String, Double> keskiarvot = new LinkedHashMap();
        sanat.forEach(s -> keskiarvot.put(s, sanojenKirjoitusnopeudet.get(s).stream()
                                .mapToDouble(k -> k)
                                .average()
                                .getAsDouble()));
        return keskiarvot;
    }
}

