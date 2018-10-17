package tehtavat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Tehtavienhallinta {
    private List<Tehtava> tehtavat;
    
    public Tehtavienhallinta() {
        tehtavat = new ArrayList();
    }
    
    public List<String> tehtavalista() {
        return tehtavat.stream()
                .map(t -> t.getName())
                .collect(Collectors.toList());
    }
    
    public void lisaa(String task) {
        tehtavat.add(new Tehtava(task));    
    }
    
    public void merkkaaTehdyksi(String name) {
        tehtavat.stream()
                .filter(t -> t.getName().equals(name))
                .forEach(t -> t.doTask());
    }
    
    public boolean onTehty(String name) {
        return tehtavat.stream()
                .filter(t -> t.getName().equals(name))
                .filter(t -> t.doneOrNah()).count() > 0;        
    }
    
    public void poistaTehtava(String name) {
        Iterator<Tehtava> iter = tehtavat.iterator();
        
        while (iter.hasNext()) {
            if (iter.next().getName().equals(name)) {
                iter.remove();
                break;
            }
        }
    }
}
