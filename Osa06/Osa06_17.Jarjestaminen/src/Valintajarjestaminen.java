import java.util.Arrays;

public class Valintajarjestaminen {

    public Valintajarjestaminen() {

    }
    
    public int pienin(int[] taulukko) {
        int pienin = taulukko[0];
        for (int i = 1; i < taulukko.length; i++) {
            if (taulukko[i] < pienin) {
                pienin = taulukko[i];
            }
        }
        return pienin;
    }
    
    public int pienimmanIndeksi(int[] taulukko) {
        int[] tlk = taulukko.clone();
        int pienin = pienin(taulukko);
        int i = 0;
        for (; i < tlk.length; i++) {
            if (tlk[i] == pienin) {
                break;
            }
        }
        return i;
    }
    
    public int pienimmanIndeksiAlkaen(int[] taulukko, int aloitusIndeksi) {
        int indeksi = aloitusIndeksi;
        int pienin = taulukko[aloitusIndeksi];
        for (int i = indeksi; i < taulukko.length; i++) {
            if (taulukko[i] < pienin) {
                pienin = taulukko[i];
                indeksi = i;
            } 
        }
        return indeksi;
    }
    
    public void vaihda(int[] taulukko, int indeksi1, int indeksi2) {
        int temp = taulukko[indeksi1];
        taulukko[indeksi1] = taulukko[indeksi2];
        taulukko[indeksi2] = temp; 
    }
    
    public void jarjesta(int[] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            System.out.println(Arrays.toString(taulukko));
            vaihda(taulukko, i, pienimmanIndeksiAlkaen(taulukko, i)); 
        } 
    }
}