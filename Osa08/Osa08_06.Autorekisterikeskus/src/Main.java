
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        // alla sama esimerkkiohjelma mikä 9.1:n tehtävämääritelmästä löytyy
        
        Ajoneuvorekisteri ar = new Ajoneuvorekisteri(); 
        ar.lisaa( new Rekisterinumero("FI", "AAA-111"), "Arto");
        ar.lisaa( new Rekisterinumero("FI", "BBB-222"), "Pekka");
        ar.lisaa( new Rekisterinumero("FI", "CCC-333"), "Jukka");
        ar.tulostaRekisterinumerot();
    }
}
