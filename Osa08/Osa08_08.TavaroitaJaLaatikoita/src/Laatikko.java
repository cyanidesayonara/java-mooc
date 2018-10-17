import java.util.ArrayList;

public class Laatikko implements Talletettava {
    private ArrayList<Talletettava> loota;
    private double maxpaino;
    
    public Laatikko(double maxpaino) {
        this.loota = new ArrayList<>();
        this.maxpaino = maxpaino;
    }
    
    public double paino() {
        return loota.stream()
                .mapToDouble(t -> t.paino())
                .sum();
    }
    
    public void lisaa(Talletettava tallenne) {
        
        if (paino() + tallenne.paino() <= maxpaino) {
            loota.add(tallenne);
        }
    }
    
    public String toString() {
        return "Laatikko: " + this.loota.size() + " esinettä, paino yhteensä " +
                paino() + " kiloa";
    }
}
