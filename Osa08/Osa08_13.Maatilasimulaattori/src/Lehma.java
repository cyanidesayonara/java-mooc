import java.util.Random;

public class Lehma implements Lypsava, Eleleva {
    private String nimi;
    private int utareet;
    private double maara;
    private static final String[] NIMIA = new String[]{
    "Anu", "Arpa", "Essi", "Heluna", "Hely",
    "Hento", "Hilke", "Hilsu", "Hymy", "Matti", "Ilme", "Ilo",
    "Jaana", "Jami", "Jatta", "Laku", "Liekki",
    "Mainikki", "Mella", "Mimmi", "Naatti",
    "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
    "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Lehma() {
        this(NIMIA[new Random().nextInt(NIMIA.length)]);
    }
    
    public Lehma(String nimi) {
        this.nimi = nimi;
        this.utareet = 15 + new Random().nextInt(26);
        this.maara = 0;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public double getTilavuus() {
        return this.utareet;
    }
    
    public double getMaara() {
        return this.maara;
    }
    
    public double tilaaJaljella() {
        return this.getTilavuus() - this.getMaara();
    }
    
    @Override
    public String toString() {
        return this.getNimi() + " " + Math.ceil(this.getMaara()) + "/" + Math.ceil(this.getTilavuus());
    }
    
    @Override
    public void eleleTunti() {
        double tuotos = 0.7 + new Random().nextDouble() * 1.3;
        if (tilaaJaljella() >= tuotos) {
            this.maara = this.getMaara() + tuotos;
        } else {
            this.maara = this.getTilavuus();
        }
    }
    
    @Override
    public double lypsa() {
        double lypsy = this.getMaara();
        this.maara = 0;
        return lypsy;
    }
}
