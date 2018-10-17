package seismisetmittaukset;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        List<Double> list = new ArrayList();
        list.add((double) 20151004);
        list.add((double) 200);        
        list.add((double) 150);       
        list.add((double) 175);
        list.add((double) 20151005);
        list.add((double) 0.002);
        list.add((double) 0.03);
        list.add((double) 20151007);
        list.add((double) 15);
        list.add((double) 27);
        list.add((double) 20151105);
        list.add((double) 500);
        list.add((double) 600);
        
        MittausRaportoija1 mr1 = new MittausRaportoija1();
        mr1.paivittaisetMaksimit(list, 10).forEach(p -> System.out.println(p.getPaiva() + " : " + p.getSuurinArvo()));
        
        MittausRaportoija2 mr2 = new MittausRaportoija2();
        mr2.paivittaisetMaksimit(list, 10).forEach(p -> System.out.println(p.getPaiva() + " : " + p.getSuurinArvo()));
    }

}
