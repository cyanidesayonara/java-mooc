
public class Raha {

    private final int euroa;
    private final int senttia;

    public Raha(int euroa, int senttia) {

        if (senttia > 99) {
            euroa += senttia / 100;
            senttia %= 100;
        }
        
        //if (senttia < 0) {
        //    euroa -= senttia / 100;
        //    senttia %= 100;
        //}

        this.euroa = euroa;
        this.senttia = senttia;
    }

    public int eurot() {
        return euroa;
    }

    public int sentit() {
        return senttia;
    }
    
    public Raha plus(Raha lisattava) {
        Raha uusi = new Raha((this.euroa + lisattava.euroa), (this.senttia + lisattava.senttia));
        return uusi;
    }
    
    public boolean vahemman(Raha verrattava) {
        if (this.euroa == verrattava.euroa && this.senttia < verrattava.senttia) {
            return true;
        }
        if (this.euroa < verrattava.euroa) {
            return true;
        }
        return false;
    }
    
    public Raha miinus(Raha vahentaja) {
        if (vahentaja.euroa > this.euroa) {
            Raha uusi = new Raha(0, 0);
            return uusi;
        } else if (vahentaja.senttia > this.senttia) {
            Raha uusi = new Raha((this.euroa - vahentaja.euroa) - 1, (this.senttia + 100) - vahentaja.senttia);
            return uusi;
        } else {
            Raha uusi = new Raha((this.euroa - vahentaja.euroa), (this.senttia - vahentaja.senttia));
            return uusi;
        }
    }

    public String toString() {
        String nolla = "";
        if (senttia < 10) {
            nolla = "0";
        }

        return euroa + "." + nolla + senttia + "e";
    }

}
