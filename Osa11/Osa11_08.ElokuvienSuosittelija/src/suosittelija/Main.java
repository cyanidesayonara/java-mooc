package suosittelija;

import suosittelija.domain.Arvio;
    import suosittelija.domain.Elokuva;
import suosittelija.domain.Henkilo;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Testaa luokkiesi toteutusta täällä
        ArvioRekisteri arviot = new ArvioRekisteri();

        Elokuva tuulenViemaa = new Elokuva("Tuulen viemää");
        Elokuva hiljaisetSillat = new Elokuva("Hiljaiset sillat");
        Elokuva eraserhead = new Elokuva("Eraserhead");
        Elokuva bluesBrothers = new Elokuva("Blues Brothers");

        Henkilo matti = new Henkilo("Matti");
        Henkilo pekka = new Henkilo("Pekka");
        Henkilo mikke = new Henkilo("Mikael");
        Henkilo thomas = new Henkilo("Thomas");
        Henkilo arto = new Henkilo("Arto");

        arviot.lisaaArvio(matti, tuulenViemaa, Arvio.HUONO);
        arviot.lisaaArvio(matti, hiljaisetSillat, Arvio.HYVA);
        arviot.lisaaArvio(matti, eraserhead, Arvio.OK);

        arviot.lisaaArvio(pekka, tuulenViemaa, Arvio.OK);
        arviot.lisaaArvio(pekka, eraserhead, Arvio.HUONO);
        arviot.lisaaArvio(pekka, bluesBrothers, Arvio.VALTTAVA);

        arviot.lisaaArvio(mikke, eraserhead, Arvio.HUONO);

        arviot.lisaaArvio(thomas, bluesBrothers, Arvio.HYVA);
        arviot.lisaaArvio(thomas, hiljaisetSillat, Arvio.HYVA);

        Suosittelija suosittelija = new Suosittelija(arviot);
        System.out.println(pekka + " suositus: " + suosittelija.suositteleElokuva(pekka));
        System.out.println(thomas + " suositus: " + suosittelija.suositteleElokuva(thomas));
        System.out.println(mikke + " suositus: " + suosittelija.suositteleElokuva(mikke));
        System.out.println(matti + " suositus: " + suosittelija.suositteleElokuva(matti));
        System.out.println(arto + " suositus: " + suosittelija.suositteleElokuva(arto));
    }
}
