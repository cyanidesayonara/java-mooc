package laskin;

public class Laskin {

    private int arvo;

    public Laskin() {
        this.arvo = 0;
    }

    public void summa(int luku) {
        this.arvo += luku;
    }

    public void erotus(int luku) {
        this.arvo += luku;
    }

    public int getArvo() {
        return this.arvo;
    }
}
