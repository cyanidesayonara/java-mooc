package kolmeyleisinta;

import java.util.*;

public class YleisimmatSanat1 implements ToistonTunnistin {

    YleisimmatSanat1() {
    }

    @Override
    public List<String> yleisetSanat(List<String> sanat) {
        List<Integer> freq = new ArrayList();
        List<String> str  = new ArrayList();
        
        for (int i = 0; i < sanat.size(); i++) {
            if (!str.contains(sanat.get(i))) {
                str.add(sanat.get(i));
                freq.add(1);
            } else {
                freq.set(str.indexOf(sanat.get(i)), freq.get(str.indexOf(sanat.get(i))) + 1);
            }
        }
        
        List<String> res = new ArrayList();
        
        for (int j = Collections.max(freq), min = Collections.min(freq); j >= min; j--) {
            List<String> list = new ArrayList();
            
            while (freq.contains(j)) {
                list.add(str.get(freq.indexOf(j)));
                str.remove(freq.indexOf(j));
                freq.remove(freq.indexOf(j));                
            }

            if (list.size() == 1) {
                res.add(list.get(0));
            } else {
                list.stream()
                        .distinct()
                        .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                        .forEach(s -> res.add(s));
            }
        }
        
        if (res.size() > 3) {
            return res.subList(0, 3);
        }
        return res;
    }
}
