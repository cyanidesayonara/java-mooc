package lukija.ehdot;

import java.util.function.Predicate;

public class SisaltaaSanan implements Predicate<String> {

    private String sana;

    public SisaltaaSanan(String sana) {
        this.sana = sana;
    }

    @Override
    public boolean test(String rivi) {
        return rivi.contains(sana);
    }

}
