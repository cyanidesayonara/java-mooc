public class Kirja implements Talletettava {
    private String kirjoittaja;
    private String nimi;
    private double paino;
    
    public Kirja(String kirjoittaja, String nimi, double paino) {
        this.kirjoittaja = kirjoittaja;
        this.nimi = nimi;
        this.paino = paino;
    }
    
    @Override
    public String toString() {
        return this.kirjoittaja + ": " + this.nimi;
    }
    
    public double paino() {
        return this.paino;
    }
}
