package kolmeyleisinta;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        List<String> sanat = new ArrayList();
        sanat.add("nakki");
        sanat.add("sanapidempi");
        sanat.add("ulkopuolinen");
        sanat.add("nakki");
        sanat.add("pitkäsana");
        sanat.add("sanapidempi");
        sanat.add("pitkäsana");
        sanat.add("nakki");
        sanat.add("pitkäsana");
        sanat.add("sanapidempi");
        sanat.add("nakki");
        
        YleisimmatSanat1 yle1 = new YleisimmatSanat1();
        System.out.println(yle1.yleisetSanat(sanat));
    }

}
