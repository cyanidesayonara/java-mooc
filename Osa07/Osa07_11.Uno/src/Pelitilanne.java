
public class Pelitilanne {

    private String suunta;
    private int omaIndeksi;

    private int[] pelaajienPisteet;
    private int[] pelaajienKorttienLukumaarat;
    private String[] pelaajienViimeksiPelaamatVarit;

    public Pelitilanne(int pelaajia) {
        this.pelaajienPisteet = new int[pelaajia];
        this.pelaajienKorttienLukumaarat = new int[pelaajia];
        this.pelaajienViimeksiPelaamatVarit = new String[pelaajia];
    }

    public String getSuunta() {
        return suunta;
    }

    public void asetaSuunta(String suunta) {
        this.suunta = suunta;
    }

    public int getOmaIndeksi() {
        return omaIndeksi;
    }

    public void setOmaIndeksi(int omaIndeksi) {
        this.omaIndeksi = omaIndeksi;
    }

    public int[] getPelaajienPisteet() {
        return pelaajienPisteet;
    }

    public void setPisteet(int pelaajanIndeksi, int pisteet) {
        this.pelaajienPisteet[pelaajanIndeksi] = pisteet;
    }

    public int[] getPelaajienKorttienLukumaarat() {
        return pelaajienKorttienLukumaarat;
    }

    public void paivitaKorttienLukumaara(int pelaajanIndeksi, int kortteja) {
        this.pelaajienKorttienLukumaarat[pelaajanIndeksi] = kortteja;
    }

    public String[] getPelaajienViimeksiPelaamatVarit() {
        return pelaajienViimeksiPelaamatVarit;
    }

    public void paivitaViimeksiPelattuVari(int pelaajanIndeksi, String vari) {
        this.pelaajienViimeksiPelaamatVarit[pelaajanIndeksi] = vari;
    }

    // pelitilanteesta tehdään kopio, jotta tekoäly ei pelitilannetta muuttaessaan
    // vaikuta oikeaan pelitilanteeseen
    public Pelitilanne kopio() {
        Pelitilanne kopio = new Pelitilanne(this.pelaajienKorttienLukumaarat.length);
        kopio.suunta = this.suunta;
        kopio.omaIndeksi = this.omaIndeksi;

        for (int i = 0; i < pelaajienKorttienLukumaarat.length; i++) {
            kopio.pelaajienKorttienLukumaarat[i] = this.pelaajienKorttienLukumaarat[i];
            kopio.pelaajienPisteet[i] = this.pelaajienPisteet[i];
            kopio.pelaajienViimeksiPelaamatVarit[i] = this.pelaajienViimeksiPelaamatVarit[i];
        }

        return kopio;
    }
}
