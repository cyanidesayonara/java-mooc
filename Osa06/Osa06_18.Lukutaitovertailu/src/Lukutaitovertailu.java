import java.util.stream.Collectors;
import java.util.ArrayList;

public class Lukutaitovertailu {
    
    public static void main(String[] args) {
        Lukija lukija = new Lukija();
        ArrayList<String> luetut = lukija.lueTiedosto("lukutaito.csv");
        
        ArrayList<Matalin> matalin = 
            luetut.stream()
                .map(rivi -> rivi.split(","))
                .map(rivi -> new Matalin(rivi[3], Integer.parseInt(rivi[4]),
                    rivi[2].substring(0, rivi[2].length() - 3).trim(), Double.parseDouble(rivi[5])))
                .collect(Collectors.toCollection(ArrayList::new));
        
        matalin.stream().sorted((m1, m2) -> {
            return Double.compare(m1.getPrs(), m2.getPrs());
        }).forEach(m -> System.out.println(
            m.getMaa() + " (" + m.getVuosi() + "), " + m.getSex() + ", " + m.getPrs()));
    }   
}
