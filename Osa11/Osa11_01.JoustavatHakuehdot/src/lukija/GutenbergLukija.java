package lukija;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GutenbergLukija {

    private List<String> sanat;

    public GutenbergLukija(String osoite) {
        sanat = new ArrayList<>();

        try (Scanner lukija = new Scanner(new URL(osoite).openStream())) {
            while (lukija.hasNextLine()) {
                sanat.add(lukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

    public List<String> rivitJoilleVoimassa(Predicate<String> ehto) {
        return this.sanat.stream().filter(ehto).collect(Collectors.toList());
    }
}
