
import java.util.ArrayList;

public class Aly {

    private ArrayList<String> vastustajanHistoria;
    private ArrayList<Integer> lista;

    public Aly() {
        this.vastustajanHistoria = new ArrayList<>();
        
        lista = new ArrayList<>();
        
        lista.add(0);
        lista.add(1);
        
        int j = 2;
        
        while (j < 30) {
            lista.add(lista.get(j - 1) + lista.get(j - 2));
            j++;
        }
    }

    public String pelaa() {
        // Muokkaa täällä olevaa toiminnallisuutta
        
        // Älyn sisältämä lista on ArrayList. Se sisältää tähänastiset
        // pelaajan tekemät siirrot.
        
        // Sen käsittely onnistuu samalla tavalla kuin listan käsittely aiemmin.
        // Kaikki listalla olevat arvot saa tulostettua komennolla:
        int indeksi = 0;
        while(indeksi < this.vastustajanHistoria.size()) {
            //System.out.println(this.vastustajanHistoria.get(indeksi));
            indeksi++;
        }
        int i = 0;
        int j = 5;

        while (i < this.vastustajanHistoria.size()) {
            if (this.vastustajanHistoria.get(i).equals("Kivi")) {
                j += 1;
            }
            if (this.vastustajanHistoria.get(i).equals("Paperi")) {
                j += 2;
            }  
            if (this.vastustajanHistoria.get(i).equals("Sakset")) {
                j += 3;
            }
            i++;
        }
        
        if (lista.get(j % 30) + i % 3 == 0 || lista.get(j % 30) + i % 7 == 0 || lista.get(j % 30) + i % 11 == 0) {
            j += 1;
        } else if ((lista.get(j % 30) + i) % 4 == 0 || (lista.get(j % 30) + i) % 5 == 0) {
            j += 2;
        } else {
            j += 3;
        }
        
        // kerrot älyn tekemän valinnan komennolla
        // return "Vaihtoehto";  -- Vaihtoehto voi olla Kivi, Paperi tai Sakset
    
        //System.out.println("j on "+ j +" fibo on "+ lista.get(j % 30));
        i++;
        
        if (lista.get(j % 30) + i % 3 == 0 || lista.get(j % 30) + i % 7 == 0 || lista.get(j % 30) + i % 11 == 0 || j % 3 == 0) {
            System.out.println("Aly pelaa: Paperi");
            return "Paperi";
        } else if ((lista.get(j % 30) + i) % 4 == 0 || (lista.get(j % 30) + i) % 5 == 0) {
            System.out.println("Aly pelaa: Sakset");
            return "Sakset";
        } else {
            System.out.println("Aly pelaa: Kivi");
            return "Kivi";
        }
        
        // lopeta muokkaus tähän    
    }

    public void muista(String siirto) {
        this.vastustajanHistoria.add(siirto);
    }

}
