
import java.util.ArrayList;

public class Ruokalista {

    private ArrayList<String> ateriat;

    public Ruokalista() {
        this.ateriat = new ArrayList<>();
    }

        // toteuta tänne tarvittavat metodit
    public void lisaaAteria(String ateria)  {
        if (!ateriat.contains(ateria)) {
            this.ateriat.add(ateria);
        }
    }
    
    public void tulostaAteriat() {
        int i = 0;
        while(i < ateriat.size()) {
            System.out.println(this.ateriat.get(i));
            i++;
        }
    }
    
    public void tyhjennaRuokalista() {
        ateriat.clear();
        //int i = 0;
        //while(i < this.ateriat.size()) {
        //    this.ateriat.remove(i);
        //    i++;
        //}
    }
    
}
