public class Sivari implements Palvelusvelvollinen {
    private int paivia;
    
    public Sivari() {
        this.paivia = 362;
    }
    
    public int paiviaJaljella() {
        return this.paivia;
    }
    
    public void palvele() {
        if (this.paivia > 0) {
            this.paivia--;
        }
    }
}
