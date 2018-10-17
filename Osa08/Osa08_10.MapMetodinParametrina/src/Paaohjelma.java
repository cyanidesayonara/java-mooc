import java.util.Map;
import java.util.HashMap;
public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia
        Map<String, String> nimet = new HashMap<>();
        nimet.put("eka", "first");
        nimet.put("toka", "second");

        System.out.println(new HajautustaulunTarkistin().palautaKoko(nimet));
    }

}
