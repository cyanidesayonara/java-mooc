

public class Maitosailio {
    private double tilavuus;
    private double saldo;
    
    public Maitosailio() {
        this(2000);
    }
    
    public Maitosailio(double tilavuus) {
        this.tilavuus = tilavuus;
        this.saldo = 0;
    }
    
    public double getTilavuus() {
        return this.tilavuus;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public double paljonkoTilaaJaljella() {
        return getTilavuus() - getSaldo();
    }
    
    public void lisaaSailioon(double maara) {
        if (paljonkoTilaaJaljella() >= maara) {
            this.saldo = this.saldo + maara;
        } else {
            this.saldo = this.tilavuus;
        }
    }
    
    public double otaSailiosta(double maara) {
        if (getSaldo() >= maara) {
            this.saldo = this.saldo - maara;
            return maara;
        } else {
            double pohjat = this.saldo;
            this.saldo = 0;
            return pohjat;
        }
    }
    
    @Override
    public String toString() {
        return Math.ceil(getSaldo()) + "/" + Math.ceil(getTilavuus());
    }
}
