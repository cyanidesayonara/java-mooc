
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Eriytymismalli {

    private int[][] taulukko;
    private int leveys;
    private int korkeus;

    private double prosAlueestaKaytossa;
    private int tyytyvaisyysraja;
    private int ryhmienLukumaara;

    private boolean kaynnissa;

    public Eriytymismalli(int leveys, int korkeus, int tyytyvaisyysraja, int ryhmienLukumaara, double prosAlueestaKaytossa) {
        this.leveys = leveys;
        this.korkeus = korkeus;

        this.taulukko = new int[korkeus][leveys];

        this.tyytyvaisyysraja = tyytyvaisyysraja;
        this.ryhmienLukumaara = ryhmienLukumaara;
        this.prosAlueestaKaytossa = prosAlueestaKaytossa;

        this.kaynnissa = false;
    }

    public void kaynnista() {
        this.kaynnissa = true;
    }

    public void sammuta() {
        this.kaynnissa = false;
    }

    public boolean onKaynnissa() {
        return this.kaynnissa;
    }

    public void asetaRyhmienLukumaara(int ryhmia) {
        this.ryhmienLukumaara = ryhmia;
    }

    public void asetaProsAlueestaKaytossa(double prosAlueestaKaytossa) {
        this.prosAlueestaKaytossa = prosAlueestaKaytossa;
    }

    public void asetaTyytyvaisyysRaja(int tyytyvaisyysraja) {
        this.tyytyvaisyysraja = tyytyvaisyysraja;

    }

    public void alusta() {
        tyhjennaTaulukko();
        arvoAlkuarvot();
    }

    public void tyhjennaTaulukko() {
        // Toteuta tänne taulukon tyhjentäminen (aseta jokaisen 
        // alkion arvoksi 0) 
        for (int x = 0; x < this.taulukko.length; x++) {
            for (int y = 0; y < this.taulukko[x].length; y++) {
                this.taulukko[x][y] = 0;
            }
        }
    }

    public void arvoAlkuarvot() {
        Random arpoja = new Random();

        for (int x = 0; x < this.taulukko.length; x++) {
            for (int y = 0; y < this.taulukko[x].length; y++) {
                // arvotaan ensin tuleeko kohtaan mitään

                // Random-luokan metodi nextDouble palauttaa satunnaisen luvun
                // nollan ja yhden välillä
                double satunnainenLukuNollanJaYhdenValilla = arpoja.nextDouble();

                // jos 100*arvo on suurempi kuin prosAlueestaKaytossa, ei 
                // paikkaan aseteta arvoa
                if (100 * satunnainenLukuNollanJaYhdenValilla > prosAlueestaKaytossa) {
                    continue;
                }

                // muulloin arvotaan kohtaan joku ryhmä
                // Random-luokan metodi nextInt(luku) antaa luvun välillä [0, luku[
                this.taulukko[x][y] = 1 + arpoja.nextInt(ryhmienLukumaara);
            }
        }
    }

    public int[][] annaData() {
        return this.taulukko;
    }

    public ArrayList<Piste> tyhjatPaikat() {
        ArrayList<Piste> tyhjat = new ArrayList<>();
        // Luo täällä lista, missä on kaikki tyhjät paikat piste-olioina.
        // Tyhjissä paikoissa on arvo 0
        for (int x = 0; x < this.taulukko.length; x++) {
            for (int y = 0; y < this.taulukko[x].length; y++) {
                if (this.taulukko[x][y] == 0) {
                    tyhjat.add(new Piste(x, y));
                }
            }
        }
        return tyhjat;
    }

    public void paivita() {
        ArrayList<Piste> tyytymattomat = haeTyytymattomat();

        if (tyytymattomat.isEmpty()) {
            return;
        }

        Collections.shuffle(tyytymattomat);

        while (!tyytymattomat.isEmpty()) {
            Piste tyytymaton = tyytymattomat.remove(0);

            ArrayList<Piste> tyhjat = tyhjatPaikat();
            Collections.shuffle(tyhjat);

            Piste tyhja = tyhjat.get(0);

            this.taulukko[tyhja.getX()][tyhja.getY()] = this.taulukko[tyytymaton.getX()][tyytymaton.getY()];
            this.taulukko[tyytymaton.getX()][tyytymaton.getY()] = 0;
        }
    }

    public ArrayList<Piste> haeTyytymattomat() {
        ArrayList<Piste> tyytymattomat = new ArrayList<>();
        // Etsi täällä tyytymättömät
        for (int x = 0; x < this.taulukko.length; x++) {
            for (int y = 0; y < this.taulukko[x].length; y++) {
                if (this.taulukko[x][y] == 0) {
                    continue;
                }
                int samat = etsiNaapurit(new Piste(x, y));
                if (samat < tyytyvaisyysraja) {
                    tyytymattomat.add(new Piste(x, y));
                }
            }
        }
        return tyytymattomat;
    }
                
    public int etsiNaapurit(Piste piste) {
        int samat = 0;
        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                if(i == 0 && j == 0) {
                    continue;
                }
                if(i + piste.getX() >= 0 && i + piste.getX() < this.taulukko.length &&
                   j + piste.getY() >= 0 && j + piste.getY() < this.taulukko[0].length) {
                    if (onSama(piste, new Piste(i + piste.getX(), j + piste.getY()))) {
                        samat++;
                    }
                }
            }
        }
        return samat;
    }
            
    public boolean onSama(Piste piste, Piste naapuri) {
        if (taulukko[naapuri.getX()][naapuri.getY()] == taulukko[piste.getX()][piste.getY()]) {
            return true;
        } else {
            return false;
        }
    }
}
