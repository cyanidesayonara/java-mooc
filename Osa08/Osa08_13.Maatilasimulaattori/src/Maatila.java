import java.util.Collection;
import java.util.ArrayList;

public class Maatila {
    private String omistaja;
    private Navetta navetta;
    private Collection<Lehma> lehmat;

    public Maatila(String omistaja, Navetta navetta) {
        this.omistaja = omistaja;
        this.navetta = navetta;
        this.lehmat = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String rimpsu = "Maatilan omistaja: " + this.getOmistaja() + "\n";
        rimpsu += "Navetan maitosäiliö: " + this.navetta.getMaitosailio() + "\n";
        if (this.lehmat.isEmpty()) {
            rimpsu += "Ei lehmiä.";
        } else {
            rimpsu += "Lehmät:\n";
            rimpsu += lehmat.stream()
                    .map(l -> l.toString())
                    .reduce("", (a, l) -> a + "    " + l +"\n");
        }
        return rimpsu;
    }
    
    public String getOmistaja() {
        return this.omistaja;
    }
    
    public void lisaaLehma(Lehma lehma) {
        lehmat.add(lehma);
    }
    
    public void eleleTunti() {
        // for (Lehma lehma : lehmat) {      Python: for lehma in lehmat
        //    lehma.eleleTunti();               aka enhanced for loop
        // }
        
        lehmat.stream().forEach(l -> l.eleleTunti());
    }
    
    public void asennaNavettaanLypsyrobotti(Lypsyrobotti robo) {
        this.navetta.asennaLypsyrobotti(robo);
    }
    
    public void hoidaLehmat() {
        this.navetta.hoida(lehmat);
    }
    
    /*@
    Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Maatilan omistaja: ");
        sb.append(omistaja);
        sb.append("\n");
 
        sb.append("Navetan maitosäiliö: ");
        sb.append(navetta.getMaitosailio());
        sb.append("\n");
 
        if (lehmat.isEmpty()) {
            sb.append("Ei lehmiä.");
        } else {
            sb.append("Lehmät:\n");
 
            for (Lehma lehma : lehmat) {
                sb.append("        ");
                sb.append(lehma);
                sb.append("\n");
            }
        }
 
        return sb.toString();
    }
    */
}
