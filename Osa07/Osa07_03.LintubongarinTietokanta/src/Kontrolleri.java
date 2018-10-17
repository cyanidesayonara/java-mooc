import java.util.Scanner;

public class Kontrolleri {
    Scanner lukija;
    Havainnot havainnot;
    Lintukirja linnut;
    int onoff = 1;
    
    public Kontrolleri(Scanner lukija, Havainnot havainnot, Lintukirja linnut) {
        this.lukija = lukija;
        this.havainnot = havainnot;
        this.linnut = linnut;
    }
    
    public void lueKomento() {
        String komento = lukija.nextLine();
        if (komento.equals("Lisaa")) {
            lisaaLintu();
        }
        if (komento.equals("Havainto")) {
            lisaaHavainto();
        }
        if (komento.equals("Tilasto")) {
            naytaTilasto();
        }
        if (komento.equals("Nayta")) {
            naytaLintu();
        }
        if (komento.equals("Lopeta")) {
            lopeta();
        }
    }
    
    public void lisaaLintu() {
        System.out.print("Nimi: ");
        String nimi = lukija.nextLine();
        System.out.print("Latinankielinen nimi: ");
        String latNimi = lukija.nextLine();
        linnut.lisaaLintu(new Lintu(nimi, latNimi));
    }
    
    public void lisaaHavainto() {
        System.out.print("Mikä havaittu? ");
        String havainto = lukija.nextLine();
        if (linnut.haeLintu(havainto).isEmpty()) {
            System.out.println("Ei ole lintu!");
        } else {
            havainnot.lisaaHavainto(havainto);
        }
    }
    
    public void naytaLintu() {
        System.out.print("Mikä? ");
        String mika = lukija.nextLine();
        linnut.haeLintu(mika)
                .forEach(h -> System.out.println(h + "" + havainnot.havainnotMaara(h.getNimi()) + " havaintoa"));
    }
    
    public void naytaTilasto() {
        linnut.naytaLinnut()
                .forEach(l -> System.out.println(l + "" + havainnot.havainnotMaara(l.getNimi()) + " havaintoa"));
    }
    
    public void lopeta() {
        onoff = 0;
    }
    
    public int onOff() {
        return onoff;
    }
}
