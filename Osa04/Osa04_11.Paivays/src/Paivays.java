
public class Paivays {

    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    @Override
    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi &&
            this.kuukausi < verrattava.kuukausi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi &&
            this.kuukausi == verrattava.kuukausi &&
            this.paiva < verrattava.paiva) {
            return true;
        }

        return false;
    }
    
    public void etene() {
                
        if (this.kuukausi == 12 && this.paiva == 30) {
            this.vuosi++;
            this.kuukausi = 1;
            this.paiva = 1;
        } else if (this.paiva == 30) {
            this.kuukausi++;
            this.paiva = 1;
        } else {
            this.paiva++;
        }
    }
    
    
    public void etene(int paivia) {
        
        int i = 0;
        while (i < paivia) {
            etene();
            i++;
        }
        
        //this.paiva += paivia;
    
    /*
        if (this.paiva > 30) {
            if (this.paiva % 30 == 0) {
                this.kuukausi += this.paiva / 30 - 1;
                this.paiva = 30;
            } else {
                this.kuukausi += this.paiva / 30;
                this.paiva = this.paiva % 30;
            }
        }

        if (this.kuukausi > 12) {
            if (this.kuukausi % 12 == 0) {
                this.vuosi += this.kuukausi / 12 - 1;
                this.kuukausi = 12;
            } else {
                this.vuosi += this.kuukausi / 12;
                this.kuukausi = this.kuukausi % 12;
            }
        } 
    */
    }
    
    public Paivays paivienPaasta(int paivia) {
        Paivays uusiPaivays = new Paivays(this.paiva, this.kuukausi, this.vuosi);
        uusiPaivays.etene(paivia);
        return uusiPaivays;
        
    }
}
