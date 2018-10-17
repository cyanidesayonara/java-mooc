package lukija;

import java.util.function.Predicate;
import lukija.ehdot.*;

public class Main {

    public static void main(String[] args) {
    Predicate<String> sanat = new VahintaanYksi(
    new SisaltaaSanan("jalokivi"),
    new SisaltaaSanan("kulta"),
    new SisaltaaSanan("hopea")
    );

    Predicate<String> oikeaPituus = new Molemmat(
        new PituusVahintaan(20),
        new Ei(new PituusVahintaan(31))
    );

    Predicate halutut = new Molemmat(sanat, oikeaPituus);
    }
}
