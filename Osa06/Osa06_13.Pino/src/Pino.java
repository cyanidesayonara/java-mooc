
public class Pino {

    private String[] taulukko;
    private int arvoja;

    public Pino() {
        this.taulukko = new String[5];
    }

    public void lisaa(String arvo) {
        if (this.arvoja >= this.taulukko.length) {
            this.kasvata();
        }

        this.taulukko[this.arvoja] = arvo;
        this.arvoja++;
    }

    public void kasvata() {
        // Lisää kasvatustoiminnallisuus tänne! 
        String uusi[] = new String[this.taulukko.length + 5];
        for (int i = 0; i < koko(); i++) {
            uusi[i] = this.taulukko[i];
        }
        this.taulukko = uusi;
    }

    public String poista() {
        if (this.arvoja == 0) {
            return null;
        }

        this.arvoja--;
        return this.taulukko[this.arvoja];
    }
    
    public int koko() {
        return this.arvoja;
    }

    public String[] getTaulukko() {
        return taulukko;
    }
}
