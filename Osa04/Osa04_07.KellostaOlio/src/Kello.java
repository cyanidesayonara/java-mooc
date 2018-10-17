
public class Kello {

    private YlhaaltaRajoitettuLaskuri tunnit;
    private YlhaaltaRajoitettuLaskuri minuutit;
    private YlhaaltaRajoitettuLaskuri sekunnit;

    public Kello(int tunnitAlussa, int minuutitAlussa, int sekunnitAlussa) {
        // luodaan kello joka asetetaan parametrina annettuun aikaan
        tunnit = new YlhaaltaRajoitettuLaskuri(23);
        minuutit = new YlhaaltaRajoitettuLaskuri(59);
        sekunnit = new YlhaaltaRajoitettuLaskuri(59);
        tunnit.asetaArvo(tunnitAlussa);
        minuutit.asetaArvo(minuutitAlussa);
        sekunnit.asetaArvo(sekunnitAlussa);
        
    }

    public void etene() {
        // kello etenee sekunnilla
        if (minuutit.arvo() == 59 && sekunnit.arvo() == 59) {
            tunnit.seuraava();
        } 
        if (sekunnit.arvo() == 59) {
            minuutit.seuraava();
        }
        this.sekunnit.seuraava();
    }

    public String toString() {
        // palauttaa kellon merkkijonoesityksen
        return this.tunnit + ":" + this.minuutit + ":" + this.sekunnit;
    }
}
