
public class Asunto {

    private int huoneita;
    private int nelioita;
    private int neliohinta;

    public Asunto(int huoneita, int nelioita, int neliohinta) {
        this.huoneita = huoneita;
        this.nelioita = nelioita;
        this.neliohinta = neliohinta;
    }
    
    public boolean suurempi(Asunto verrattava) {
        return this.nelioita > verrattava.nelioita;
    }
    
    public int hintaero(Asunto verrattava) {
        return Math.abs(this.nelioita * this.neliohinta - verrattava.nelioita * verrattava.neliohinta); 
    }
    
    public boolean kalliimpi(Asunto verrattava) {
        if (this.nelioita * this.neliohinta > verrattava.nelioita * verrattava.neliohinta) {
            return true;
        }
        return false;
    }
}
